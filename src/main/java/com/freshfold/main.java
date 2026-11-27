/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.freshfold;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            LandingPage landing = new LandingPage();

            landing.setTitle("Laundritify");
            landing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            landing.setExtendedState(JFrame.MAXIMIZED_BOTH);
            landing.setVisible(true);

        });
    }
}

