public class Item implements java.io.Serializable{
    public String nome;
    public Efeito efeito;
    public int poder;
    public Alvo alvo;
    public Efeito adicional;

    public Item(String nome) {
        switch (nome) {
            case "pocaoCura":
                this.nome = "Poção de Cura";
                this.alvo = Alvo.SELF;
                this.efeito = Efeito.CURA;
                this.poder = 25;
                break;
            case "pocaoForca":
                this.nome = "Poção de Cura";
                this.alvo = Alvo.SELF;
                this.efeito = Efeito.BUFF;
                this.poder = 5;
                break;
            case "pocaoDefesa":
                this.nome = "Poção de Defesa";
                this.alvo = Alvo.SELF;
                this.efeito = Efeito.BUFF;
                this.poder = 10;
                break;
            case "pocaoMana":
                this.nome = "Poção de Mana";
                this.alvo = Alvo.SELF;
                this.efeito = Efeito.CURA;
                this.poder = 50;
                break;
            case "pocaoFogo":
                this.nome = "Poção de Fogo";
                this.alvo = Alvo.ENEMY;
                this.efeito = Efeito.DANO;
                this.poder = 10;
                this.adicional = Efeito.DOT;
                break;
            case "pocaoVeneno":
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
