public class Mago extends Personagem {
    
    public int maxHp;
    public int xp;
    public int danoAtaque;
    public int poderDefesa;
    public int mana;
    public String nome;
    public static String[] upgradesAtk = {"Treino Arcano", "Domínio Mágico", "Maestria de Mana"};
    public static String[] upgradesDef = {"Magia Protetora", "Barreira Mística", "Fortaleza Mágica"};

    public Mago(String nome,int maxHp, int xp, int danoAtaque, int poderDefesa, int mana){
        super(nome, maxHp, xp, danoAtaque, poderDefesa, mana);
    }
    
    public static String[] getUpgradesAtk(){
        return upgradesAtk;
    }

    public static String[] getUpgradesDef(){
        return upgradesDef;
    }

    public void setMaxHp(int maxHp) {
        if (maxHp <= 0) {
            this.maxHp = 1;
        } else {
            this.maxHp = maxHp;
        }

    }

    public void setXp(int xp) {
        this.xp = xp;
        if (this.xp < 0) {
            this.xp = 0;
        }
    }

    public void setDanoAtaque(int danoAtaque) {
        this.danoAtaque = danoAtaque;
    }

    public void setPoderDefesa(int poderDefesa) {
        this.poderDefesa = poderDefesa;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            this.mana = 0;
        } else {
            this.mana = mana;
        }
    }
}
