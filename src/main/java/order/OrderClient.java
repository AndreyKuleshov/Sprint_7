package order;

import config.BaseClient;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class OrderClient extends BaseClient {
    protected final String CREATE = "/orders";
    protected final String CANCEL = "/orders/cancel";
    protected final String TRACK_PARAM = "track";
    protected final String LIMIT_PARAM = "limit";

    public ValidatableResponse placeOrder(OrderToSend order){
        return getSpec()
                .body(order)
                .post(CREATE)
                .then();
    }
    public ValidatableResponse cancelOrder(int trackNumber) {
        return getSpec()
                .queryParam(TRACK_PARAM, trackNumber)
                .put(CANCEL)
                .then();
    }
    public ValidatableResponse getOrderList() {
        return getSpec()
                .get(CREATE)
                .then();
    }
    public ValidatableResponse getOrderList(int limit) {
        return getSpec()
                .queryParams(createParams(limit))
                .get(CREATE)
                .then();
    }
    private Map<String, Integer> createParams(int limit) {
        return Map.of(LIMIT_PARAM, limit);
    }
}
