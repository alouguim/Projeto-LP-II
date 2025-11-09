import java.util.ArrayList;
import java.util.HashMap;

public class Inventario {
    
    public String tipo;
    public Alvo alvo;
    public ArrayList<String> conjuntoItem = new ArrayList<>();
    public ArrayList<Item> itens;
    private HashMap<String, Integer> quantidadeItens = new HashMap<>();

    public Inventario(Conjuntos conjuntoItem){
        switch (conjuntoItem) {
            case CONJOFENSIVO:
                this.conjuntoItem.add("pocaoForca");
                this.conjuntoItem.add("pocaoCura");
                this.itens.add(new Item("pocaoCura"));
                this.itens.add(new Item("pocaoForca"));
                for (Item item : itens) {
                    quantidadeItens.put(item.getNome(), 1);
                }
                break;
            case CONJDEFENSIVO:
                this.conjuntoItem.add("pocaDefesa");
                this.conjuntoItem.add("pocaoCura");
                this.itens.add(new Item("pocaoDefesa"));
                this.itens.add(new Item("pocaoCura"));
                for (Item item : itens) {
                    quantidadeItens.put(item.getNome(), 1);
                }
                break;            
            case CONJBALANCEADO:
                this.conjuntoItem.add("pocaoMana");
                this.conjuntoItem.add("pocaoCura");
                this.conjuntoItem.add("pocaoCura");
                this.itens.add(new Item("pocaoCura"));
                this.itens.add(new Item("pocaoCura"));
                this.itens.add(new Item("pocaoMana"));
                for (Item item : itens) {
                    quantidadeItens.put(item.getNome(), 1);
                }
                break;
            default:
                break;
        }
    }

    public HashMap<String, Integer> getQuantidadeItens() {
        if (quantidadeItens.isEmpty()){
            return null;
        }
        return quantidadeItens;
    }

    public Item usarItem(String nome){
        for (Item itemUsado: itens) {
            if (itemUsado.getNome().equals(nome)) {
                int atual = quantidadeItens.getOrDefault(nome, 0);
                if (atual == 0){
                    System.out.println("Não existe nenhum item " + nome + "restando no Inventário.");
                    return null;
                }
                quantidadeItens.put(nome, atual - 1);
                return itemUsado;
            }
        }
        return null;
    };
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