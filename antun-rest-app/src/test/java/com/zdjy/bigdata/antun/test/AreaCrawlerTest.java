package com.zdjy.bigdata.antun.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class AreaCrawlerTest {
	@Test
	public void test001() throws Exception {
		// 创建客户端
		CloseableHttpClient build = HttpClientBuilder.create().build();
		// 拼接url
		String url = "http://47.94.250.65/pinganjiekou/area/0";
		// 创建get请求
		HttpGet httpGet = new HttpGet(url);
		// 发送请求
		CloseableHttpResponse execute = build.execute(httpGet);
		// 获取响应实体
		HttpEntity entity = execute.getEntity();
		// 解析响应实体
		String string = EntityUtils.toString(entity);
		System.out.println(string);
		//集合类型的json字符串转成集合对象
		AreaResponse[] fromJson = new Gson().fromJson(string, AreaResponse[].class);
		for(AreaResponse areaResponse:fromJson){
			System.out.println(areaResponse.getAreaId());
		}
	}
	@Test
	public void test002(){
		//客户端
		RestTemplate restTemplate = new RestTemplate();
		//发送请求，将结果封装成AreaResponse数组对象
		ResponseEntity<AreaResponse[]> forEntity = restTemplate.getForEntity("http://47.94.250.65/pinganjiekou/area/0",AreaResponse[].class);
		//获取响应实体
		AreaResponse[] body = forEntity.getBody();
		
		for(AreaResponse areaResponse:body){
			System.out.println(areaResponse.getAreaName()+":"+areaResponse.getAreaId());
			ResponseEntity<AreaResponse[]> forEntity2 = restTemplate.getForEntity("http://47.94.250.65/pinganjiekou/area/"+areaResponse.getAreaId(),AreaResponse[].class);
			//获取响应实体
			AreaResponse[] body2 = forEntity2.getBody();
			
			for(AreaResponse areaResponse2:body2){
				System.out.println(areaResponse2.getAreaName()+":"+areaResponse2.getAreaId());
				
			}
		}
	}
}
