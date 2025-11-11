```mermaid
classDiagram
    class App {
    }

    class LogicaJogo {
    }

    class SavePersonagens {
    }

    class Jogador {
        +String nome
        +int hp
        +int mana
        +TipoClasse classe
        +void atacar()
        +void upar()
    }

    class Inventario {
        +List~Item~ itens
        +void adicionarItem(Item i)
        +void removerItem(Item i)
    }

    class Item {
        +String nome
        +int quantidade
    }

    class Personagem {
        <<abstract>>
        +String nome
        +int hp
        +int mana
        +void atacar()
    }

    class Inimigo {
        +TipoInimigo tipo
        +void atacar()
    }

    class Classe {
        <<factory>>
        +Personagem criar(String tipo)
    }

    class Mago {
    }

    class Guerreiro {
    }

    class Defensor {
    }

    class TipoClasse {
        <<enum>>
        MAGO
        GUERREIRO
        DEFENSOR
    }

    class TipoInimigo {
        <<enum>>
        ORC
        GOBLIN
        TROLL
        LEPRECHAUM
        VELHAMALDOSA
        DEMONIO
    }

    App --> LogicaJogo
    LogicaJogo --> Jogador
    LogicaJogo --> SavePersonagens
    Jogador --> Inventario
    Inventario --> Item

    Personagem <|-- Jogador
    Personagem <|-- Inimigo

    Classe <|-- Mago
    Classe <|-- Guerreiro
    Classe <|-- Defensor

    Jogador "1" o-- "1" TipoClasse
    Inimigo "1" o-- "1" TipoInimigo