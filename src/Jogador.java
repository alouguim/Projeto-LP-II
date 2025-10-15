
import java.util.HashMap;

public class Jogador extends Personagem {
    private HashMap<String, Integer> inventario;
    public Jogador(String nome, int maxHp, int xp, int danoAtaque, int poderDefesa, int mana){
        super (nome, maxHp, xp, danoAtaque, poderDefesa, mana);
        inventario = new HashMap<>();
    }
}
