package com.fowobi.githubactions.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoreControllerTest {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost:";

    private static TestRestTemplate restTemplate;

    @BeforeAll
    public static void init() {
        restTemplate = new TestRestTemplate();
    }

    @BeforeEach
    public void setup() {
        baseUrl = baseUrl.concat(String.valueOf(port)).concat("/action");
    }

    @Test
    void testHello() {

        String url = baseUrl.concat("/msg");
        System.out.println("url is -- " + url);
        String message = restTemplate.getForObject(url, String.class);
        System.out.println(message);
        assertTrue(message.equalsIgnoreCase("GitHubActions for AWS"));
    }
}