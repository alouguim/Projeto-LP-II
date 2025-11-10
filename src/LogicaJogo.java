
import java.util.Scanner;

public class LogicaJogo {

    static Scanner scanner = new Scanner(System.in);
    public static Jogador jogador; // jogador declarado como estático

    // pega inputs do usuario
    public static int lerInt(String prompt, int escolhasJogador) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Erro! Insira um inteiro.");
            }
        } while (input < 1 || input > escolhasJogador);
        return input;
    }

    // simula uma limpa do terminal
    public static void limparTerminal() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // automatização dos separadores -
    public static void imprimirSeparador(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void imprimirPersonagem(){
    System.out.println("Nome: " + LogicaJogo.jogador.getNome());
        System.out.println("Classe: " + LogicaJogo.jogador.getClasse() + "\nHP " + LogicaJogo.jogador.getHp() + "\nAtaque "
        + LogicaJogo.jogador.getDanoAtaque() + "\nDefesa " + LogicaJogo.jogador.getPoderDefesa() + "\nMana: " + LogicaJogo.jogador.getMana());
}
    public static void imprimirCabecalho(String titulo) {
        LogicaJogo.limparTerminal();
        imprimirSeparador(30);
        System.out.println(titulo);
        imprimirSeparador(30);
    }

    public static void insiraAlgoParaContinuar() {
        System.out.println("\nInsira algo para continuar...");
        scanner.next();
    }
    
    public static void menuInicial() {
        while (true) {
            limparTerminal();
            imprimirCabecalho("MENU INICIAL");

            int opcao = 0;

            if (SavePersonagens.temPersonagens()) {
                System.out.println("(1) Continuar jogando");
                System.out.println("(2) Criar novo personagem");
                System.out.println("(3) Mostrar personagens");
                System.out.println("(4) Deletar personagem");
                System.out.println("(5) Sair");
                opcao = lerInt("-> ", 5);
            } else {
                System.out.println("(1) Criar novo personagem");
                System.out.println("(2) Mostrar personagens (vazio)");
                System.out.println("(3) Sair");

                int escolha = lerInt("-> ", 3);
                if (escolha == 1) opcao = 2;
                if (escolha == 2) opcao = 3;
                if (escolha == 3) opcao = 5;
            }

            switch (opcao) {

                case 1 -> { // Continuar
                    limparTerminal();
                    imprimirCabecalho("Escolha o personagem:");
                    String nomeEscolhido = SavePersonagens.listarEEscolherPersonagem();
                    if (nomeEscolhido != null) {
                        jogador = SavePersonagens.buscarPersonagem(nomeEscolhido);
                        if (jogador != null) {
                            imprimirCabecalho("Personagem carregado!");
                            insiraAlgoParaContinuar();
                            return;
                        }
                    }
                }

                case 2 -> { // Novo personagem
                    comecarJogo();
                    return;
                }

                case 3 -> { // Mostrar
                    limparTerminal();
                    imprimirCabecalho("Personagens Salvos");
                    SavePersonagens.listarPersonagens();
                    insiraAlgoParaContinuar();
                }

                case 4 -> { // Deletar
                    limparTerminal();
                    imprimirCabecalho("Excluir personagem");
                    String nome = SavePersonagens.listarEEscolherPersonagem();
                    if (nome != null) {
                        SavePersonagens.deletarPersonagem(nome);
                        imprimirCabecalho("Personagem removido!");
                    }
                    insiraAlgoParaContinuar();
                }

                case 5 -> { // Sair
                    limparTerminal();
                    System.out.println("Até a próxima!");
                    System.exit(0);
                }
            }
        }
    }

    // método principal para começar o jogo
    public static void comecarJogo() {
        boolean nomeEscolhido = false;
        boolean classeEscolhida = false;
        String nome = "";
        String classe = "";
        int hp = 0, ataque = 0, defesa = 0, mana = 0;

        // Tela de introdução
        limparTerminal();
        imprimirSeparador(40);
        imprimirSeparador(30);
        System.out.println("JOGO LP 2");
        imprimirSeparador(30);
        imprimirSeparador(40);
        insiraAlgoParaContinuar();

        // Escolha do nome
        do {
            limparTerminal();
            imprimirCabecalho("Qual o seu nome?");
            nome = scanner.next();
            limparTerminal();
            imprimirCabecalho("Seu nome é " + nome + ".\nIsso está correto?");
            System.out.println("(1) Sim");
            System.out.println("(2) Não");
            int input = lerInt("->", 2);
            if (input == 1) {
                nomeEscolhido = true;
            }
        } while (!nomeEscolhido);

        // Escolha da classe
        do {
            limparTerminal();
            imprimirCabecalho("Qual a sua classe?");
            System.out.println("(1) Guerreiro");
            System.out.println("(2) Mago");
            System.out.println("(3) Defensor");

            int input = lerInt("->", 3);

            switch (input) {
                case 1 -> { // Guerreiro
                    classe = "Guerreiro";
                    hp = 120;
                    ataque = 15;
                    defesa = 5;
                    mana = 30;
                }
                case 2 -> { // Mago
                    classe = "Mago";
                    hp = 100;
                    ataque = 8;
                    defesa = 3;
                    mana = 100;
                }
                case 3 -> { // Defensor
                    classe = "Defensor";
                    hp = 150;
                    ataque = 10;
                    defesa = 15;
                    mana = 40;
                }
                default -> { // caso inválido
                    System.out.println("Opção inválida! Tente novamente.");
                    continue; // repete o loop
                }
            }

            limparTerminal();
            imprimirCabecalho("Sua classe é " + classe + "!\nIsso está correto?");
            System.out.println("(1) Sim");
            System.out.println("(2) Não");
            int escolha = lerInt("->", 2);
            if (escolha == 1) {
                classeEscolhida = true;
            }

        } while (!classeEscolhida);

        // Criação do jogador com atributos escolhidos
        jogador = new Jogador(nome, classe, hp, 0, ataque, defesa, mana);
        SavePersonagens.criarPersonagem(jogador);
    }   
}
