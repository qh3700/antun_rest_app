package com.zdjy.bigdata.antun.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class PingAnJieKouTest {
	@Test
	public void test001() throws Exception {
		// 创建客户端
		CloseableHttpClient build = HttpClientBuilder.create().build();
		// 拼接url
		String url = "http://47.94.250.65/pinganjiekou/user/add?userName=中户&userSex=0&userBirth=1991-04-15&userPhone=18851645773&userIdNo=320125199102051741&province=110000&city=110100&town=110101&channelCode=afangti_huhuabo_001&channelToken=-67-75-49-31-96-89-29-1191749116-528-4926-43&productCode=PA000000CXSF-CXWY-01";
		//创建get请求
		HttpGet httpGet = new HttpGet(url);
		//发送请求
		CloseableHttpResponse execute = build.execute(httpGet);
		//获取响应实体
		HttpEntity entity = execute.getEntity();
		//解析响应实体
		String string = EntityUtils.toString(entity);
		System.out.println(string);
		PingAnJieKouResponse fromJson = new Gson().fromJson(string, PingAnJieKouResponse.class);
		if(fromJson.getCode()==200){
			System.out.println("success");
		}else{
			System.out.println(fromJson.getResult());
		}
	}
	@Test
	public void test002(){
		//spring提供的
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder builder=new StringBuilder("http://47.94.250.65/pinganjiekou/user/add?");
		builder.append("userName=中户&");
		builder.append("userSex=0&");
		builder.append("userBirth=1991-04-15&");
		builder.append("userPhone=18851645773&");
		builder.append("userIdNo=320125199102051741&");
		builder.append("province=110000&");
		builder.append("city=110100&");
		builder.append("town=110101&");
		builder.append("channelCode=afangti_huhuabo_001&");
		builder.append("channelToken=-67-75-49-31-96-89-29-1191749116-528-4926-43&");
		builder.append("productCode=PA000000CXSF-CXWY-01");
		PingAnJieKouResponse forObject = restTemplate.getForObject(builder.toString(),PingAnJieKouResponse.class);
		if(forObject.getCode()==200){
			System.out.println("success");
		}else{
			System.out.println(forObject.getResult());
		}
	}
}
