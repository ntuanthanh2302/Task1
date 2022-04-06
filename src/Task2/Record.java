package Task2;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private String phone;
    private String mess;
    private String date;

    public Record(String phone, String mess, String date) {
        this.phone = phone;
        this.mess = mess;
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
