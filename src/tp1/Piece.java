/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 *
 * @author Patrick
 */
public class Piece {
        private boolean est_blanc, est_capture;
	private int colonne, ligne;
	private Echiquier echiquier;
	public boolean estBlanc() {return est_blanc;}
	public boolean estNoir() {return !est_blanc;}
	public boolean estCapture() {return est_capture;}
	public int getLigne() {return ligne;}
	public int getColonne() {return colonne;}
        public Echiquier getEchiquier() {return echiquier;}
	public Piece (boolean est_blancC, int colonneC, int ligneC, Echiquier echiquierC) {
		est_blanc = est_blancC;
		colonne = colonneC;
		ligne = ligneC;
		echiquier = echiquierC;
		est_capture = false;
	}
	public void meSuisFaitCapture() {est_capture = true;}
	public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
                if (echiquier.examinePiece(nouvelle_colonne, nouvelle_ligne)==null) {
                    return est_capture==false && echiquier.caseValide(nouvelle_colonne, nouvelle_ligne)==true;
                }
                else {
                    return est_capture==false && echiquier.caseValide(nouvelle_colonne, nouvelle_ligne)==true
                    && est_blanc!=echiquier.examinePiece(nouvelle_colonne, nouvelle_ligne).estBlanc();
                }
	}
	public void deplace (int nouvelle_colonne, int nouvelle_ligne) {
		Piece temp = echiquier.prendsPiece(colonne, ligne);
		temp.colonne = nouvelle_colonne;
		temp.ligne = nouvelle_ligne;
		if (echiquier.examinePiece(nouvelle_colonne, nouvelle_ligne)!=null) {
			echiquier.capturePiece(nouvelle_colonne, nouvelle_ligne);
		}
		echiquier.posePiece(temp);
	}
	public String toString() {
		String b; String c;
		if (est_blanc==true) {b = "blanc";}
		else {b = "noir";}
		if (est_capture==true) {c = "capture";}
		else {c = "non capture";}
		return b + " " + c + " colonne " + String.valueOf(colonne) + " ligne " 
		+ String.valueOf(ligne);
	}
	public String representationAscii() {
		if (est_blanc==true) {return "B";}
		else {return "N";}
	}
	public String representationUnicode() {
		if (est_blanc==true) {return "B";}
		else {return "N";}
	}
	
}
