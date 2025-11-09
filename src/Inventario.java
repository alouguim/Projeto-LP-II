import java.util.ArrayList;
import java.util.HashMap;

public class Inventario implements java.io.Serializable {

    public ArrayList<String> conjuntoItem = new ArrayList<>();
    public ArrayList<Item> itens = new ArrayList<>();
    private HashMap<String, Integer> quantidadeItens = new HashMap<>();

    public Inventario(Conjuntos conjuntoItem){
        switch (conjuntoItem) {
            case CONJOFENSIVO:
                this.conjuntoItem.add("PocaoForca");
                this.conjuntoItem.add("PocaoCura");

                itens.add(new Item("PocaoCura"));
                itens.add(new Item("PocaoForca"));
                break;

            case CONJDEFENSIVO:
                this.conjuntoItem.add("PocaoDefesa");
                this.conjuntoItem.add("PocaoCura");

                itens.add(new Item("PocaoDefesa"));
                itens.add(new Item("PocaoCura"));
                break;

            case CONJBALANCEADO:
                this.conjuntoItem.add("PocaoMana");
                this.conjuntoItem.add("PocaoCura");
                this.conjuntoItem.add("PocaoCura");

                itens.add(new Item("PocaoCura"));
                itens.add(new Item("PocaoCura"));
                itens.add(new Item("PocaoMana"));
                break;
        }

        // Preenche HashMap
        for (Item item : itens) {
            quantidadeItens.put(item.getNome(), quantidadeItens.getOrDefault(item.getNome(), 0) + 1);
        }
    }

    public HashMap<String, Integer> getQuantidadeItens() {
        return quantidadeItens.isEmpty() ? null : quantidadeItens;
    }

    public Item usarItem(String nome){
        for (Item itemUsado: itens) {
            if (itemUsado.getNome().equals(nome)) {
                int atual = quantidadeItens.getOrDefault(nome, 0);
                if (atual == 0){
                    System.out.println("Não existe nenhum item " + nome + " restando no Inventário.");
                    return null;
                }
                quantidadeItens.put(nome, atual - 1);
                return itemUsado;
            }
        }
        return null;
    }
}

// Inventario - > Pessoa escolhe o tipo de conjunto de itens iniciais
// Conjuntos:
// ConJ Ofensivo: poção de aumento de força - poção de fogo
// Conj Defensivo: poção de aumento de defesa - poção de cura
// Conj Balanceado: poção de cura - poção de debilitar
// 
// 
// 
// 
// 