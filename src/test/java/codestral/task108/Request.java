package codestral.task108;

import java.io.Serializable;

public class Request implements Serializable {
    public String action;
    public Integer value;

    public Request(String action, Integer value) {
        this.action = action;
        this.value = value;
    }
}
