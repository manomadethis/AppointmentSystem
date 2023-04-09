package com.hairforyou.appointmentsystem;

/**
 *
 * @author manoklm
 */

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
   public static void main(String args[]) {

      try {
         // Set System L&F
         UIManager.setLookAndFeel(
         UIManager.getSystemLookAndFeelClassName());
      }

   catch (UnsupportedLookAndFeelException e) {
      // handle exception
   }
   catch (ClassNotFoundException e) {
      // handle exception
   }
   catch (InstantiationException e) {
      // handle exception
   }
   catch (IllegalAccessException e) {
      // handle exception
   }

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new LoginSystem().setVisible(true);
         }
      });
   }
}
