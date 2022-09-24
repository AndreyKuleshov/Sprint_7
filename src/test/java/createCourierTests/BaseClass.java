package createCourierTests;

import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import org.junit.After;
import org.junit.Before;
import testData.TestData;

public class BaseClass {
    Courier courier;
    CourierClient courierClient = new CourierClient();
    TestData testData = new TestData();
    int id;

    @Before
    public void setUp() {
        courier = Courier.getRandomCourier();
    }

    @After
    public void cleanUp() {
        id = courierClient.getCourierId(CourierCredentials.from(courier));
        courierClient.deleteCourier(id);
    }
}
