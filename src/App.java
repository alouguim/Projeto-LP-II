
public class App {

    public static void main(String[] args) throws Exception {
        LogicaJogo.comecarJogo();
        LogicaJogo.limparTerminal();
        LogicaJogo.imprimirCabecalho("Personagem criado com sucesso");
        System.out.println("Nome: " + LogicaJogo.jogador.getNome());
        System.out.println("Classe: " + LogicaJogo.jogador.getHp() + " HP, " + LogicaJogo.jogador.getDanoAtaque() + " Ataque, "
                + LogicaJogo.jogador.getPoderDefesa() + " Defesa, " + LogicaJogo.jogador.getMana() + " Mana");
    }
}
