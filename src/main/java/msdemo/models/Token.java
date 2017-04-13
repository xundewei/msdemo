package msdemo.models;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import msdemo.utils.JaxbDateSerializer;

/**
 * @Name:
 * @Author: TODY
 * @Version: V1.00 
 * @Create Date: 2017年4月13日18:01:47
 * @Description:TOKEN的资源实体类
 */
@XmlRootElement
public class Token implements Serializable {
    @XmlElement(name = "auth_token")
    private String authToken;
    @XmlElement(name = "expires")
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date expires;
    public Token(){


    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
}
