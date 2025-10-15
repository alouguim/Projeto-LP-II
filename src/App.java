
public class App {

    public static void main(String[] args) throws Exception {
        Jogador kiana = new Jogador("Kiana", 100, 0, 20, 5, 50);
        Inimigo lobo = new Inimigo("Lobo", 80, 15, 3, 40);

        kiana.adicionarAtaqueFisico("Golpe de Espada", 10);
        kiana.adicionarAtaqueFisico("Investida", 15);
        kiana.adicionarMagia("Bola de Fogo", 30);

        while (kiana.getHp() > 0 && lobo.getHp() > 0) {
            LogicaJogo.limparTerminal();
            LogicaJogo.imprimirCabecalho("Turno do Jogador");
            kiana.atacar(lobo, "Golpe de Espada");
            LogicaJogo.insiraAlgoParaContinuar();

            if (lobo.getHp() > 0) {
                LogicaJogo.limparTerminal();
                LogicaJogo.imprimirCabecalho("Turno do Inimigo");
                lobo.agir(kiana);
                LogicaJogo.insiraAlgoParaContinuar();
            }
        }

        LogicaJogo.imprimirCabecalho("Resultado do Combate");
        if (kiana.getHp() > 0) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Você foi derrotado...");
        }
    }
}
