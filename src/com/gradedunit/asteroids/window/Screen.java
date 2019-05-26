package com.gradedunit.asteroids.window;

import com.gradedunit.asteroids.gameframework.GameController;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    public Screen(int w, int h, String title, GameController gameController) {
        //set the size of the window and lock it at said size

        gameController.setPreferredSize(new Dimension(w, h)); //sets the size of the window
        gameController.setMaximumSize(new Dimension(w, h)); //makes sure it cannot be expanded
        gameController.setMinimumSize(new Dimension(w, h)); //makes sure it cannot be shrunk

        JFrame frame = new JFrame(title); //Where everything is displayed
        frame.add(gameController); //add the game controller to the frame
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gameController.start();
    }
}
