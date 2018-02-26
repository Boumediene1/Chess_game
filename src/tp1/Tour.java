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
public class Tour extends Piece {

    public Tour(boolean est_blancC, int colonneC, int ligneC, Echiquier echiquierC) {
        super(est_blancC, colonneC, ligneC, echiquierC);
    }
	public String representationAscii() {
		if (super.estBlanc()==true) {return "T";}
		else {return "t";}
	}
	public String representationUnicode() {
		if (super.estBlanc()==true) {return "\u2656";}
		else {return "\u265C";}
	}
        public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
		int ligneInit = super.getLigne();
		int colonneInit = super.getColonne();
		if ((ligneInit==nouvelle_ligne)||(colonneInit==nouvelle_colonne)
		&&((abs(ligneInit-nouvelle_ligne)+abs(colonneInit-nouvelle_colonne))>0)) {
			if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)) {}
			else return false;
		}	
		else return false;
		if (colonneInit==nouvelle_colonne&&ligneInit<nouvelle_ligne) {
			for (int i=1; ligneInit+i < nouvelle_ligne; i++) {
				if (super.getEchiquier().examinePiece(colonneInit, ligneInit+i)!=null) {
					return false;
				}
			}
		}
		if (colonneInit==nouvelle_colonne&&ligneInit>nouvelle_ligne) {
			for (int i=1; ligneInit-i > nouvelle_ligne; i++) {
				if (super.getEchiquier().examinePiece(colonneInit, ligneInit-i)!=null) {
					return false;
				}
			}
		}
		if (colonneInit<nouvelle_colonne&&ligneInit==nouvelle_ligne) {
			for (int i=1; colonneInit+i < nouvelle_colonne; i++) {
				if (super.getEchiquier().examinePiece(colonneInit, ligneInit+i)!=null) {
					return false;
				}
			}
		}
		if (colonneInit>nouvelle_colonne&&ligneInit==nouvelle_ligne) {
			for (int i=1; colonneInit-i > nouvelle_colonne; i++) {
				if (super.getEchiquier().examinePiece(colonneInit, ligneInit-i)!=null) {
					return false;
				}
			}
		}
	return true;
	}
}
