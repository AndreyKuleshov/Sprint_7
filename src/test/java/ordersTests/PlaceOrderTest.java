package ordersTests;

import io.qameta.allure.Description;
import order.OrderToSend;
import order.OrderClient;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testData.TestData;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class PlaceOrderTest {
    private final List<String> COLOR;
    private final int EXPECTED;
    private int trackNumber;
    OrderClient order = new OrderClient();



    public PlaceOrderTest(List<String> color, int expected) {
        this.COLOR = color;
        this.EXPECTED = expected;
    }
        static TestData testData = new TestData();

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {List.of(), testData.get_201()},
                {List.of(testData.getBLACK()), testData.get_201()},
                {List.of(testData.getGREY()), testData.get_201()},
                {List.of(testData.getBLACK(), testData.getGREY()), testData.get_201()}
        };
    }

    @Description("Successful order creation test passing different scooters colors")
    @Test
    public void unsuccessfulCreateTest() {
        trackNumber = order.placeOrder(OrderToSend.getOrder(COLOR))
                .statusCode(EXPECTED)
                .body(testData.getTRACK_PATH(), notNullValue())
                .and()
                .extract().path(testData.getTRACK_PATH());
    }
    @After
    public void cancelOrderForCleanup() {
        order.cancelOrder(trackNumber)
                .statusCode(testData.get_200());
    }
}