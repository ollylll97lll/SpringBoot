import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Pair {
    public int origin;
    public int destination;

    public Pair(int origin, int destination) {
        // This keyword refers to current instance
        this.origin = origin;
        this.destination = destination;
    }
}

public class App {

    public static int binarySearch(List<Integer> arr, int val) {
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = (high + low) / 2;

            if (val >= arr.get(mid)) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return low;
    }

    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        teamA.sort(null);
        List<Integer> returnArr = new ArrayList<>();
        for (Integer valB : teamB) {
            int times = binarySearch(teamA, valB);
            returnArr.add(times);
        }
        return returnArr;
    }

    public static int CountPair(List<Integer> numbers, int i) {
        List<Integer> reduced = numbers.stream().distinct().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        int counter = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int j = 0; j < reduced.size(); j++) {
            int a = reduced.get(j);
            int b = a + i;
            // O(n^2)
            // for(int k = j+1; k < reduced.size(); k++){
            // if(reduced.get(k)==b){
            // System.out.println("pair " + reduced.get(j) +":"+ reduced.get(k));
            // counter++;
            // }
            // }
            if (set.contains(a - i)) {
                System.out.println("pair " + reduced.get(j) + ":" + (a - i));
                counter++;
            }
            set.add(a);

        }
        return counter;
    }

    public static int ucln(int a, int b) {
        if (b > a) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        while (a > 0) {
            int t = b % a;
            b = a;
            a = t;
        }
        return b;
    }

    public static List<Integer> connectedCities(int numCities, int threshold,
            List<Integer> originCities,
            List<Integer> destinationCities) {
        List<Integer> returnArr = new ArrayList<>();
        HashMap<Integer, List<Integer>> checkMap = new HashMap<>();
        int length = originCities.size();

        // first loop initiate checkmap
        for (int i = 0; i < length; i++) {
            int oCity = originCities.get(i);
            int dCity = destinationCities.get(i);
            int gcd = ucln(oCity, dCity);
            // System.out.println("ucln " + gcd);
            if (gcd > threshold) {
                returnArr.add(1);
                if (checkMap.containsKey(oCity)) {
                    checkMap.get(oCity).add(dCity);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(dCity);
                    checkMap.put( oCity, list);
                }
                if (checkMap.containsKey(dCity)) {
                    checkMap.get(dCity).add(oCity);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(oCity);
                    checkMap.put( dCity, list);
                }
            } else {
                // check if max divisor of either city is less than threshold.
                if (oCity <= threshold || dCity <= threshold) {
                    returnArr.add(0);
                } else
                    returnArr.add(-1);
            }
            System.out.println("checkmap: "+checkMap);
        }
        // recheck not connected (-1) connections
        for (int index = 0; index < returnArr.size(); index++) {
            int value = returnArr.get(index);
            if (value != -1) {
                continue;
            }
            System.out.println(originCities.get(index)+":"+destinationCities.get(index));
            List<Integer> oConnected = checkMap.get(originCities.get(index));
            List<Integer> dConnected = checkMap.get(destinationCities.get(index));
            System.out.println(oConnected + ":" + dConnected);
            if(oConnected == null || dConnected == null){
                returnArr.set(index, 0);
                continue;
            }
            if (oConnected.retainAll(dConnected)) {
                returnArr.set(index, 1);
            } else {
                returnArr.set(index, 0);
            }
        }
        return returnArr;
    }

    public static void main(String[] args) throws Exception {
        // List<Integer> numbers = Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 9,
        // 9, 9, 7, 7, 7);

        // List<Integer> teamA = Arrays.asList(1,2,3,1,63,4,8,67,4);
        // List<Integer> teamB = Arrays.asList(2,2,4,2435,6,10,423,624);

        List<Integer> originCities = Arrays.asList(1, 2, 3, 4, 3);
        List<Integer> destinationCities = Arrays.asList(4, 5, 6, 6, 4);

        // System.out.println(CountPair(numbers, 1));
        // System.out.println(counts(teamA, teamB));
        System.out.println(connectedCities(6, 1, originCities, destinationCities));
    }
}
