package ordersTests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import order.OrderClient;
import order.OrderReceived;
import org.junit.Assert;
import org.junit.Test;
import testData.TestData;

import java.util.List;

public class OrdersListTest {
    OrderClient order = new OrderClient();
    TestData testData = new TestData();

    @Description("Check that orders list > 0")
    @DisplayName("Get Orders List response contains orders")
    @Test
    public void checkOrderList() {
        List<OrderReceived> orders = order.getOrderList()
                .statusCode(200)
                .extract().body().jsonPath().getList(testData.getORDERS_PATH(), OrderReceived.class);
        Assert.assertTrue(orders.size() > 0);
    }
    @Description("Orders number should be equal to sent parameter")
    @DisplayName("Get Orders List response contains defined number of orders")
    @Test
    public void checkLimitedOrderList() {
        int limit = testData.getORDERS_LIMIT();
        List<OrderReceived> orders = order.getOrderList(limit)
                .statusCode(200)
                .extract().body().jsonPath().getList(testData.getORDERS_PATH(), OrderReceived.class);
        Assert.assertEquals(orders.size(), limit);
    }

}
