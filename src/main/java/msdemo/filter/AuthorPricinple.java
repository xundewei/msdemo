package msdemo.filter;

import java.security.Principal;

/**
 * @Author: TODY
 * @Version: V1.00 
 * @Create Date: 2017年4月13日11:29:23
 * @Description:
 */
public class AuthorPricinple implements Principal {
    private String name;

    public AuthorPricinple(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }
}
