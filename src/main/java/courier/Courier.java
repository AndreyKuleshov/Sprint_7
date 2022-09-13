package courier;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class Courier {
    private String login;
    private String password;
    private String firstname;

    public Courier(String login, String password, String firstname) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
    }
    public static Courier getRandomCourier() {
        return new Courier(
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphabetic(10)
        );
    }
}
