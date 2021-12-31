package entity;

import java.io.Serializable;

/**
 * 用于向页面传递信息的类
 *
 * @author zhangyu
 */
public class Result implements Serializable {

    /**
     * 结果状态
     */
    private boolean success;
    /***
     * 结果标记
     */
    private boolean flag;
    /**
     * 消息信息
     */
    private String message;

    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.flag = success;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
