/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import static java.lang.Math.abs;
/**
 *
 * @author Patrick
 */
public class Fou extends Piece {

    public Fou(boolean est_blancC, int colonneC, int ligneC, Echiquier echiquierC) {
        super(est_blancC, colonneC, ligneC, echiquierC);
    }
	public String representationAscii() {
		if (super.estBlanc()==true) {return "F";}
		else {return "f";}
	}
	public String representationUnicode() {
		if (super.estBlanc()==true) {return "\u2657";}
		else {return "\u265D";}
	}
        public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
		int ligneInit = super.getLigne();
		int colonneInit = super.getColonne();
		if ((abs(ligneInit-nouvelle_ligne)==abs(colonneInit-nouvelle_colonne)) 
		&&((abs(ligneInit-nouvelle_ligne)+abs(colonneInit-nouvelle_colonne))>0)) {
			if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)) {}
			else return false;
		}	
		else return false;
		if (colonneInit<nouvelle_colonne&&ligneInit<nouvelle_ligne) {
			for (int i=1 , j=1; colonneInit+i < nouvelle_colonne && ligneInit+i < nouvelle_ligne; i++, j++) {
				if (super.getEchiquier().examinePiece(colonneInit+i, ligneInit+i)!=null) {
					return false;
				}
			}
		}
		if (colonneInit<nouvelle_colonne&&ligneInit>nouvelle_ligne) {
			for (int i=1 , j=1; colonneInit+i < nouvelle_colonne && ligneInit-i > nouvelle_ligne; i++, j++) {
				if (super.getEchiquier().examinePiece(colonneInit+i, ligneInit-i)!=null) {
					return false;
				}
			}
		}
		if (colonneInit>nouvelle_colonne&&ligneInit<nouvelle_ligne) {
			for (int i=1 , j=1; colonneInit-i > nouvelle_colonne && ligneInit+i < nouvelle_ligne; i++, j++) {
				if (super.getEchiquier().examinePiece(colonneInit-i, ligneInit+i)!=null) {
					return false;
				}
			}
		}
                if (colonneInit>nouvelle_colonne&&ligneInit>nouvelle_ligne) {
			for (int i=1 , j=1; colonneInit-i > nouvelle_colonne && ligneInit-i > nouvelle_ligne; i++, j++) {
				if (super.getEchiquier().examinePiece(colonneInit-i, ligneInit-i)!=null) {
					return false;
				}
			}
		}
		return true;
	}
}
