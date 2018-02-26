/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.util.Scanner;
/**
 *
 * @author Patrick
 */
public class JeuEchec {
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Voulez-vous jouer en ascii ou en unicode?");
                String a = "";
                while (a.equalsIgnoreCase("ascii")==false 
                || a.equalsIgnoreCase("unicode")==false) {
                        a = scan.next();
                }
        }
}
