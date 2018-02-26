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
public class Pion extends Piece {

    public Pion(boolean est_blancC, int colonneC, int ligneC, Echiquier echiquierC) {
        super(est_blancC, colonneC, ligneC, echiquierC);
    }
	public String representationAscii() {
		if (super.estBlanc()==true) {return "P";}
		else {return "p";}
	}
	public String representationUnicode() {
		if (super.estBlanc()==true) {return "\u2659";}
		else {return "\u265F";}
	}
         public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
		int ligneInit = super.getLigne();
		int colonneInit = super.getColonne();
                if (ligneInit==1 && super.estBlanc()==true && nouvelle_colonne==colonneInit
                && nouvelle_ligne==ligneInit+2 
                && super.getEchiquier().examinePiece(colonneInit, ligneInit+1)==null
                && super.getEchiquier().examinePiece(colonneInit, ligneInit+2)==null) {
                    return true;
                }
                if (ligneInit==6 && super.estNoir()==true && nouvelle_colonne==colonneInit
                && nouvelle_ligne==ligneInit-2
                && super.getEchiquier().examinePiece(colonneInit, ligneInit-1)==null
                && super.getEchiquier().examinePiece(colonneInit, ligneInit-2)==null) {
                    return true;
                }
                if (super.estBlanc()) {
                    if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)) {
                        if (nouvelle_colonne==colonneInit && nouvelle_ligne==ligneInit+1
                        && super.getEchiquier().examinePiece(nouvelle_colonne, nouvelle_ligne) == null) {
                                return true;
                        }
                        else if (super.getEchiquier().examinePiece(nouvelle_colonne, nouvelle_ligne)!=null) {
                            if (abs(nouvelle_colonne-colonneInit)==1 
                            && (abs(nouvelle_colonne-colonneInit)!=0)
                            && nouvelle_ligne==ligneInit+1
                            && super.getEchiquier().examinePiece(nouvelle_colonne, nouvelle_ligne).estNoir() == true) {
                                return true;
                            }
                        }  
                    }
		}
                if (super.estNoir()) {
                    if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)) {
                        if (nouvelle_colonne==colonneInit && nouvelle_ligne==ligneInit-1
                        && super.getEchiquier().examinePiece(nouvelle_colonne, nouvelle_ligne) == null) {
                                return true;
                        }
                        else if (super.getEchiquier().examinePiece(nouvelle_colonne, nouvelle_ligne)!=null) {
                            if (abs(nouvelle_colonne-colonneInit)==1 
                            && (abs(nouvelle_colonne-colonneInit)!=0)
                            && nouvelle_ligne==ligneInit-1
                            && super.getEchiquier().examinePiece(nouvelle_colonne, nouvelle_ligne).estBlanc() == true) {
                                return true;
                            }
                        }
                    }
		}
        return false;
	}
}