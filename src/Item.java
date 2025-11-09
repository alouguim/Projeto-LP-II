public class Item implements java.io.Serializable{
    public String nome;
    public Efeito efeito;
    public int poder;
    public Alvo alvo;
    public Efeito adicional;

    public Item(String nome) {
        switch (nome) {
            case "PocaoCura":
                this.nome = "Poção de Cura";
                this.alvo = Alvo.SELF;
                this.efeito = Efeito.CURA;
                this.poder = 25;
                break;
            case "PocaoForca":
                this.nome = "Poção de Cura";
                this.alvo = Alvo.SELF;
                this.efeito = Efeito.BUFF;
                this.poder = 5;
                break;
            case "PocaoDefesa":
                this.nome = "Poção de Defesa";
                this.alvo = Alvo.SELF;
                this.efeito = Efeito.BUFF;
                this.poder = 10;
                break;
            case "PocaoMana":
                this.nome = "Poção de Mana";
                this.alvo = Alvo.SELF;
                this.efeito = Efeito.CURA;
                this.poder = 50;
                break;
            case "PocaoFogo":
                this.nome = "Poção de Fogo";
                this.alvo = Alvo.ENEMY;
                this.efeito = Efeito.DANO;
                this.poder = 10;
                this.adicional = Efeito.DOT;
                break;
            case "PocaoVeneno":
                this.nome = "Poção de Veneno";
                this.alvo = Alvo.ENEMY;
                this.efeito = Efeito.DANO;
                this.poder = 5;
                this.adicional = Efeito.DOT;
                break;
            default:
                throw new IllegalArgumentException("Tipo de item não existe: " + nome);
        }
    }

    public Efeito getAdicional() {
        return adicional;
    }

    public Alvo getAlvo() {
        return alvo;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

}
