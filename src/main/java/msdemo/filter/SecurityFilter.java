package msdemo.filter;/**
						* Created by lizhaoz on 2015/11/30.
						*/

import java.io.IOException;
import java.security.Key;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ContainerRequest;

import msdemo.utils.KeyUtil;
import msdemo.utils.TokenUtil;

/**
 * @Author: TODY
 * @Version: V1.00 
 * @Create Date: 2017年4月13日10:17:33
 * @Description:TOKEN 管理类
 */
@Provider
@Priority(Priorities.AUTHENTICATION) // 优先级最高
// 实现该拦截器借口
public class SecurityFilter implements ContainerRequestFilter {
	Key key;

	@Context
	ServletContext context;
	@Inject
	javax.inject.Provider<UriInfo> uriInfo;

	public static String extractJwtTokenFromAuthorizationHeader(String auth) {
		return auth.replaceFirst("[B|b][E|e][A|a][R|r][E|e][R|r] ", "").replace(" ", "");
	}

	// 重写验证过滤器
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		// 获取本地的私钥
		Key key = KeyUtil.getKey(context);
		// 得到访问的方法 例如GET,POST
		String method = containerRequestContext.getMethod().toLowerCase();
		// 得到访问路径
		String path = ((ContainerRequest) containerRequestContext).getPath(true).toLowerCase();
		// 验证资源直接跳过
		if (("post".equals(method) && "login".equals(path)) || ("get".equals(method) && "user/queryuser".equals(path))
				|| ("post".equals(method) && "user/regist".equals(path))) {
			containerRequestContext.setSecurityContext(
					new SecurityContextAuthorizer(uriInfo, new AuthorPricinple("admin"), new String[] { "admin" }));
			return;
		}
		// 获取头信息中的token
		String authorizationHeader = ((ContainerRequest) containerRequestContext).getHeaderString("auth_token");
		// 如果token为空抛出
		if (authorizationHeader == null) {

			throw new WebApplicationException(Response.Status.UNAUTHORIZED);// 抛出未认证的错误
		}
		// 把Bear Token换成Token
		String strToken = extractJwtTokenFromAuthorizationHeader(authorizationHeader);
		if (TokenUtil.isValid(strToken, key)) {
			String name = TokenUtil.getName(strToken, key);// 反解出Name
			String[] roles = TokenUtil.getRoles(strToken, key);// 反解出角色
			int version = TokenUtil.getVersion(strToken, key);// 得到版本
			if (name != null && roles.length != 0 && version != -1) {
				if (name.equals("admin")) {
					containerRequestContext.setSecurityContext(
							new SecurityContextAuthorizer(uriInfo, new AuthorPricinple(name), new String[] { "user" }));
					return;
				}
			}

		}
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}
}
