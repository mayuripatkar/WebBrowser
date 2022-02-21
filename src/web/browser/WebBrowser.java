package web.browser;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.scene.web.WebView;

import javax.swing.*;

public class WebBrowser extends JFrame implements Runnable {
/* 1. Multiple inheritance is not allowed so implement Runnable interface
   2. Rule : If we are implementing any interface then the abstract method should be override in class
   Or make the method class abstract */

    private JFXPanel panel;

    public void run() {
        setTitle("Searching...");
        setBounds(0, 0, 1500, 900);
        setVisible(true);
        /* setBounds is a combination of setLocation and setSize functions
       Visibility of Swing frames is hidden by default */

        panel = new JFXPanel();
        add(panel);

        // WebEngine is created & managed; Implementation of arrow function
        Platform.runLater(() ->
        {
            WebView View = new WebView();
            View.getEngine().load("https://www.google.com");

            //Object is created, now add obj in panel
            panel.setScene(new Scene(View));
        });
    }


    public static void main(String[] args) {
// Swing objects are thread unsafe so use Swing Utilities
        SwingUtilities.invokeLater(new WebBrowser());

    }
}
