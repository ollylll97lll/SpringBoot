package com.example.DemoSpringBoot.controllerz.publIc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.ValidateOTP;
import com.example.DemoSpringBoot.services.serviceClasses.OTPMailService;
import com.example.DemoSpringBoot.templates.OTPRequestBodyTemplate;

@RestController
@RequestMapping("api/v1/public/otps")
@Transactional
public class OTPController {
    @Autowired
    private OTPMailService otpService;

    @PostMapping(value = "/verify/mail")
    public void sendMailOTPUser(@RequestBody OTPRequestBodyTemplate OTP) throws Exception {
        otpService.sendMailOTPUser(OTP.getReceiver(), OTP.getFullname(),
                OTP.getSubject());
    }

    @PostMapping(value = "/validate/mail")
    public String validateMailOTPUser(@RequestBody ValidateOTP validateOTP)
            throws Exception {
        return otpService.validateMailOTPUser(validateOTP.getOTP(),
                validateOTP.getEmail());
    }
}
