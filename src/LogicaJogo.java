    import java.util.Scanner;

    public class LogicaJogo {
        static Scanner scanner = new Scanner(System.in);

        //pega inputs do usuario
        public static int lerInt(String prompt, int escolhasJogador){
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
        //simula uma limpa do terminal
        public static void limparTerminal(){
            for(int i = 0; i < 100; i++){
                System.out.println();
            }
        }

        //automatizaçao dos separadores -
        public static void imprimirSeparador(int n){
            for(int i = 0; i < n; i++){
                System.out.print("-");
            }
            System.out.println();
        }

        public static void imprimirCabecalho(String titulo){
            imprimirSeparador(30);
            System.out.println(titulo);
            imprimirSeparador(30);
        }

        public static void insiraAlgoParaContinuar(){
            System.out.println("\nInsira algo para continuar...");
            scanner.next();
        }

    }
