package loginCourierTests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;

public class LoginCourierTest extends BaseClass{
    @Description("Successful login")
    @DisplayName("Courier logins successfully")
    @Test
    public void courierLoginSuccessTest() {
        id = courierClient.loginCourier(creds)
                .statusCode(testData.get_200())
                .body(testData.getID_PATH(), notNullValue())
                .extract().path(testData.getID_PATH());
    }

    @Description("Unsuccessful login with wrong login")
    @DisplayName("Courier can't login with wrong login")
    @Test
    public void courierLoginWrongLoginTest() {
        creds.setLogin(testData.getWRONG_LOGIN());
        courierClient.loginCourier(creds)
                .statusCode(testData.get_404());
    }

    @Description("Unsuccessful login with wrong password")
    @DisplayName("Courier can't login with wrong password")
    @Test
    public void courierLoginWrongPasswordTest() {
        creds.setPassword(testData.getWRONG_PASSWORD());
        courierClient.loginCourier(creds)
                .statusCode(testData.get_404());
    }

    @Description("Unsuccessful login with nonexistent courier")
    @DisplayName("Courier can't login with wrong login and password")
    @Test
    public void courierLoginWrongLoginAndPasswordTest() {
        courierClient.loginCourier(nonexistentCourier)
                .statusCode(testData.get_404());
    }

    @Description("Unsuccessful login without login")
    @DisplayName("Courier can't login without login")
    @Test
    public void courierLoginNoLoginTest() {
        creds.setLogin(null);
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }
    @Description("Unsuccessful login without password")
    @DisplayName("Courier can't login without password")
    @Test
    public void courierLoginNoPasswordTest() {
        creds.setPassword(null);
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without login and password")
    @DisplayName("Courier can't login without login and password")
    @Test
    public void courierLoginNoLoginAndPasswordTest() {
        creds.setLogin(null);
        creds.setPassword(null);
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without login")
    @DisplayName("Courier can't login with blank login")
    @Test
    public void courierLoginBlankLoginTest() {
        creds.setLogin("");
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without password")
    @DisplayName("Courier can't login with blank password")
    @Test
    public void courierLoginBlankPasswordTest() {
        creds.setPassword("");
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }

    @Description("Unsuccessful login without login and password")
    @DisplayName("Courier can't login with blank login and blank password")
    @Test
    public void courierLoginBlankLoginAndPasswordTest() {
        creds.setLogin("");
        creds.setPassword("");
        courierClient.loginCourier(creds)
                .statusCode(testData.get_400());
    }
}
