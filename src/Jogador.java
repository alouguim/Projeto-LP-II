
import java.util.HashMap;

public class Jogador extends Personagem {

    private HashMap<String, Integer> inventario;
    public String[] upgradesAtk = {"Força", "Poder", "Força Divina"};
    public String[] upgradesDef = {"Ossos Pesados", "Passos Rápidos", "Aura Divina"};
    public int numUpgradesAtk;
    public int numUpgradesDef;

    // Construtor
    public Jogador(String nome, int maxHp, int xp, int danoAtaque, int poderDefesa, int mana) {
        super(nome, maxHp, xp, danoAtaque, poderDefesa, mana); // agora respeita os valores passados
        inventario = new HashMap<>();
        this.numUpgradesAtk = 0;
        this.numUpgradesDef = 0;
        escolherTraits();
    }

    public int atacar() {
        return getDanoAtaque();
    }

    public int defender() {
        return getPoderDefesa();
    }

    public void escolherTraits() {
        LogicaJogo.limparTerminal();
        LogicaJogo.imprimirCabecalho("Escolha uma característica:");
        System.out.println("(1) " + upgradesAtk[numUpgradesAtk]);
        System.out.println("(2) " + upgradesDef[numUpgradesDef]);

        int input = LogicaJogo.lerInt("-> ", 2);
        LogicaJogo.limparTerminal();

        if (input == 1) {
            LogicaJogo.imprimirCabecalho("Você escolheu " + upgradesAtk[numUpgradesAtk] + "!");
            numUpgradesAtk++;
            setDanoAtaque(getDanoAtaque() + 5); // aumenta ataque
        } else {
            LogicaJogo.imprimirCabecalho("Você escolheu " + upgradesDef[numUpgradesDef] + "!");
            numUpgradesDef++;
            setPoderDefesa(getPoderDefesa() + 3); // aumenta defesa
        }

        LogicaJogo.insiraAlgoParaContinuar();
    }

    public void adicionarItem(String nomeItem, int quantidade) {
        inventario.put(nomeItem, inventario.getOrDefault(nomeItem, 0) + quantidade);
    }

    public void mostrarInventario() {
        LogicaJogo.limparTerminal();
        LogicaJogo.imprimirCabecalho("Inventário de " + getNome());
        if (inventario.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            for (String item : inventario.keySet()) {
                System.out.println(item + " x" + inventario.get(item));
            }
        }
        LogicaJogo.insiraAlgoParaContinuar();
    }
}
