package msdemo.resources;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import msdemo.models.Token;
import msdemo.models.User;
import msdemo.utils.KeyUtil;
import msdemo.utils.TokenUtil;
/**
 * 登入接口
 * {方式：GET 路径：/login 登陆的主要接口}
 * @author tody
 * @version v1.0
 * @time 2017年4月13日9:22:13
 *
 */
@PermitAll()
@Path("/login")
public class LoginResource {
    @Context
    ServletContext              context;

    /**
     * author：tody
     * Date:2017年4月13日10:58:19
     * @param username 用户名
     * @param password 密码
     * @return
     * 资源验证入口
     */
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    // 进入验证方法的接口
    public Response authenticateUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        // 设置这个token的生命时间1天的有效日期
        Date expiry = getExpiryDate(24 * 60);
        // 验证账号密码是否正确
        User user = authenticate(username, password);
        //token生成
        String jwtString = TokenUtil.getJWTString(username, expiry, KeyUtil.getKey(context));
        //这是token的实体化类，用来返回给用户
        Token  token     = new Token();
        token.setAuthToken(jwtString);
        token.setExpires(expiry);
        return Response.ok(token).build();
    }

    /**
     * author：tody
     * Date:2017年4月13日10:58:19
     * version:1.0
     * @param minutes
     * @return
     * 生命时间设置
     */
    private Date getExpiryDate(int minutes) {

        // 根据当前日期，来得到到期日期
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, minutes);

        return calendar.getTime();
    }

    /**
     * author：TODY
     * Date:2017年4月13日10:35:57
     * version:1.0
     * @param username
     * @param password
     * @throws NotAuthorizedException
     * 在这个方法中实现验证用户账号密码，如果错误就抛出未验证信息，如果正确就返回一个用户
     */
    private User authenticate(String username, String password) throws NotAuthorizedException {
        // User user = null;
        //测试使用，没有做JDBC的操作
    	User user = new User();
    	user.setUserID("admin");
    	user.setPassword("123");
        //EDN
        if (user == null) {
            throw new NotAuthorizedException("Invalid telpone '" + username + "' ");
        }

        if (user.getPassword().equals(password)) {
        } else {
            throw new NotAuthorizedException("Invalid username or password");
        }

        return user;
    }
}
