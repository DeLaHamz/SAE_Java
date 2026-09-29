package words;

public class Game {

    private int nbEssaie;
    private boolean aleatoire;
    private Word motJoueur;
    private WordRepository motATrouver;
    private boolean gagner;
    private String historiqueAffichage;
    private String nomJoueur;

    public Game(Word mot, String nomJoueur, boolean aleatoire) throws Exception {
        this.nbEssaie = 6;
        this.aleatoire = aleatoire;
        this.motJoueur = mot;
        this.nomJoueur = nomJoueur;
        this.motATrouver = new WordRepository(aleatoire);
        this.historiqueAffichage = "";
    }

    public Game(Word mot, String nomJoueur, int nbEssaie, boolean aleatoire) throws Exception {
        this.nbEssaie = nbEssaie;
        this.aleatoire = aleatoire;
        this.motJoueur = mot;
        this.nomJoueur = nomJoueur;
        this.motATrouver = new WordRepository(aleatoire);
        this.historiqueAffichage = "";
    }

    public String getMotSecret() {
        return this.motATrouver.getMotSecret();
    }

    public int getNbEssaie() {
        return this.nbEssaie;
    }

    public void setNbEssaie(int nbEssaie) {
        this.nbEssaie = nbEssaie;
    }

    public boolean getAleatoire() {
        return this.aleatoire;
    }

    public Word getMotJoueur() {
        return this.motJoueur;
    }

    public void setMotJoueur(Word motJoueur) {
        this.motJoueur = motJoueur;
    }

    public boolean getGagner() {
        return this.gagner;
    }

    public String gethistoriqueAffichage() {
        return this.historiqueAffichage;
    }

    public String getNomJoueur() {
        return this.nomJoueur;
    }

    public boolean estValide(Word mot) throws Exception {
        if (mot.nombreLettreValide()==false) {
            System.out.println("Erreur : le mot doit contenir exactement 5 lettres.");
            return false;
        }
        if (mot.lettreAlphabetValide()==false) {
            System.out.println("Erreur : le mot doit contenir uniquement des lettres.");
            return false;
        }
        if (mot.uniciteLettreValide()==false) {
            System.out.println("Erreur : le mot ne doit pas contenir de lettre répétée.");
            return false;
        }
        return true;
    }

    public boolean estEgale(Word mot1) {
        String motJoueur = mot1.getMotEntrer();
        String motSecret = this.motATrouver.getMotSecret();
        
        String resultat="";
        String resLettre="";

        //on compare lettre par lettre selon les règles métiers
        for (int i = 0; i < 5; i++) {
            char lettreMotJoueur = motJoueur.charAt(i);
            resLettre += "[ "+lettreMotJoueur+" ]";

            if (lettreMotJoueur == motSecret.charAt(i)) {
                // Lettre présente et aussi à la bonne place
                resultat += "OK      "; 
            } else if (motSecret.indexOf(lettreMotJoueur)==-1) {
                resultat+="ABSENT  "; 
            } else {
                resultat+="PRESENT "; 
            }
        }
        //on respecte l'affichage
        String ligneActuelle = resLettre + " --> " + resultat;

        //on l'ajoute à l'historique de notre affichage
        if (this.historiqueAffichage.equals("")) {
            this.historiqueAffichage = ligneActuelle;
        } else {
            this.historiqueAffichage += "\n" + ligneActuelle;
        }

        System.out.println(this.historiqueAffichage);

        //c'est gagner si c'est egale
        if (motJoueur.equals(motSecret)) {
            this.gagner = true;
            return true;
        }
        return false;
    }

    public String aGagner() {
        if (this.gagner){
            String debut="Vous avez gagnez\n";
            String fin=motATrouver.toString();
            return debut+fin;
        }
        String motHistorique = this.motJoueur.afficheMotHistorique();
        return "Vous avez echouez, voici votre historique de mots:\n" + motHistorique;
    }
}

/*public boolean estEgale(Word mot1) {//suppresion de deux parametres inutiles car on peut recuperer notre mot secret en interne
        if (mot1.getMotEntrer().equals(mot2.getMotSecret())){this.gagner = true;return true;} //ne pas oublier d'actualiser l'attribut gagner
        return false;
    } */