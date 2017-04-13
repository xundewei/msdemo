package msdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: TODY
 * @Version: V1.00
 * @Create Date: 2017年4月13日17:35:27
 * @Description:测试相关功能
 */

public class SimpleClient {

	/**
	 * GET 方式  测试 参数在URL中
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String httpGet(String url) throws Exception {
		HttpGet httpget = new HttpGet(url);
		CloseableHttpClient client = HttpClients.createDefault();
		String respContent = null;
		HttpResponse resp = client.execute(httpget);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}
	
	/**
	 * POST 方式  参数在URL中
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String httpPost(String url) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient client = HttpClients.createDefault();
		String respContent = null;
		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}

	/**
	 * Post 方式  带有TOKEN测试 URL传参数
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String httpPostWithToken(String url) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient client = HttpClients.createDefault();
		httpPost.addHeader("auth_token",
				"eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKZXJzZXktU2VjdXJpdHktQmFzaWMiLCJzdWIiOiJhZG1pbiIsImF1ZCI6InVzZXIiLCJleHAiOjE0OTIxNTQ4NDIsImlhdCI6MTQ5MjA2ODQ3MywianRpIjoiMSJ9.YbzkLk8aMo4qblBvwWHUorXWDTPo5w4-WgyzmkSvyRc");
		String respContent = null;
		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}
	
	/**
	 * POST方式 带有TOKEN JSON方式传参数
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String httpPostWithJSON(String url) throws Exception {

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient client = HttpClients.createDefault();
		httpPost.addHeader("auth_token",
				"eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKZXJzZXktU2VjdXJpdHktQmFzaWMiLCJzdWIiOiJhZG1pbiIsImF1ZCI6InVzZXIiLCJleHAiOjE0OTIxNTQ4NDIsImlhdCI6MTQ5MjA2ODQ3MywianRpIjoiMSJ9.YbzkLk8aMo4qblBvwWHUorXWDTPo5w4-WgyzmkSvyRc");
		String respContent = null;
		
		 JSONObject jsonParam = new JSONObject();
		 jsonParam.put("bookID", "0002");
		 jsonParam.put("bookName", "星球大战_添加");
		 StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");// 解决中文乱码问题
		 entity.setContentEncoding("UTF-8");
		 entity.setContentType("application/json");
		 httpPost.setEntity(entity);
		 
		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}

	/**
	 * PUT 方式 JOSN 传参数
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String httpPutWithJSON(String url) throws Exception {
		HttpPut httpput = new HttpPut(url);
		CloseableHttpClient client = HttpClients.createDefault();
		httpput.addHeader("auth_token",
				"eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKZXJzZXktU2VjdXJpdHktQmFzaWMiLCJzdWIiOiJhZG1pbiIsImF1ZCI6InVzZXIiLCJleHAiOjE0OTIxNTQ4NDIsImlhdCI6MTQ5MjA2ODQ3MywianRpIjoiMSJ9.YbzkLk8aMo4qblBvwWHUorXWDTPo5w4-WgyzmkSvyRc");
		String respContent = null;
		
		 JSONObject jsonParam = new JSONObject();
		 jsonParam.put("bookID", "0002");
		 jsonParam.put("bookName", "星球大战_更新");
		 StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");// 解决中文乱码问题
		 entity.setContentEncoding("UTF-8");
		 entity.setContentType("application/json");
		 httpput.setEntity(entity);
		 
		HttpResponse resp = client.execute(httpput);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}
	
	/**
	 * DELETE 方式 JOSN传参数
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String httpDelete(String url) throws Exception {

		HttpDelete httpdelete = new HttpDelete(url);
		CloseableHttpClient client = HttpClients.createDefault();
		httpdelete.addHeader("auth_token",
				"eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKZXJzZXktU2VjdXJpdHktQmFzaWMiLCJzdWIiOiJhZG1pbiIsImF1ZCI6InVzZXIiLCJleHAiOjE0OTIxNTQ4NDIsImlhdCI6MTQ5MjA2ODQ3MywianRpIjoiMSJ9.YbzkLk8aMo4qblBvwWHUorXWDTPo5w4-WgyzmkSvyRc");
		String respContent = null;
		 
		HttpResponse resp = client.execute(httpdelete);
		if (resp.getStatusLine().getStatusCode() == 200) {
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		}
		return respContent;
	}

	

	public static void main(String[] args) throws Exception {
		String result = httpPost("http://localhost:8888/msdemo/services/login?username=admin&password=123");
		String result1 = httpGet("http://localhost:8888/msdemo/services/user/queryuser?username=admin");
		String result2 = httpPost("http://localhost:8888/msdemo/services/user/regist?username=admin&password=123");
		String result3 = httpGet("http://localhost:8888/msdemo/services/user/queryuser?username=admin");
		String result4 = httpPostWithToken("http://localhost:8888/msdemo/services/book/querybook?bookId=0001");
		String result5 = httpPostWithJSON("http://localhost:8888/msdemo/services/book/add_book");
		String result6 = httpPutWithJSON("http://localhost:8888/msdemo/services/book/update_book");
		String result7 = httpDelete("http://localhost:8888/msdemo/services/book/delete_book?bookId=0001");
		System.out.println(result);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		System.out.println(result7);
	}
}