package it.unisa.di.music.project;

import org.jfugue.player.Player;
import java.util.Scanner;


public class Main {
    public static void main(String args[]){
        String s1 = "", s2 = "";
        boolean inputValido = false;
        Scanner scanner = new Scanner(System.in);
        while (!inputValido) {
            try {
                System.out.println("Inserisci la prima stringa:");
                s1 = scanner.nextLine();  
                checkString(s1, s2);          // Verifica l'input
                inputValido = true;          
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
                System.out.println("Riprova.");
            }
        }
        inputValido = false;
        while (!inputValido) {
            try {
                System.out.println("Inserisci la seconda stringa:");
                s2 = scanner.nextLine();  
                checkString(s2, s1);          // Verifica l'input
                inputValido = true;          
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
                System.out.println("Riprova.");
            }
        }
        int r = EditDistance.editDistance(s1, s2);
        String music = Fibo.fib(r);
        Player player = new Player();
        System.out.format("music=%s\n",music);
        player.play(music);
    }
    
     public static void checkString(String input, String stringa) {
        if (input == null || input.trim().isEmpty() || input.equalsIgnoreCase(stringa)) {
            throw new IllegalArgumentException("La stringa è vuota oppure contiene solo spazi oppure è uguale ad una gia inserita.");
        }
    }
}
