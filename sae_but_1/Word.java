package words;

import java.util.ArrayList;

public class Word {
    
    private String motEntrer;
    private ArrayList<String> motHistorique = new ArrayList<>();

    public Word(String mot) { 
        this.motEntrer = mot;
    }

    public String getMotEntrer() { 
        return this.motEntrer;
    }

    public void setMotEntrer(String mot) { 
        this.motEntrer = mot;
    }

    public void setMotHistorique(String mot) { 
        this.motHistorique.add(this.motEntrer);
    }

    public String afficheMotHistorique() { 
        return this.motHistorique.toString();
    }
    
    public boolean nombreLettreValide() { 
        if (this.motEntrer == null) {
            return false;
        }
        return this.motEntrer.length() == 5; 
    }

    public boolean lettreAlphabetValide() { 
        if (this.motEntrer == null) {
            return false;
        }
        
        for (int i = 0; i < this.motEntrer.length(); i++) {
        char c = this.motEntrer.charAt(i);
        // Vérifie si le caractère n'est NI une minuscule, NI une majuscule de base
        if (((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')) == false) {
            return false;
        }
    }
    return true;
    }

    public boolean uniciteLettreValide() { 
        if (this.motEntrer == null) {
            return false;
        }
        char[] motTab = new char[5];
        for(int i=0;i<this.motEntrer.length();i++){
            motTab[i]=this.motEntrer.charAt(i);
        }
        for(int j=0;j<this.motEntrer.length();j++){
            char l = this.motEntrer.charAt(j);
            int compteur = 0;
                for(int k=0;k<this.motEntrer.length();k++){
                    if(l==motTab[k])compteur+=1;
                }
            if (compteur>1) return false;
        }
        return true;
        
    }

 
    public String toString() { 
        return this.motEntrer;
    }
}