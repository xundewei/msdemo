package msdemo.resources.exception;

/**
 * @Author: TODY
 * @Version: V1.00 
 * @Create Date:2017年4月13日12:41:12
 * @Description:
 * 用来抛出自定义异常
 */
public class AppException extends Exception{
    private static final long serialVersionUID = -8999932578270387947L;
    //Http状态码
    Integer status;
    //自定义错误代码，用来给用户显示
    int code;
    //错误链接，指向错误位置
    String link;
    //错误信息
    String errorMessage;
    public AppException(){

    }
    public AppException(Integer status, int code, String link, String errorMessage,String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.link = link;
        this.errorMessage = errorMessage;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String message) {
        errorMessage = message;
    }
}
