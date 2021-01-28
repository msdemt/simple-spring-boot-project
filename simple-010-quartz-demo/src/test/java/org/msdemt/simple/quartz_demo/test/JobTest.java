package org.msdemt.simple.quartz_demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class JobTest {

    private static final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testStartJob(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Accpet", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        restTemplate.postForObject("http://localhost:8080/job/startJob", httpEntity,String.class);
    }
}
