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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author umurinan
 */
public class BatchController {

    public void start() {
        RestTemplate restTemplate = ServiceHelper.getRestTemplate();

        HttpEntity<?> entity = new HttpEntity<Object>(ServiceHelper.getHeader(LoginHelper.getToken()));
        restTemplate
                .exchange(ServiceHelper.getBASE_URL() + "api/batch", HttpMethod.POST, entity, Object.class);

    }
}
