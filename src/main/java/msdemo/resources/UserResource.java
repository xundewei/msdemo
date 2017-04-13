package msdemo.resources;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import msdemo.models.User;
import msdemo.resources.exception.AppException;

/**
 * @Author: TODY
 * @Version: V1.00
 * @Create Date: 2017年4月13日12:37:19
 * @Description:User的资源类
 */
@PermitAll
@Path("user")
public class UserResource {

    /**
     * 查询该账号
     */
    @GET
    @Path("queryuser")
    public String checkLoginRegist(@QueryParam("username") String username){
        if(username!=null){
           if("admin".equals(username)) {
               return "正确登入！";
           }
            return "输入正确的用户名！";
        }
        return "用户名不能为空！！";
    }
    /**
     * 注册该账号
     * @param user
     * 未被注册且注册成功就返回该user
     *
     */
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    @Path("regist")
    public Response registUser(@QueryParam("username") String username,@QueryParam("password") String password) throws AppException{
        String message="";
        if(1==1){
        	User user=new User();
        	user.setUserID(username);
        	user.setPassword(password);
            return Response.ok(username+"_____注册成功").build();
        }
        else {
            message="user has regeisted";
            throw new AppException(409,1005,"link",message,message);
        }
    }

}
