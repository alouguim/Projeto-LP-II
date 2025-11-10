import java.util.HashMap;

public class Personagem implements java.io.Serializable{

    private String nome;
    private int maxHp, hp, xp;

    private int danoAtaque;
    private int poderDefesa;
    private int mana;

    private HashMap<String, Integer> ataquesFisicos;
    private HashMap<String, Integer> magias;

    public Personagem(String nome, int maxHp, int xp, int danoAtaque, int poderDefesa, int mana) {
        this.nome = nome;
        setMaxHp(maxHp);
        setHp(maxHp);
        setXp(xp);
        setDanoAtaque(danoAtaque);
        setPoderDefesa(poderDefesa);
        setMana(mana);

        ataquesFisicos = new HashMap<>();
        magias = new HashMap<>();

    }

    //getters
    public String getNome() {
        return nome;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getDanoAtaque() {
        return danoAtaque;
    }

    public int getPoderDefesa() {
        return poderDefesa;
    }

    public int getMana() {
        return mana;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMaxHp(int maxHp) {
        if (maxHp <= 0) {
            this.maxHp = 1;
        } else {
            this.maxHp = maxHp;
        }
        if (this.hp <= 0) {
            this.hp = this.maxHp;
        } else if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > this.maxHp) {
            this.hp = this.maxHp;
        } else {
            this.hp = hp;
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

    //metodos
    public void adicionarAtaqueFisico(String nome, int dano) {
        ataquesFisicos.put(nome, dano);
    }

    public void adicionarMagia(String nome, int dano) {
        magias.put(nome, dano);
    }

    public String getNomeAtaque(){
        return ataquesFisicos.keySet().iterator().next();
    }

    public String getNomeMagia(){
        return magias.keySet().iterator().next();
    }

    public void atacar(Personagem alvo, String nomeAtaque) {
        int dano = this.danoAtaque + ataquesFisicos.get(nomeAtaque) - alvo.getPoderDefesa();
        if (dano < 0) {
            dano = 0;
        }
        System.out.println(this.nome + " usou " + nomeAtaque + " em " + alvo.getNome() + " causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }

    public void usarMagia(Personagem alvo, String nomeMagia, int custoMana) {
        if (this.mana < custoMana) {
            System.out.println(this.nome + " não tem mana suficiente para usar esta magia ");
            return;
        }

        int dano = magias.get(nomeMagia);
        setMana(this.mana - custoMana);
        System.out.println(this.nome + " usou " + nomeMagia + " em " + alvo.nome + " causando " + dano + " de dano.");
        alvo.receberDano(dano);

    }

    public void receberDano(int dano) {
        setHp(this.hp - dano);
        System.out.println(this.nome + " agora tem " + this.hp + "/" + this.maxHp + " HP ");
    }

}
