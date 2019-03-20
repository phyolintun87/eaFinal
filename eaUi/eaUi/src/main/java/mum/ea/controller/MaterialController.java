/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.controller;

import mum.ea.helper.LoginHelper;
import mum.ea.helper.ServiceHelper;
import mum.ea.model.EaResult;
import mum.ea.model.MaterialModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Olivier
 */
public class MaterialController {

    public EaResult save(MaterialModel materialModel) {
      RestTemplate restTemplate = ServiceHelper.getRestTemplate();

        HttpEntity<MaterialModel> entity = new HttpEntity<>(materialModel, ServiceHelper.getHeader(LoginHelper.getToken()));
        ResponseEntity<EaResult> result = restTemplate
                .exchange(ServiceHelper.getBASE_URL() + "api/material", HttpMethod.POST, entity, EaResult.class);
        
        return result.getBody();  
    }
    
}
