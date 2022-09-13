package createCourierTests;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;

public class CreateTest extends BaseClass {
    @Description("Courier can be created")
    @Test
    public void createCourierTest() {
        boolean isOk = courierClient.createCourier(courier)
                .statusCode(testData.get_201())
                .extract().path(testData.getOK_PATH());
        Assert.assertTrue(isOk);
    }

    @Description("Courier can be created without firstname")
    @Test
    public void createCourierWithoutFirstnameTest() {
        courier.setFirstname(null);
        boolean isOk = courierClient.createCourier(courier)
                .statusCode(testData.get_201())
                .extract().path(testData.getOK_PATH());
        Assert.assertTrue(isOk);    }

    @Description("Courier can not be created with blank firstname")
    @Test
    public void createCourierWithBlankFirstnameTest() {
        courier.setFirstname("");
        boolean isOk = courierClient.createCourier(courier)
                .statusCode(testData.get_201())
                .extract().path(testData.getOK_PATH());
        Assert.assertTrue(isOk);    }

    @Description("Creating of two identical couriers is prohibited")
    @Test
    public void createTwoIdenticalCouriersFailTest() {
        courierClient.createCourier(courier)
                .statusCode(testData.get_201());
        courierClient.createCourier(courier)
                .statusCode(testData.get_409());
    }
}
