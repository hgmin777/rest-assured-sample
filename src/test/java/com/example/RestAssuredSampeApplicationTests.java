//https://beenlife.tistory.com/34

package com.example;

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

}
