package courier;

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
                .then().log().all();
    }

    public int getCourierId(CourierCredentials credentials) {
        return loginCourier(credentials)
                .extract().path(testData.getID_PATH());
    }
    public ValidatableResponse deleteCourier(int id) {
        return getSpec()
                .pathParam(testData.getID_PATH(), id)
                .delete(DELETE)
                .then();
    }
}
