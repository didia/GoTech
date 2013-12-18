package presentation;

import java.util.Stack;



import javax.swing.undo.AbstractUndoableEdit;

import domaine.reseau.Carte;

class UndoableAffiche extends AbstractUndoableEdit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private  Carte m_carteTemp;
	
	
	protected  Stack<Carte> listeInstanceCarte; 
	public UndoableAffiche(Carte carte, Stack<Carte> etatsCarte) {
		listeInstanceCarte = etatsCarte;
		 m_carteTemp = carte;
	}

	public String getPresentationName() {
		return "Square Addition";
	}

	public void undo() {
		super.undo();
//		listeInstanceCarte.pop();
	}

	public void redo() {

		super.redo();

	}
}