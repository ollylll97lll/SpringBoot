package com.r00t.orderserv.services.serviceClasses;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.r00t.orderserv.entities.OrderDetails;
import com.r00t.orderserv.entities.Orders;
import com.r00t.orderserv.mappers.OrderDetailsMapper;
import com.r00t.orderserv.mappers.OrdersMapper;
import com.r00t.orderserv.models.DTO.OrderDetailsDTO;
import com.r00t.orderserv.models.DTO.OrdersDTO;
import com.r00t.orderserv.models.DTO.requestbody.CreateOrderRequest;
import com.r00t.orderserv.models.DTO.responsebody.ItemDTO;
import com.r00t.orderserv.models.DTO.responsebody.UserDTO;
import com.r00t.orderserv.repositories.OrderDetailsRepository;
import com.r00t.orderserv.repositories.OrdersRepository;
import com.r00t.orderserv.services.Impl.DetailServiceImpl;
import com.r00t.orderserv.services.Impl.OrderServiceImpl;

@Service
public class OrderService implements OrderServiceImpl, DetailServiceImpl {

    private final RabbitTemplate rabbitTemplate;

    public OrderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    private OrdersMapper oMapper;
    @Autowired
    private OrdersRepository oRepository;
    @Autowired
    private OrderDetailsMapper dMapper;
    @Autowired
    private OrderDetailsRepository dRepository;

    @Value("user.service.url")
    private String userServiceURL;

    @Value("item.service.url")
    private String itemServiceURL;

    @Override
    public OrderDetailsDTO createDetail(UUID orderID, ItemDTO item, int quantity) throws Exception {
        Optional<Orders> order = oRepository.findById(orderID);
        if (order.isEmpty()) {
            throw new Exception("No order found with orderID: " + orderID);
        }
        OrderDetails details = new OrderDetails();
        details.setID(UUID.randomUUID());
        details.setItemID(item.getItemID());
        details.setOrders(order.get());
        details.setStatus("created");
        details.setQuantity(quantity);
        updateQuantity(new ItemDTO(new BigInteger(String.valueOf(quantity)), item.getItemID()));
        OrderDetails returnDetail = dRepository.save(details);
        return dMapper.detail2DTO(returnDetail);
    }

    @Override
    public OrderDetailsDTO updateDetails(UUID detailID, String status) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrdersDTO createOrder(CreateOrderRequest cRequest) throws Exception {
        // send data to userServ
        UserDTO user = checkUser(cRequest.getUserID());
        ItemDTO item = checkItem(cRequest);

        if (item.getQuantity().intValue() < cRequest.getQuantity()) {
            throw new Exception("not enough quantity of this item");
        }

        // create new Order base on request
        Orders order = new Orders();
        order.setID(UUID.randomUUID());
        order.setUserID(user.getId());
        order.setStatus("created");
        order.setComment(cRequest.getComment());

        Orders responseOrder = oRepository.save(order);

        createDetail(responseOrder.getID(), item, cRequest.getQuantity());

        return oMapper.order2DTO(responseOrder);
    }

    @Override
    public OrdersDTO updateOrder(OrdersDTO order) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    private UserDTO checkUser(int userID) throws Exception {
        String url = "http://localhost:8100/api/v1/public/users/" + String.valueOf(userID);
        try {
            UserDTO res = new RestTemplate().getForObject(url, UserDTO.class);
            System.out.println("User: " + res);
            return res;
        } catch (Exception e) {
            throw e;
        }
    }

    private ItemDTO checkItem(CreateOrderRequest cRequest) throws Exception {
        String url = "http://localhost:8200/api/v1/public/items/" + String.valueOf(cRequest.getItemID());

        try {
            ItemDTO res = new RestTemplate().getForObject(url,
                    ItemDTO.class);
            System.out.println("Item: " + res);
            return res;
        } catch (Exception e) {
            throw e;
        }
    }
    private void updateQuantity(ItemDTO item) throws Exception {

        rabbitTemplate.convertAndSend("TOPIC_EXCHANGE", "*.item.*", item);
    }
}
