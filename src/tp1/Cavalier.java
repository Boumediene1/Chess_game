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
public class Cavalier extends Piece {

    public Cavalier(boolean est_blancC, int colonneC, int ligneC, Echiquier echiquierC) {
        super(est_blancC, colonneC, ligneC, echiquierC);
    }
	public String representationAscii() {
		if (super.estBlanc()==true) {return "C";}
		else {return "c";}
	}
	public String representationUnicode() {
		if (super.estBlanc()==true) {return "\u2658";}
		else {return "\u265E";}
	}
        public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
		int ligneInit = super.getLigne();
		int colonneInit = super.getColonne();
		if (((abs(ligneInit-nouvelle_ligne)==1)&&(abs(colonneInit-nouvelle_colonne)==2))
                || ((abs(ligneInit-nouvelle_ligne)==2)&&(abs(colonneInit-nouvelle_colonne)==1))
		&&((abs(ligneInit-nouvelle_ligne)+abs(colonneInit-nouvelle_colonne))>0)) {
			if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)) {}
			else return false;
		}	
	else return false;
	return true;
	}
}
