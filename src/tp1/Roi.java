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
public class Roi extends Piece {

        public Roi(boolean est_blancC, int colonneC, int ligneC, Echiquier echiquierC) {
                super(est_blancC, colonneC, ligneC, echiquierC);
        }
	public String representationAscii() {
		if (super.estBlanc()==true) {return "R";}
		else {return "r";}
	}
	public String representationUnicode() {
		if (super.estBlanc()==true) {return "\u2654";}
		else {return "\u265A";}
	}
	public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
		if ((abs(super.getLigne()-nouvelle_ligne)<=1) 
		||(abs(super.getColonne()-nouvelle_colonne)<=1)
		&&((abs(super.getLigne()-nouvelle_ligne)+abs(super.getColonne()-nouvelle_colonne))>0)) {
			if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)) {
				return true;
			}
		}
	return false;
	}
}
