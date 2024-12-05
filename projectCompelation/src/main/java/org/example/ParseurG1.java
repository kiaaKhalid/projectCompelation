package org.example;

public class ParseurG1 {
    private TokenManager tm;
    private char tc;

    private void avancer() {
        tc=tm.suivant();
    }
    private void consommer(char attendu) {
        if (tc == attendu) {
            avancer();
        } else if (tc == '#') {
            throw new RuntimeException(tc + " Chaîne vide ne pas valide");
        } else {
            throw new RuntimeException("Attendu: " + attendu + ", trouvé: " + tc);
        }
    }

    public ParseurG1(TokenManager tm) {
        this.tm=tm;
        avancer();
    }
    private void S(){
        //S --> bSb
        if(tc == 'b'){
            consommer('b');
            S();
            consommer('b');
        }else if(tc == 'c'){ //S --> cAc
            consommer('c');
            A();
            consommer('c');
        }
    }
    private void A(){
        //A --> bAA
        if(tc == 'b'){
            consommer('b');
            A();
            A();
        }
        //A --> cASAb
        else if( tc == 'c'){
            consommer('c');
            A();
            S();
            A();
            consommer('b');
        }
        //A -->dcb
        else if(tc == 'd'){
            consommer('d');
            consommer('c');
            consommer('b');
        }
    }


    public void parse(){
        S();
        if(tc != '#')
            throw new RuntimeException(tc + ": fin de chaine attendue");
    }
}
