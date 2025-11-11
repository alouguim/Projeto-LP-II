import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SavePersonagens {

    private static final String FILE_NAME = "personagens.dat";

    private static HashMap<String, Jogador> carregarBanco() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HashMap<String, Jogador>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    private static void salvarBanco(HashMap<String, Jogador> banco) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(banco);
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static boolean temPersonagens() {
        return !carregarBanco().isEmpty();
    }

    public static void criarPersonagem(Jogador jogador) {
        HashMap<String, Jogador> banco = carregarBanco();
        banco.put(jogador.getNome(), jogador);
        salvarBanco(banco);
    }

    public static void salvarPersonagem(Jogador jogador) {
        HashMap<String, Jogador> banco = carregarBanco();
        banco.put(jogador.getNome(), jogador);
        salvarBanco(banco);
    }

    public static Jogador buscarPersonagem(String nome) {
        return carregarBanco().get(nome);
    }

    public static void deletarPersonagem(String nome) {
        HashMap<String, Jogador> banco = carregarBanco();
        if (banco.remove(nome) != null) salvarBanco(banco);
    }

    public static void listarPersonagens() {
        HashMap<String, Jogador> banco = carregarBanco();
        if (banco.isEmpty()) {
            System.out.println("Nenhum personagem salvo.");
            return;
        }

        for (Map.Entry<String, Jogador> e : banco.entrySet()) {
            Jogador j = e.getValue();
            System.out.println("- " + j.getNome() 
                + " (Classe: " + j.getClasseString() + ")"
                + " HP: " + j.getHp() + "/" + j.getMaxHp()
                + " Mana: " + j.getMana()
            );
        }
    }

    public static String listarEEscolherPersonagem() {
        HashMap<String, Jogador> banco = carregarBanco();
        if (banco.isEmpty()) return null;

        String[] nomes = banco.keySet().toArray(new String[0]);

        for (int i = 0; i < nomes.length; i++) {
            Jogador j = banco.get(nomes[i]);
            System.out.println("(" + (i + 1) + ") " + nomes[i] + " (Classe: " + j.getClasseString() + ")");
        }

        int escolha = LogicaJogo.lerInt("-> ", nomes.length);
        return nomes[escolha - 1];
    }
}
