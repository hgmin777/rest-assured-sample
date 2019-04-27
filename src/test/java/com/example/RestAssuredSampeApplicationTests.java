//https://beenlife.tistory.com/34

package com.example;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAssuredSampeApplicationTests {

	@Test
	public void SampleTest() {
		RestAssured.given()
        .when().get("http://www.google.com")
        .then().statusCode(200);
	}
	
	@Test
    public void getPostsTest() {
        RestAssured.given()
                    .when().get("https://jsonplaceholder.typicode.com/posts")
                    .then().statusCode(200)
                            .log().all();
    }
	
	  @Test
	    public void addPostTest() {
	        Map<String, Object> requestData = new HashMap<>();
	        requestData.put("title", "foo");
	        requestData.put("body", "bar");
	        requestData.put("userId", 1);
	        
	        RestAssured.given()
	                        .contentType("application/json")
	                        .body(requestData).log().all()
	                    .when()
	                        .post("https://jsonplaceholder.typicode.com/posts")
	                    .then()
	                        .statusCode(201)
	                        .assertThat().body("title", equalTo("foo"))
	                        .assertThat().body("body", equalTo("bar"))
	                        .assertThat().body("userId", equalTo(1))
	                        .log().all();
	    }
	  
	  @Test
	    public void updatePostTest() {
	        Map<String, Object> requestData = new HashMap<>();
	        requestData.put("id", 1);
	        requestData.put("title", "fooupdate");
	        requestData.put("body", "bar update");
	        requestData.put("userId", 1);
	        
	        RestAssured.given()
	                        .contentType("application/json")
	                        .pathParam("postId", 1)
	                        .body(requestData)
	                        .log().all()
	                    .when()
	                        .put("https://jsonplaceholder.typicode.com/posts/{postId}")
	                    .then()
	                        .statusCode(200)
	                        .assertThat().body("id", equalTo(1))
	                        .assertThat().body("title", equalTo("fooupdate"))
	                        .assertThat().body("body", equalTo("bar update"))
	                        .assertThat().body("userId", equalTo(1))
	                        .log().all();
	    }
	  
	  @Test
	    public void deletePostTest() {
	        
	        RestAssured.given()
	                        .pathParam("postId", 1)
	                        .log().all()
	                    .when()
	                        .delete("https://jsonplaceholder.typicode.com/posts/{postId}")
	                    .then()
	                        .statusCode(200)
	                        .log().all();
	    }



}
