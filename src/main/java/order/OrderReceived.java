package order;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class OrderReceived {
    private int id;
    private Object courierId;
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private Date deliveryDate;
    private int track;
    private ArrayList<String> color;
    private String comment;
    private Date createdAt;
    private Date updatedAt;
    private int status;

    public OrderReceived(){}
}
