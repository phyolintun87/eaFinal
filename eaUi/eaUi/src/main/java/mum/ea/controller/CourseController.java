/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import mum.ea.helper.LoginHelper;
import mum.ea.helper.ServiceHelper;
import mum.ea.model.CourseModel;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.model.ExtendedLoginModel;
import mum.ea.model.StatusCode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author umurinan
 */
public class CourseController {

    public EaResult save(CourseModel courseModel) {
        RestTemplate restTemplate = ServiceHelper.getRestTemplate();

        HttpEntity<CourseModel> entity = new HttpEntity<>(courseModel, ServiceHelper.getHeader(LoginHelper.getToken()));
        ResponseEntity<EaResult> result = restTemplate
                .exchange(ServiceHelper.getBASE_URL() + "api/course", HttpMethod.POST, entity, EaResult.class);
        System.out.println(result.getBody().getMessage());

        return result.getBody();
    }

    public EaResult delete(Long id) {
        RestTemplate restTemplate = ServiceHelper.getRestTemplate();

        HttpEntity<?> entity = new HttpEntity<Object>(ServiceHelper.getHeader(LoginHelper.getToken()));
        ResponseEntity<EaResult> result = restTemplate
                .exchange(ServiceHelper.getBASE_URL() + "api/course/" + id, HttpMethod.DELETE, entity, EaResult.class);
        System.out.println(result.getBody().getMessage());

        return result.getBody();
    }

    public EaResultData<List<CourseModel>> getAll() {
        RestTemplate restTemplate = ServiceHelper.getRestTemplate();

        HttpEntity<EaResultData<List<CourseModel>>> entity = new HttpEntity<>(ServiceHelper.getHeader(LoginHelper.getToken()));
        ResponseEntity<EaResultData> result = restTemplate
                .exchange(ServiceHelper.getBASE_URL() + "api/course", HttpMethod.GET, entity, EaResultData.class);

        ObjectMapper mapper = new ObjectMapper();
        List<CourseModel> myObjects
                = mapper.convertValue(result.getBody().getData(), new TypeReference<List<CourseModel>>() {
                });
        
        EaResultData<List<CourseModel>> res = new EaResultData<>();
        res.setData(myObjects);
        res.setStatusCode(StatusCode.SUCCESS);

        return res;
    }

}
