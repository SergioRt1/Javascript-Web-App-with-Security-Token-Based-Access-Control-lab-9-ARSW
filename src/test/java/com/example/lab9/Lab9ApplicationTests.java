package com.example.lab9;

import com.example.lab9.repository.MessageRepository;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Lab9ApplicationTests {

    @Autowired
    MessageRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void post() throws IOException {
//        int size = repository.findAll().size();
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost requestToken = new HttpPost("http://localhost:8080/login");
//        requestToken.setHeader("Content-Type", "application/json");
//        StringEntity user = new StringEntity("{\"username\": SergioRt,\"password\": sergio }", ContentType.APPLICATION_JSON);
//        requestToken.setEntity(user);
//        HttpResponse responseToken = httpClient.execute(requestToken);
//
//        String token = "";
//        for (int i = 0; i < 10; i++) {
//            String payload = "{ \"message\": \"prueba :)\"}";
//            StringEntity entity = new StringEntity(payload,
//                    ContentType.APPLICATION_JSON);
//            HttpPost request = new HttpPost("http://localhost:8080/message");
//            request.setEntity(entity);
//            request.setHeader("Content-Type", "application/json");
//            request.setHeader("Authorization", token);
//            HttpResponse response = httpClient.execute(request);
//            Assert.assertEquals(201, response.getStatusLine().getStatusCode());
//        }
//
//        Assert.assertEquals(size+10,repository.findAll().size());
    }

}
