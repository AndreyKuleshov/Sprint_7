package loginCourierTests;

import io.qameta.allure.Description;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;

public class LoginCourierTest extends BaseClass{
    @Description("Successful login")
    @Test
    public void courierLoginSuccessTest() {
        id = courierClient.loginCourier(creds)
                .statusCode(testData.get_200())
                .body(testData.getID_PATH(), notNullValue())
                .extract().path(testData.getID_PATH());
    }

    @Description("Unsuccessful login with wrong login")
    @Test
    public void courierLoginWrongLoginTest() {
        creds.setLogin("O_o");
        courierClient.loginCourier(creds)
                .statusCode(testData.get_404());
    }

    @Description("Unsuccessful login with wrong password")
    @Test
    public void courierLoginWrongPasswordTest() {
        creds.setPassword("XXX");
        courierClient.loginCourier(creds)
                .statusCode(testData.get_404());
    }

    @Description("Unsuccessful login with nonexistent courier")
    @Test
    public void courierLoginWrongLoginAndPasswordTest() {
        courierClient.loginCourier(nonexistentCourier)
                .statusCode(testData.get_404());
    }

    @Description("Unsuccessful login without login")
    @Test
    public void courierLoginNoLoginTest() {
        creds.setLogin(null);
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without password")
    @Test
    public void courierLoginNoPasswordTest() {
        creds.setPassword(null);
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without login and password")
    @Test
    public void courierLoginNoLoginAndPasswordTest() {
        creds.setLogin(null);
        creds.setPassword(null);
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without login")
    @Test
    public void courierLoginBlankLoginTest() {
        creds.setLogin("");
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without password")
    @Test
    public void courierLoginBlankPasswordTest() {
        creds.setPassword("");
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without login and password")
    @Test
    public void courierLoginBlankLoginAndPasswordTest() {
        creds.setLogin("");
        creds.setPassword("");
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }
}
