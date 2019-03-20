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
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.model.LessonModel;

import mum.ea.model.StatusCode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author umurinan
 */
public class LessonController {
    
    
    public EaResult save(LessonModel lessonModel){
       RestTemplate restTemplate = ServiceHelper.getRestTemplate();

        HttpEntity<LessonModel> entity = new HttpEntity<>(lessonModel, ServiceHelper.getHeader(LoginHelper.getToken()));
        ResponseEntity<EaResult> result = restTemplate
                .exchange(ServiceHelper.getBASE_URL() + "api/lesson", HttpMethod.POST, entity, EaResult.class);
        
        return result.getBody();
    }

    public EaResultData<List<LessonModel>> getAll() {
        RestTemplate restTemplate = ServiceHelper.getRestTemplate();

        HttpEntity<EaResultData<List<LessonModel>>> entity = new HttpEntity<>(ServiceHelper.getHeader(LoginHelper.getToken()));
        ResponseEntity<EaResultData> result = restTemplate
                .exchange(ServiceHelper.getBASE_URL() + "api/lesson", HttpMethod.GET, entity, EaResultData.class);

        ObjectMapper mapper = new ObjectMapper();
          mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<LessonModel> myObjects
                = mapper.convertValue(result.getBody().getData(), new TypeReference<List<LessonModel>>() {
                });
        
        EaResultData<List<LessonModel>> res = new EaResultData<>();
        res.setData(myObjects);
        res.setStatusCode(StatusCode.SUCCESS);

        return res;
        
    }

    public EaResult getLesson(LessonModel lessonModel) {
        RestTemplate restTemplate = ServiceHelper.getRestTemplate();
        EaResult result = restTemplate.postForObject(ServiceHelper.getBASE_URL()+"lesson/findOneLesson",
                lessonModel, EaResult.class);
        
         return result;
    }
    
}
