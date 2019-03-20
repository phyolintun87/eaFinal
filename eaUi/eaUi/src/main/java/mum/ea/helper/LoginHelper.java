/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.helper;

/**
 *
 * @author umurinan
 */
public class LoginHelper {
    
    private static String token;

    public static String getToken() {
        return LoginHelper.token;
    }

    public static void setToken(String token) {
        LoginHelper.token = token;
    }
    
    
    
}
