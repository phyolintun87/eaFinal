/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amqp;

import javax.swing.JOptionPane;

/**
 *
 * @author umurinan
 */
public class CourseListener {
    public void listen(String message) {
        System.out.println("----------" + message);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "New Course " + message + " is added");
            }
        }).start();
        
    }
}
