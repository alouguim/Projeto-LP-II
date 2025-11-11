
public class Inimigo extends Personagem {

    private String ataquePadrao = "Ataque Normal";

    public Inimigo(String nome, int maxHp, int danoAtaque, int poderDefesa, int mana) {
        super(nome, maxHp, 0, danoAtaque, poderDefesa, mana);

        adicionarAtaqueFisico(ataquePadrao, 5);
    }

    public void agir(Personagem alvo) {
        atacar(alvo, ataquePadrao);
    }

    public String getAtaquePadrao(){
        return ataquePadrao;
    }
}
