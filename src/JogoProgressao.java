import java.util.ArrayList;
import java.util.random.*;

public class JogoProgressao {
    private Jogador jogador;
    private int dia = 1;
    private ArrayList<String> tipoEncontro = new ArrayList<>();
    private ArrayList<String> tipoMotivo = new ArrayList<>();
    private ArrayList<TipoInimigo> tipoInimigo = new ArrayList<>();


    public JogoProgressao(Jogador jogador) {
        this.jogador = jogador;
        cicloJogo(this.jogador);
    }

    public void cicloJogo(Jogador jogador){
        System.out.println("Sua jornada começa AGORA!");
        LogicaJogo.insiraAlgoParaContinuar();

        do {
            TipoInimigo diaAtual = imprimirDia();
            LogicaJogo.insiraAlgoParaContinuar();
            Inimigo inimigo;

            switch (diaAtual) {
                case GOBLIN:
                    inimigo = new Inimigo(diaAtual.toString(), 30, 10, 5, 10 );
                    break;
                case LEPRECHAUM:
                    inimigo = new Inimigo(diaAtual.toString(), 30, 5, 10, 10 );
                    break;
                case VELHAMALDOSA:
                    inimigo = new Inimigo(diaAtual.toString(), 30, 5, 5, 10 );
                    break;
                case ORC:
                    inimigo = new Inimigo(diaAtual.toString(), 50, 10, 10, 30 );
                    break;
                case TROLL:
                    inimigo = new Inimigo(diaAtual.toString(), 100, 15, 20, 40 );
                    break;
                case DEMONIO:
                    inimigo = new Inimigo(diaAtual.toString(), 200, 25, 30, 50 );
                    break;
                default:
                    break;
            }



        } while (jogador.getHp() > 0);
    }

    public TipoInimigo imprimirDia() {
        LogicaJogo.limparTerminal();
        RandomGenerator numeroAleatorio = RandomGenerator.getDefault();

        int numeroAleatorioEncontro = numeroAleatorio.nextInt(3);
        int numeroAleatorioMotivo = numeroAleatorio.nextInt(4);
        int numeroAleatorioInimigo = numeroAleatorio.nextInt(5);

        System.out.println("Dia " + dia + ": Você "
        + this.tipoEncontro.get(numeroAleatorioEncontro)
        + this.tipoInimigo.get(numeroAleatorioInimigo).toString() + "! Por "
        + this.tipoMotivo.get(numeroAleatorioMotivo)
        + "uma batalha começa, prepare-se!");

        return this.tipoInimigo.get(numeroAleatorioInimigo);
    }

    public void inicializarArrays(){
        this.tipoEncontro.add("encontra ");
        this.tipoEncontro.add("esbarra em ");
        this.tipoEncontro.add("passa por ");
        this.tipoEncontro.add("tropeça em ");

        this.tipoMotivo.add("não gostar da sua cara ");
        this.tipoMotivo.add("motivo nenhum" );
        this.tipoMotivo.add("estar de mau humor ");
        this.tipoMotivo.add("odiar sua existência ");
        this.tipoMotivo.add("um rancor do passado ");

        this.tipoInimigo.add(TipoInimigo.GOBLIN);
        this.tipoInimigo.add(TipoInimigo.LEPRECHAUM);
        this.tipoInimigo.add(TipoInimigo.ORC);
        this.tipoInimigo.add(TipoInimigo.TROLL);
        this.tipoInimigo.add(TipoInimigo.DEMONIO);
        this.tipoInimigo.add(TipoInimigo.VELHAMALDOSA);
    }

    public void batalha(Jogador jogador, Inimigo inimigo){
        do {
            LogicaJogo.limparTerminal();
            System.out.println("Sua ação! Como você ataca?");
        } while (jogador.getHp() > 0 || inimigo.getHp() > 0);
    }

    public void escolherAcao(Jogador jogador, Inimigo inimigo) {
        System.out.println("(1) Ataque normal");
        System.out.println("(2) Usar Magia");
        int input = LogicaJogo.lerInt("-> ", 2);
        try {
            // switch (input) {
            //     case 1:
            //         jogador.atacar(inimigo, jogador.getNomeAtaque());
            //         break;
            //     case 2:
            //         jogador.usarMagia(inimigo, jogador.getNomeMagia(), jogador.);
            //         break;
            //     default:
            //         throw new IllegalArgumentException("Essa opção não existe!");
            // }
        } catch (Exception IllegalArgumentException) {
            escolherAcao(jogador, inimigo);
            return;
        }
    }
}
