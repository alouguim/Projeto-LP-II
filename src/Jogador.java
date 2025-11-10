import java.util.Map;

public class Jogador extends Personagem {

    private Inventario inventario;
    public String[] upgradesAtk = {"Força", "Poder", "Força Divina"};
    public String[] upgradesDef = {"Ossos Pesados", "Passos Rápidos", "Aura Divina"};
    public int numUpgradesAtk;
    public int numUpgradesDef;
    public String classeEscolhida;
    public Personagem classe;

    // Construtor
    public Jogador(String nome, String classeEscolhida, int maxHp, int xp, int danoAtaque, int poderDefesa, int mana) {
        super(nome, maxHp, xp, danoAtaque, poderDefesa, mana); // agora respeita os valores passados
        this.numUpgradesAtk = 0;
        this.numUpgradesDef = 0;
        this.classeEscolhida = classeEscolhida;
        Personagem classe = Classe.atribuirClasse(TipoClasse.valueOf(classeEscolhida.toUpperCase()),nome, maxHp,xp,danoAtaque, poderDefesa, mana);
        escolherTraits(classe);
    }

    public int atacar() {
        return getDanoAtaque();
    }

    public int defender() {
        return getPoderDefesa();
    }

    public String getClasse(){
        return classeEscolhida;
    }

    // public int getCustoMana(){
    //     return this.classe.
    // }

    public void escolherTraits(Personagem classe) {
        this.classe = classe;
        LogicaJogo.imprimirCabecalho("Escolha uma característica:");
        String upgradesATK[] = Classe.getUpgrades(1, TipoClasse.valueOf(classeEscolhida.toUpperCase()));
        String upgradesDEF[] = Classe.getUpgrades(2, TipoClasse.valueOf(classeEscolhida.toUpperCase()));
        System.out.println("(1) " + upgradesATK[numUpgradesAtk]);
        System.out.println("(2) " + upgradesDEF[numUpgradesDef]);

        int input = LogicaJogo.lerInt("-> ", 2);
         if (input == 1) {
            LogicaJogo.imprimirCabecalho("Você escolheu " + upgradesATK[numUpgradesAtk] + "!");
            numUpgradesAtk++;
            setDanoAtaque(getDanoAtaque() + 5); // aumenta ataque
        } else {
            LogicaJogo.imprimirCabecalho("Você escolheu " + upgradesDEF[numUpgradesDef] + "!");
            numUpgradesDef++;
            setPoderDefesa(getPoderDefesa() + 3); // aumenta defesa
        }
        LogicaJogo.limparTerminal();
        LogicaJogo.imprimirCabecalho("Escolha um conjunto de itens iniciais:");
        System.out.println("(1) CONJUNTO OFENSIVO - 1 Poção de Cura e 1 Poção de Força");
        System.out.println("(2) CONJUNTO DEFENSIVO -1 Poção de Cura e 1 Poção de Defesa");
        System.out.println("(3) CONJUNTO BALANCEADO - 2 Poção de Cura e 1 Poção de Mana");
        int inputConjunto = LogicaJogo.lerInt("-> ", 2);
        String conjuntoString = "";
        if (inputConjunto == 1) {
            this.inventario = new Inventario(Conjuntos.CONJOFENSIVO);
            conjuntoString = "Conjunto Ofensivo!";
        } else if (inputConjunto == 2) {
            this.inventario = new Inventario(Conjuntos.CONJDEFENSIVO);
            conjuntoString = "Conjunto Defensivo!";
        } else {
            this.inventario = new Inventario(Conjuntos.CONJBALANCEADO);
            conjuntoString = "Conjunto Balanceado!";
        }
        
        LogicaJogo.imprimirCabecalho("Você escolheu o " + conjuntoString + "!");
        LogicaJogo.insiraAlgoParaContinuar();
    }

    public void mostrarInventario() {
        LogicaJogo.imprimirCabecalho("Inventário de " + getNome());

        if (inventario.getQuantidadeItens() == null) {
            System.out.println("Seu inventário está vazio.");
        } else {
            for ( Map.Entry<String, Integer> item : inventario.getQuantidadeItens().entrySet()) {  
                System.out.println(item.getKey() + ": " + item.getValue() );
            }
        }
        LogicaJogo.insiraAlgoParaContinuar();
    }

}
