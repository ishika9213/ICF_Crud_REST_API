package com.howtodoinjava.demo;


import java.net.URI;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.howtodoinjava.demo.model.EmployeeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests 
{
    @Autowired
    private TestRestTemplate restTemplate;
    
    @LocalServerPort
    int randomServerPort;

    @Test
    public void testAddEmployeeSuccess() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
        URI uri = new URI(baseUrl);
        EmployeeEntity employee = new EmployeeEntity();
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      

        HttpEntity<EmployeeEntity> request = new HttpEntity<>(employee, headers);
        
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        
        Assert.assertEquals(201, result.getStatusCodeValue());
    }
    
    @Test
    public void testAddEmployeeMissingHeader() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
        URI uri = new URI(baseUrl);
        EmployeeEntity employee = new EmployeeEntity();
        
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<EmployeeEntity> request = new HttpEntity<>(employee, headers);
        
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        
        Assert.assertEquals(400, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("Missing request header"));
    }

}
