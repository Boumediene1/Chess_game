/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.io.IOException;
import java.util.Scanner;
 
/**
 *
 * @author Patrick
 */
public class TP1 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Voulez-vous jouer en ascii ou en unicode?");
        String modeAff = "";
        int testAff = 0;
        while (modeAff.equalsIgnoreCase("ascii")==false 
        && modeAff.equalsIgnoreCase("unicode")==false) {
            if (testAff>0) {
                System.out.println("Veuillez choisir entre \"ascii\" et \"unicode\" seulement");
            }
            modeAff = scan.nextLine();
            testAff++;                
        }
        Echiquier Echec = new Echiquier();
        
        boolean gameon = true;
        boolean tourBlanc = true;
        String erreurEntree = "Veuillez choisir un déplacement sous la forme d'une case"
                        +"initiale et de destination. \n"
                        +"Par exemple : a2 c5. \n"
                        + "Vous pouvez aussi choisir une case sur laquelle se trouve une de vos pièces"
                        + "pour connaître les mouvements possibles de cette pièce. \n"
                        + "Par exemple : a2";
        while (gameon) {
            if (modeAff.equalsIgnoreCase("ascii")) {
                Echec.afficheAscii();
            }
            if (modeAff.equalsIgnoreCase("unicode")) {
                Echec.afficheUnicode();
            }
            while (tourBlanc) {
                System.out.print("Joueur Blanc? ");
                String entree = scan.nextLine();
                if (entree.length()==2) {
                    if ((int) entree.charAt(0) < 97 || (int) entree.charAt(0) > 104
                    || (int) entree.charAt(1) < 49 || (int) entree.charAt(1) > 56) {
                        System.out.println(erreurEntree);
                    }
                    else {}
                }
                else if (entree.length()==0) {}
                else if (entree.length()!=5 || (int) entree.charAt(0) < 97 || entree.charAt(0) > 104
                || (int) entree.charAt(1) < 49 || (int) entree.charAt(1) > 56
                || entree.charAt(2)!=' '
                || (int) entree.charAt(3) < 97 || entree.charAt(3) > 104
                || (int) entree.charAt(4) < 49 || (int) entree.charAt(4) > 56) {
                    System.out.println(erreurEntree);
                }
                else {
                    int colonneI = (int) entree.charAt(0) - 97;
                    int ligneI = (int) entree.charAt(1) - 49;
                    int colonneF = (int) entree.charAt(3) - 97;
                    int ligneF = (int) entree.charAt(4) - 49;
                    Piece choix = Echec.examinePiece(colonneI, ligneI);
                    if (choix.deplacementValide(colonneF, ligneF)==true) {
                        if (Echec.examinePiece(colonneF, ligneF)!=null) {
                            System.out.println(choix.representationAscii()+" a capturé "
                            + Echec.examinePiece(colonneF, ligneF).representationAscii()+" en "
                            + entree.substring(3,5));
                        }
                        choix.deplace(colonneF, ligneF);
                        tourBlanc = false;
                    }
                    else {System.out.println("Ce n'est pas un déplacement valide.");}  
                }
            }
            if (modeAff.equalsIgnoreCase("ascii")) {
                Echec.afficheAscii();
            }
            while (!tourBlanc) {
                System.out.print("Joueur Noir? ");
                String entree = scan.nextLine();
                if (entree.length()==2) {
                    if ((int) entree.charAt(0) < 97 || (int) entree.charAt(0) > 104
                    || (int) entree.charAt(1) < 49 || (int) entree.charAt(1) > 56) {
                        System.out.println(erreurEntree);
                    }
                    else {}
                }
                else if (entree.length()==0) {}
                else if (entree.length()!=5 || (int) entree.charAt(0) < 97 || entree.charAt(0) > 104
                || (int) entree.charAt(1) < 49 || (int) entree.charAt(1) > 56
                || entree.charAt(2)!=' '
                || (int) entree.charAt(3) < 97 || entree.charAt(3) > 104
                || (int) entree.charAt(4) < 49 || (int) entree.charAt(4) > 56) {
                    System.out.println(erreurEntree);
                }
                else {
                    int colonneI = (int) entree.charAt(0) - 97;
                    int ligneI = (int) entree.charAt(1) - 49;
                    int colonneF = (int) entree.charAt(3) - 97;
                    int ligneF = (int) entree.charAt(4) - 49;
                    Piece choix = Echec.examinePiece(colonneI, ligneI);
                    if (choix.deplacementValide(colonneF, ligneF)==true) {
                        if (Echec.examinePiece(colonneF, ligneF)!=null) {
                            System.out.println(choix.representationAscii()+" a capturé "
                            + Echec.examinePiece(colonneF, ligneF).representationAscii()+" en "
                            + entree.substring(3,5));
                        }
                        choix.deplace(colonneF, ligneF);
                        tourBlanc = true;
                    }
                    else {System.out.println("Ce n'est pas un déplacement valide.");}
                }
            }
        }
    }
    
}
