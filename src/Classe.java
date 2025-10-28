public class Classe{
    
   public int maxHp;
   public int xp;
   public int danoAtaque;
   public int poderDefesa;
   public int mana;
   public String classe;
   public String nome;

   // public Classe(String nome, String classeAtribuida, int maxHp,int xp, int danoAtaque ,int poderDefesa, int mana) {
   //    this.nome = nome;
   //    this.maxHp = maxHp;
   //    this.xp = xp;
   //    this.danoAtaque = danoAtaque;
   //    this.poderDefesa = poderDefesa;
   //    this.mana = mana;
   //    this.classe = classeAtribuida;

   //    this.atribuirClasse(TipoClasse.valueOf(classeAtribuida.toUpperCase()));
   // }
    
   public static Personagem atribuirClasse(TipoClasse classe, String nome, int maxHp, int xp, int danoAtaque, int poderDefesa, int mana) {
      switch (classe) {
         case MAGO:
               Mago novoMago = new Mago(nome, maxHp,xp,danoAtaque, poderDefesa, mana);
            return novoMago;
         case GUERREIRO:
               Guerreiro novoGuerreiro = new Guerreiro(nome, maxHp,xp,danoAtaque, poderDefesa, mana);
            return novoGuerreiro;
         case DEFENSOR:
               Defensor novoDefensor = new Defensor(nome, maxHp,xp,danoAtaque, poderDefesa, mana);
            return novoDefensor;
         default:
               throw new IllegalArgumentException("Classe não existente: " + classe);
   }
   };

   public static String[] getUpgrades(int tipoUpgrade, TipoClasse classe){
      if (tipoUpgrade == 1) {
         switch (classe) {
            case MAGO:
               String[] upgradesMago = Mago.getUpgradesAtk();
               return upgradesMago;
            case GUERREIRO:
               String[] upgradesGuerreiro = Guerreiro.getUpgradesAtk();
               return upgradesGuerreiro;
            case DEFENSOR:
               String[] upgradesDefensor = Defensor.getUpgradesAtk();
               return upgradesDefensor;
         default:
               throw new IllegalArgumentException("Classe não existente para pegar upgrades: " + classe);
         }
      } else {
         switch (classe) {
            case MAGO:
               String[] upgradesMago = Mago.getUpgradesDef();
               return upgradesMago;
            case GUERREIRO:
               String[] upgradesGuerreiro = Guerreiro.getUpgradesDef();
               return upgradesGuerreiro;
            case DEFENSOR:
               String[] upgradesDefensor = Defensor.getUpgradesDef();
               return upgradesDefensor;
         default:
               throw new IllegalArgumentException("Classe não existente para pegar upgrades: " + classe);
         }
      }
   }

   public String getClasse() {
      return classe;
   }

   public String getNome() {
      return nome;
   }

   public int getMaxHp() {
      return maxHp;
   }

   public int getXp() {
      return xp;
   }

   public int getDanoAtaque() {
      return danoAtaque;
   }

   public int getPoderDefesa() {
      return poderDefesa;
   }

   public int getMana() {
      return mana;
   }
   
public void setMaxHp(int var1) {
      if (var1 <= 0) {
         this.maxHp = 1;
   } else {
         this.maxHp = var1;
   }
}

public void setDanoAtaque(int var1) {
      this.danoAtaque = var1;
}

public void setPoderDefesa(int var1) {
      this.poderDefesa = var1;
}

public void setMana(int var1) {
      if (var1 < 0) {
         this.mana = 0;
   } else {
         this.mana = var1;
   }

}
}
