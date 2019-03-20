/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.controller;

import mum.ea.helper.LoginHelper;
import mum.ea.helper.ServiceHelper;
import mum.ea.model.CourseModel;
import mum.ea.model.EaResult;
import mum.ea.model.LessonModel;
import mum.ea.model.LoginModel;
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
    
}
