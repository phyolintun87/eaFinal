/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.controller;

import mum.ea.helper.LoginHelper;
import mum.ea.helper.ServiceHelper;
import mum.ea.model.EaResult;
import mum.ea.model.MemberModel;
import mum.ea.model.StatusCode;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author umurinan
 */
public class MemberController {
    
    public EaResult save(MemberModel memberModel){
        RestTemplate restTemplate = ServiceHelper.getRestTemplate();
        EaResult result = restTemplate.postForObject(ServiceHelper.getBASE_URL()+"authentication/register",
                memberModel, EaResult.class);
        
         return result;
    }
    
}
