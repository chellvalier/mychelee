/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.freshfold;

/**
 *
 * @author THINKPAD
 */
public class main {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            RegisterForm register = new RegisterForm();

            register.setTitle("Register");
            register.setDefaultCloseOperation(
                javax.swing.JFrame.EXIT_ON_CLOSE
            );
            register.setLocationRelativeTo(null);
            register.setVisible(true);

        });
    }   
}
