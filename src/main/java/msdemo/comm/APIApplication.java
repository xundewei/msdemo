package msdemo.comm;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import msdemo.filter.SecurityFilter;
import msdemo.resources.BookResource;
import msdemo.resources.LoginResource;
import msdemo.resources.UserResource;
/**
 * 配置相关资源信息
 * @author tody
 * @version v1.0
 * @time 2017年4月13日9:01:41
 *
 */
public class APIApplication extends ResourceConfig {
    public APIApplication() {
    	register(SecurityFilter.class);
        //注册登入Resource
        register(LoginResource.class);
      //注册登入Resource
        register(UserResource.class);
      //注册登入Resource
        register(BookResource.class);
        //注册数据转换器
        register(JacksonJsonProvider.class);

    }
}