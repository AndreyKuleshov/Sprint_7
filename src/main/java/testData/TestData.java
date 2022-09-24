package testData;

import lombok.Data;

import java.util.Random;

@Data
public class TestData {
    Random random = new Random();
    private final String OK_PATH = "ok";
    private final String ID_PATH = "id";
    private final int _200 = 200;
    private final int _201 = 201;
    private final int _400 = 400;
    private final int _404 = 404;
    private final int _409 = 409;
    private final String BLACK = "BLACK";
    private final String GREY = "GREY";
    private final String TRACK_PATH = "track";
    private final String ORDERS_PATH = "orders";
    private final int ORDERS_LIMIT = random.nextInt(10) + 1;
    private final String WRONG_LOGIN = "O_o";
    private final String WRONG_PASSWORD = "XXX";
}
