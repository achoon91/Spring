package com.sist.naver;
//네이버 검색 API 예제 - blog 검색
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sist.dao.ShoppingVO;

public class ApiExamSearchShopping {

 public static void main(String[] args) {
     String clientId = "bOWAcPtbQno1F61xjTyy"; //애플리케이션 클라이언트 아이디값"
     String clientSecret = "81pKmbgok_"; //애플리케이션 클라이언트 시크릿값"

     String[] list = {"축산","건강식품","수산","농산물","반찬","김치","음료","가공식품","다이어트식품","과자","아이스크림/빙수","냉동/간편조리식품","전통주","쿠킹박스"};
     //System.out.println(list.length);
     for(int j=0; j<list.length;j++)
	 {
     String text = null;
     try {
    		text = URLEncoder.encode(list[j], "UTF-8");
    		
     } catch (UnsupportedEncodingException e) {
         throw new RuntimeException("검색어 인코딩 실패",e);
     }
     
     for(int k = 1;k<=1000;k=k+100)
     {	 
     String apiURL = "https://openapi.naver.com/v1/search/shop.json?display=100&start="+k+"&query=" + text;    // json 결과
     //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?display=100&start=1&query="+ text; // xml 결과
     Map<String, String> requestHeaders = new HashMap<>();
     requestHeaders.put("X-Naver-Client-Id", clientId);
     requestHeaders.put("X-Naver-Client-Secret", clientSecret);
     String responseBody = get(apiURL,requestHeaders);

     System.out.println(responseBody);
     
     /*
     {"lastBuildDate": "Tue, 24 Nov 2020 18:29:39 +0900",
     "total": 183390,
     "start": 1,
     "display": 100,
     "items": 
     
     [
     {"title": "미트얌 냉동 신선 대용량 통<b>삼겹살</b> 2kg 2000g 바베큐 원육 캠핑용 수육보쌈 통삼겹 대패삼겹 왕목살 목전지 항정살 가브리살 돼지갈비",
     "link": "https://search.shopping.naver.com/gate.nhn?id=82468146490",
     "image": "https://shopping-phinf.pstatic.net/main_8246814/82468146490.1.jpg",
     "lprice": "19900",
     "hprice": "0",
     "mallName": "미트얌",
     "productId": "82468146490",
     "productType": "2",
     "brand": "",
     "maker": "",
     "category1": "식품",
     "category2": "축산",
     "category3": "돼지고기",
     "category4": "수입산돼지고기"},
     */
     
     ShoppingVO vo = new ShoppingVO(); 
	 try {
		JSONParser jp = new JSONParser();
		JSONObject root = (JSONObject) jp.parse(responseBody);
		System.out.println(root);
		JSONArray arr = (JSONArray)root.get("items");
		
		for(int i=0;i<arr.size();i++)
		{
			JSONObject obj = (JSONObject)arr.get(i);
//			System.out.println("============================");
			System.out.println("====list의 종류"+list[j]+"======");
			System.out.println(obj.get("title").toString());
			System.out.println(obj.get("link"));
			System.out.println(obj.get("image"));
			System.out.println(obj.get("lprice"));
			System.out.println(obj.get("productType")); // 1번만 가져오면 됨
			System.out.println(obj.get("category1"));
			System.out.println(obj.get("category2"));
			System.out.println(obj.get("category3"));
			System.out.println(obj.get("category4"));
			
			vo.setTitle(obj.get("title").toString());
			vo.setLink(obj.get("link").toString());
			vo.setImage(obj.get("image").toString());
			vo.setLprice(obj.get("lprice").toString());
			vo.setProductType(obj.get("productType").toString());
			vo.setCategory1(obj.get("category1").toString());
			vo.setCategory2(obj.get("category2").toString());
			vo.setCategory3(obj.get("category3").toString());
			vo.setCategory4(obj.get("category4").toString());
		}
	} catch (Exception e) {}
     }
	}
     
     
     
 }

 private static String get(String apiUrl, Map<String, String> requestHeaders){
     HttpURLConnection con = connect(apiUrl);
     try {
         con.setRequestMethod("GET");
         for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
             con.setRequestProperty(header.getKey(), header.getValue());
         }

         int responseCode = con.getResponseCode();
         if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
             return readBody(con.getInputStream());
         } else { // 에러 발생
             return readBody(con.getErrorStream());
         }
     } catch (IOException e) {
         throw new RuntimeException("API 요청과 응답 실패", e);
     } finally {
         con.disconnect();
     }
 }

 private static HttpURLConnection connect(String apiUrl){
     try {
         URL url = new URL(apiUrl);
         return (HttpURLConnection)url.openConnection();
     } catch (MalformedURLException e) {
         throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
     } catch (IOException e) {
         throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
     }
 }

 private static String readBody(InputStream body){
     InputStreamReader streamReader = new InputStreamReader(body);

     try (BufferedReader lineReader = new BufferedReader(streamReader)) {
         StringBuilder responseBody = new StringBuilder();

         String line;
         while ((line = lineReader.readLine()) != null) {
             responseBody.append(line);
         }

         return responseBody.toString();
     } catch (IOException e) {
         throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
     }
 }
}