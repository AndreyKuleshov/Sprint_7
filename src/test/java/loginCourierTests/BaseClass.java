package loginCourierTests;

import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import org.junit.After;
import org.junit.Before;
import testData.TestData;

public class BaseClass {
    Courier courier;
    TestData testData = new TestData();
    CourierClient courierClient = new CourierClient();
    CourierCredentials creds;
    CourierCredentials nonexistentCourier = CourierCredentials.from(Courier.getRandomCourier());
    int id;

    @Before
    public void setUp() {
        courier = Courier.getRandomCourier();
        courierClient.createCourier(courier).statusCode(testData.get_201());
        creds = CourierCredentials.from(courier);
    }

    @After
    public void cleanUp() {
        if (id == 0) id = courierClient.getCourierId(CourierCredentials.from(courier));
        courierClient.deleteCourier(id);
    }

}
