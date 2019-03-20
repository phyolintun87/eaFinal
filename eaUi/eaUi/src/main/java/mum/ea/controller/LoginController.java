/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import mum.ea.helper.LoginHelper;
import mum.ea.helper.ServiceHelper;
import mum.ea.model.EaResultData;
import mum.ea.model.ExtendedLoginModel;
import mum.ea.model.LoginModel;
import mum.ea.model.StatusCode;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author umurinan
 */
public class LoginController {

    public boolean login(LoginModel loginModel) {
        RestTemplate restTemplate = ServiceHelper.getRestTemplate();
        EaResultData result = restTemplate.postForObject(ServiceHelper.getBASE_URL() + "authentication",
                loginModel,
                EaResultData.class);

        if (result.getStatusCode() == StatusCode.SUCCESS) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            ExtendedLoginModel extendedLoginModel = mapper.convertValue(result.getData(), ExtendedLoginModel.class);
            LoginHelper.setToken(extendedLoginModel.getToken());
            LoginHelper.setTypeId(extendedLoginModel.getMemberType());
            System.out.println("TokeN:"+LoginHelper.getToken());
            System.out.println("ID:"+LoginHelper.getId());
            System.out.println("User Type:"+LoginHelper.getTypeId());
            
             System.out.println("Data:"+result.getData());;
            return true;
        }

        return false;
    }

}
