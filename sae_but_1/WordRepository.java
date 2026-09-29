package words;

public class WordRepository {
    private String motSecret;
    private WordSet words = new JsonWordSet("data/mots.json");

    public WordRepository(boolean aleatoire) throws Exception{
        if (aleatoire==false) {this.motSecret = this.words.word(67);}
        else {this.motSecret = this.words.random();}
    }

    public WordRepository() throws Exception{
        this.motSecret = this.words.random();
    }

    public String getMotSecret() {
        return this.motSecret;
    }
    
    public String toString(){
        return "Le mot secret était "+this.motSecret;
    }
}