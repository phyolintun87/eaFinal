/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.helper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author umurinan
 */
public class ServiceHelper {

    private static String BASE_URL = "http://localhost:8080/finalProject_war/";

    public static HttpHeaders getHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (token != null && !token.isEmpty()) {
            headers.set("Authorization", "Bearer " + token);
        }
        return headers;
//        HttpEntity<T> entity = new HttpEntity<T>("parameters", headers);
//        return entity;
    }

    public static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.getObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        List<MediaType> l = new ArrayList<MediaType>();
        l.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(l);
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return restTemplate;
    }

    public static String getBASE_URL() {
        return BASE_URL;
    }

}
