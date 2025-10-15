public class Inimigo extends Personagem {

    private String ataquePadrao;

    public Inimigo(String nome, int maxHp, int danoAtaque, int poderDefesa, int mana){
        super(nome, maxHp, 0, danoAtaque, poderDefesa, mana);

        // Ataque físico padrão
        ataquePadrao = "Garras";
        adicionarAtaqueFisico(ataquePadrao, 15);
    }

    // Método para agir automaticamente usando ataque padrão
    public void agir(Personagem alvo){
        atacar(alvo, ataquePadrao);
    }
}
