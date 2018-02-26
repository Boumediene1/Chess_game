/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.io.PrintStream;
import java.io.IOException;
/**
 *
 * @author Patrick
 */
public class Echiquier {

    
	private Piece[][] tableau_de_jeu;
	private Piece[] blancs_captures;
	private Piece[] noirs_captures;
	public boolean caseValide(int colonne, int ligne) {
		if (colonne < 0 || colonne > 7) {return false;}
		if (ligne < 0 || ligne > 7) {return false;}
		else {return true;}
	}
	public Piece examinePiece(int colonne, int ligne) {return tableau_de_jeu[colonne][ligne];}
	public Piece prendsPiece(int colonne, int ligne) {
		Piece temp = tableau_de_jeu[colonne][ligne];
		tableau_de_jeu[colonne][ligne] = null;
		return temp;
	}
	public void posePiece(Piece p) {tableau_de_jeu[p.getColonne()][p.getLigne()] = p;}
	public void capturePiece(int colonne, int ligne) {
		Piece temp = tableau_de_jeu[colonne][ligne];
                temp.meSuisFaitCapture();
		tableau_de_jeu[colonne][ligne] = null;
		if (temp.estBlanc() == true) {
			int i = 0;
			while (blancs_captures[i] != null) {i+=1;}
			blancs_captures[i]=temp;
		}
		else {
			int i = 0;
			while (noirs_captures[i] !=null) {i+=1;}
                        noirs_captures[i]=temp;
		}
	}
	public void afficheAscii() {
		String n = "Les noirs ont capture: ";
		for (int k=0; k<16; k++) {
			if (blancs_captures[k]!=null) {
				n = n + blancs_captures[k].representationAscii();
			}
			else break;
		}
		System.out.println(n);
		System.out.println();
		System.out.println("   a b c d e f g h");
		System.out.println("   ----------------");
		String line = "";
		for (int i=8; i>0; i--) {
			line = i+"| ";
			for (int j=0; j<8; j++) {
                                if (tableau_de_jeu[j][i-1]!=null) {
                                    line = line + tableau_de_jeu[j][i-1].representationAscii() + " ";
                                }
                                else line = line + ". ";
			}
			line = line + " |" + i;
			System.out.println(line);
		}
		System.out.println("   ----------------");
		System.out.println("   a b c d e f g h");
		System.out.println();
		String b = "Les blancs ont capture: ";
		for (int k=0; k<16; k++) {
			if (noirs_captures[k]!=null) {
				b = b + noirs_captures[k].representationAscii();
			}
			else break;
		}
		System.out.println(b);
	}
	public void afficheUnicode() throws IOException {
                PrintStream sysout = new PrintStream(System.out, true, "UTF-8");
		String n = "Les noirs ont capture: ";
		for (int k=0; k<16; k++) {
			if (blancs_captures[k]!=null) {
				n = n + blancs_captures[k].representationUnicode();
			}
			else break;
		}
		sysout.println(n);
		System.out.println();
		sysout.println("    a      b     c     d      e     f      g     h");
		sysout.println(" ┌───┬───┬───┬───┬───┬───┬───┬───┐");
		String line = "";
		for (int i=8; i>0; i--) {
			line = i+"│";
			for (int j=0; j<8; j++) {
                                if (tableau_de_jeu[j][i-1]!=null) {
                                    line = line + "  " + tableau_de_jeu[j][i-1].representationUnicode() + "  │";
                                }
                                else {line = line + "     │";}                               
			}
			line = line + i;
			sysout.println(line);
			if (i>1) {
				sysout.print(" ├───┼───┼───┼───┼───┼───┼───┼───┤");
                                System.out.println();
			}
		}
		sysout.println(" └───┴───┴───┴───┴───┴───┴───┴───┘");
		sysout.println("    a      b     c     d      e     f      g     h");
		sysout.println();
		String b = "Les blancs ont capture: ";
		for (int k=0; k<16; k++) {
			if (noirs_captures[k]!=null) {
				b = b + noirs_captures[k].representationUnicode();
			}
			else break;
		}
		sysout.println(n);
	}
	public Echiquier() {
                Piece[] x = new Piece[16];
                Piece[] y = new Piece[16];
                blancs_captures = x;
                noirs_captures = y;
            
		tableau_de_jeu = new Piece[8][8];
		Piece Tg = new Tour(true, 0, 0, this); 
		tableau_de_jeu[0][0] = (Tour) Tg; // Assigne la pièce à une sous-classe
		Piece Cg = new Cavalier(true, 1, 0, this);
		tableau_de_jeu[1][0] = (Cavalier) Cg;
		Piece Fg = new Fou(true, 2, 0, this);
		tableau_de_jeu[2][0] = (Fou) Fg;
		Piece D = new Dame(true, 3, 0, this);
		tableau_de_jeu[3][0] = (Dame) D;
		Piece R = new Roi(true, 4, 0, this);
		tableau_de_jeu[4][0] = (Roi) R;
		Piece Fd = new Fou(true, 5, 0, this);
		tableau_de_jeu[5][0] = (Fou) Fd;
		Piece Cd = new Cavalier(true, 6, 0, this);
		tableau_de_jeu[6][0] = (Cavalier) Cd;
		Piece Td = new Tour(true, 7, 0, this);
		tableau_de_jeu[7][0] = (Tour) Td;
		
		Piece[] P = new Piece[8];
		for (int i=0; i<8; i++) {
			P[i] = new Pion(true, i, 1, this);
			tableau_de_jeu[i][1] = (Pion) P[i];
		}
		
		Piece[] p = new Piece[8];
		for (int i=0; i<8; i++) {
			p[i] = new Pion(false, i, 6, this);
			tableau_de_jeu[i][6] = (Pion) p[i];
		}
		
		Piece tg = new Tour(false, 0, 7, this); 
		tableau_de_jeu[0][7] = (Tour) tg;
		Piece cg = new Cavalier(false, 1, 7, this);
		tableau_de_jeu[1][7] = (Cavalier) cg;
		Piece fg = new Fou(false, 2, 7, this);
		tableau_de_jeu[2][7] = (Fou) fg;
		Piece d = new Dame(false, 3, 7, this);
		tableau_de_jeu[3][7] = (Dame) d;
		Piece r = new Roi(false, 4, 7, this);
		tableau_de_jeu[4][7] = (Roi) r;
		Piece fd = new Fou(false, 5, 7, this);
		tableau_de_jeu[5][7] = (Fou) fd;
		Piece cd = new Cavalier(false, 6, 7, this);
		tableau_de_jeu[6][7] = (Cavalier) cd;
		Piece td = new Tour(false, 7, 7, this);
		tableau_de_jeu[7][7] = (Tour) td;
	}
}
