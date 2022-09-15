package courier;

import config.BaseClient;
import io.restassured.response.ValidatableResponse;
import testData.TestData;

public class CourierClient extends BaseClient {
    protected final String CREATE = "/courier";
    protected final String LOGIN = "/courier/login";
    protected final String DELETE = "/courier/{id}";
    TestData testData = new TestData();
    public ValidatableResponse createCourier(Courier courier) {
        return getSpec()
                .body(courier)
                .post(CREATE)
                .then();
    }

    public ValidatableResponse loginCourier(CourierCredentials credentials) {
        return getSpec()
                .body(credentials)
                .post(LOGIN)
                .then();
    }

    public int getCourierId(CourierCredentials credentials) {
        return loginCourier(credentials)
                .extract().path(testData.getID_PATH());
    }
    public void deleteCourier(int id) {
        getSpec()
                .pathParam(testData.getID_PATH(), id)
                .delete(DELETE)
                .then();
    }
}
