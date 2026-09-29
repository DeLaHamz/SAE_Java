package words;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner= new Scanner(System.in);
        Word motJoueur= new Word(""); 
        Game jeu;

        System.out.println("=================================");
        System.out.println("FIND MY WORD - BUT1              ");
        System.out.println("=================================");
        System.out.println("\nBienvenue!\n\nQuel est votre nom?");
        String nomJoueur=scanner.nextLine();

        System.out.println("\nQue souhaitez-vous faire " + nomJoueur + "?\n"+
                            "1 - Lancer le cas de test(mot fixe qui est le 67ème mot 'audit'\n"+
                            "2 - Jouer une vraie partie(mot aleatoire) mais avec le nombre d'essaies de votre choix\n"+
                            "Alors, c'est 1 ou 2: ");
        String choix = scanner.nextLine();

        if (choix.equals("1")) {
            // Mode test
            jeu = new Game(motJoueur, nomJoueur,false); 
            System.out.println("\n-- Mode test --");
        } else {
            System.out.print("Combien d'essais souhaitez-vous avoir? : ");

            int nbEssais = scanner.nextInt(); 
            scanner.nextLine();
            // Mode jeu
            jeu = new Game(motJoueur, nomJoueur, nbEssais,true); 
        }

        int essaiActuel = 1;
        System.out.println("\n-- Le jeu commence ! --");

        while (essaiActuel <= jeu.getNbEssaie() && jeu.getGagner() == false) {
            System.out.println("\nIl vous reste "+(jeu.getNbEssaie() - essaiActuel + 1) + " essai.s.");
            System.out.print("Entrez un mot de 5 lettres: ");
            
            String saisie = scanner.nextLine().toLowerCase();
            motJoueur.setMotEntrer(saisie);

            if (jeu.estValide(motJoueur)) {
                motJoueur.setMotHistorique(saisie);
                jeu.estEgale(motJoueur);

                if (jeu.getGagner()==false) {
                    essaiActuel++;
                }
            }
        }

        System.out.println("\n -- Merci d'avoir joué à notre jeu "+jeu.getNomJoueur()+ "! --");
        if (jeu.getGagner()) {
            System.out.println("Bravochi "+jeu.getNomJoueur());
            System.out.println("Vous avez trouvé le mot en "+essaiActuel+" essais.");
        } else {
            System.out.println("Vous n'avez plus d'essais "+jeu.getNomJoueur()+"malheureusement.");
            System.out.println("Vous avez perdu.");
            System.out.println("Le mot secret était: " + jeu.getMotSecret());
        }
        
        System.out.println("\n\nHistorique de vos essais: "+motJoueur.afficheMotHistorique());
        System.out.println("-- finish on the light  --");
        
        scanner.close();
    }
}