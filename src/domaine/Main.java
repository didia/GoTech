package domaine;


import javax.swing.SwingUtilities;

import presentation.InterfaceGraphique;
import presentation.Afficheur;
import domaine.simulateur.Simulateur;

public class Main {

        /**
         * @param args
         */
        public static void main(String[] args) {
                 SwingUtilities.invokeLater(new Runnable() {

              @Override
              public void run() {
                      new InterfaceGraphique(new Simulateur(), new Afficheur());
              }
                 });
                

        }

}