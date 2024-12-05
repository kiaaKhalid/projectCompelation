package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] phrases = {"cdcbc", "bcdcbcb", "cbdcbdcbc", "ccdcbcdcbcdcbbcr", "cdcbbb", "cdcb", ""};
        // Boucle pour chaque phrase
        for (String phrase : phrases) {
            String ch = phrase;  // Assurez-vous que 'ch' est déclaré ici
            TokenManager tm = new TokenManager(ch);
            ParseurG1 parseur = new ParseurG1(tm);
            try {
                parseur.parse();
                System.out.println(ch + " est valide");
            } catch (RuntimeException exp) {
                System.out.println(ch + " n'est pas valide");
                System.out.println(exp.getMessage());
            }
        }
    }
}