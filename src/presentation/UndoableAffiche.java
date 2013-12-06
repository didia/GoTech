package presentation;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;


import javax.swing.undo.AbstractUndoableEdit;

import domaine.reseau.Carte;
import domaine.simulateur.Simulateur;


class UndoableAffiche extends AbstractUndoableEdit {
	
 
private static Simulateur m_simulateur;
private   Carte m_carte  ;
//private  Vector<Simulateur> listeEtatSimu = new LinkedList<Simulateur>();

protected  Vector<Carte> listeInstanceCarte;

  

  public UndoableAffiche(Carte carte,  Vector<Carte> etatsCarte) {
    listeInstanceCarte = etatsCarte;
    m_carte =carte;
  }

  public String getPresentationName() {
    return "Square Addition";
  }

  public void undo() {
    super.undo();  
  listeInstanceCarte.remove(m_carte);
  }

  public void redo() {
	  
    super.redo();
     listeInstanceCarte.add(m_carte);
  }
}