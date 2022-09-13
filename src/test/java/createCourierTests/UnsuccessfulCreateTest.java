package createCourierTests;

import courier.Courier;
import courier.CourierClient;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testData.TestData;

@RunWith(Parameterized.class)
public class UnsuccessfulCreateTest {
    private final String login;
    private final String password;
    private final String firstname;
    private final int expected;


    public UnsuccessfulCreateTest (String login, String password, String firstname, int expected) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        TestData testData = new TestData();
        return new Object[][]{
                {RandomStringUtils.randomAlphanumeric(10), "", RandomStringUtils.randomAlphanumeric(10), testData.get_400()},
                {"", RandomStringUtils.randomAlphanumeric(10), RandomStringUtils.randomAlphanumeric(10), testData.get_400()},
                {"", "", RandomStringUtils.randomAlphanumeric(10), testData.get_400()},
                {"", "", "", testData.get_400()},
                {RandomStringUtils.randomAlphanumeric(10), null, RandomStringUtils.randomAlphanumeric(10), testData.get_400()},
                {null, RandomStringUtils.randomAlphanumeric(10), RandomStringUtils.randomAlphanumeric(10), testData.get_400()},
                {null, null, RandomStringUtils.randomAlphanumeric(10), testData.get_400()},
                {null, null, null, testData.get_400()}
        };
    }

    @Description("Unsuccessful courier creation tests. Some necessary data is missing")
    @Test
    public void unsuccessfulCreateTest() {
        CourierClient courierClient = new CourierClient();
        courierClient.createCourier(new Courier(login, password, firstname))
                .statusCode(expected);
    }
}
