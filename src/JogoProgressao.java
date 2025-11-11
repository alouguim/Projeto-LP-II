import java.util.random.*;

public class JogoProgressao {
    private Jogador jogador;
    private Inimigo inimigo;
    private int dia = 1;
    private String[] tipoEncontro  = {"encontra ","esbarra em ", "passa por ", "tropeça em "};
    private String[] tipoMotivo = {"não gostar da sua cara ", "motivo nenhum ", "estar de mau humor ", "odiar sua existência ", "um rancor do passado "};
    private TipoInimigo[] tipoInimigo = {TipoInimigo.GOBLIN,TipoInimigo.LEPRECHAUM,TipoInimigo.ORC,TipoInimigo.TROLL,TipoInimigo.DEMONIO,TipoInimigo.VELHAMALDOSA};


    public JogoProgressao(Jogador jogador) {
        this.jogador = jogador;
    }

    public void cicloJogo(Jogador jogador){
        System.out.println("Sua jornada começa AGORA!");
        LogicaJogo.insiraAlgoParaContinuar();

        do {
            TipoInimigo diaAtual = imprimirDia();
            LogicaJogo.insiraAlgoParaContinuar();

            switch (diaAtual) {
                case GOBLIN:
                    inimigo = new Inimigo(diaAtual.toString(), 20, 5, 5, 10 );
                    break;
                case LEPRECHAUM:
                    inimigo = new Inimigo(diaAtual.toString(), 20, 3, 15, 10 );
                    break;
                case VELHAMALDOSA:
                    inimigo = new Inimigo(diaAtual.toString(), 20, 4, 5, 10 );
                    break;
                case ORC:
                    inimigo = new Inimigo(diaAtual.toString(), 40, 8, 80, 30 );
                    break;
                case TROLL:
                    inimigo = new Inimigo(diaAtual.toString(), 70, 10, 15, 40 );
                    break;
                case DEMONIO:
                    inimigo = new Inimigo(diaAtual.toString(), 140, 15, 25, 10 );
                    break;
                default:
                    break;
            };

            batalha(jogador, inimigo);
            dia += 1;

        } while (jogador.getHp() > 0);
    }

    public TipoInimigo imprimirDia() {
        LogicaJogo.limparTerminal();
        RandomGenerator numeroAleatorio = RandomGenerator.getDefault();

        int numeroAleatorioEncontro = numeroAleatorio.nextInt(3);
        int numeroAleatorioMotivo = numeroAleatorio.nextInt(4);
        int numeroAleatorioInimigo = numeroAleatorio.nextInt(5);

        System.out.println("Dia " + dia + ": Você "
        + this.tipoEncontro[numeroAleatorioEncontro]
        + this.tipoInimigo[numeroAleatorioInimigo].toString() + "! Por "
        + this.tipoMotivo[numeroAleatorioMotivo]
        + "uma batalha começa, prepare-se!");

        return this.tipoInimigo[numeroAleatorioInimigo];
    }

    // public void inicializarArrays(){


    // }

    public void batalha(Jogador jogador, Inimigo inimigo){
        jogador.setFugiu(false);
        do {
            LogicaJogo.limparTerminal();
            LogicaJogo.imprimirCabecalho("Sua ação! Como você ataca?");
            escolherAcao(jogador, inimigo);
            LogicaJogo.insiraAlgoParaContinuar();

            if(inimigo.getHp() <= 0){
                break;
            }
            LogicaJogo.imprimirCabecalho("Ação do seu inimigo!");
            inimigo.atacar(jogador, inimigo.getAtaquePadrao());
            LogicaJogo.insiraAlgoParaContinuar();
        } while (jogador.getHp() > 0 && inimigo.getHp() > 0);
        
        if (jogador.getHp() <= 0) {
            LogicaJogo.imprimirCabecalho("Você retornou para o abraço da Deusa..");
            LogicaJogo.insiraAlgoParaContinuar();
            LogicaJogo.menuInicial();
        }else if(jogador.getFugiu()){
            LogicaJogo.imprimirCabecalho("Você fugiu da batalha");
            LogicaJogo.insiraAlgoParaContinuar();
            LogicaJogo.menuInicial();
        } 
        else {
            LogicaJogo.imprimirCabecalho(inimigo.getNome() + " foi enviado de volta para a Deusa! Você vive para ver mais um dia.. ");
        }
    }

    public void escolherAcao(Jogador jogador, Inimigo inimigo) {
        Personagem classeJogador = jogador.getClasseObj();
        boolean respostaValida = false;
        int input;

        while (!respostaValida) {
            System.out.println("(1) Ataque normal");
            System.out.println("(2) Usar Magia");
            System.out.println("(3) Escapar"); 

            input = LogicaJogo.lerInt("-> ",3);
            try {
            switch (input) {
                case 1:
                    jogador.atacar(inimigo, jogador.getNomeAtaque());
                    respostaValida = true;
                    break;
                case 2:
                    jogador.usarMagia(inimigo, jogador.getNomeMagia(), jogador.getCustoMana());
                    respostaValida = true;
                    break;
                case 3: 
                    jogador.fugir();
                    inimigo.setHp(0);
                    respostaValida = true;
                    break;
                default:
                    System.out.println("Essa opção não existe!");
            }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Tente novamente!");
            }
        } 
    }
}
