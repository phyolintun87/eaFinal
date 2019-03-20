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
    private static Long id;
    private static Long typeId;

    public static String getToken() {
        return LoginHelper.token;
    }

    public static void setToken(String token) {
        LoginHelper.token = token;
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        LoginHelper.id = id;
    }

    public static Long getTypeId() {
        return typeId;
    }

    public static void setTypeId(Long typeId) {
        LoginHelper.typeId = typeId;
    }
    
    
    
    
    
}
