package y2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Jim
 * /challenges/jim-and-the-orders/problem
 */
public class Jim {
    static int[] jimOrders(int[][] orders) {
        class CustomerOrder{
            int customer;
            int order;
        }
        CustomerOrder[] customer = new CustomerOrder[orders.length];

        for(int i = 0; i < orders.length; i++){
            customer[i] = new CustomerOrder();
            customer[i].customer = i+1;
            customer[i].order = orders[i][0] + orders[i][1];
        }

        Arrays.sort(customer, Comparator.comparing(c->c.order));

        return Arrays.stream(customer).mapToInt(c->c.customer).toArray();

    }
}
