package com.example.rqchallenge.utils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIUtils {

    private final RestTemplate restTemplate = new RestTemplate();

    public String get(String apiUrl) {
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public String post(String apiUrl, String requestPayload) {
        return restTemplate.postForObject(apiUrl, requestPayload, String.class);
    }
    public void delete(String apiUrl) {
        restTemplate.delete(apiUrl);
    }
}
