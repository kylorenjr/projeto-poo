# 🛡️ Tower Defense - Projeto POO

Um jogo de Tower Defense desenvolvido em Java como projeto da disciplina de Programação Orientada a Objetos.

## 🚀 Como Rodar o Projeto

Este projeto pode ser executado em qualquer sistema operacional (Windows, macOS ou Linux).

### 📋 Pré-requisitos

Para rodar o jogo, é necessário ter uma versão recente do Java instalada:

1.  **Java Development Kit (JDK)**: Versão **24** ou superior.
    * *Atenção: Versões LTS anteriores (como Java 17 ou 21) NÃO rodarão este projeto.*
    * **Download Recomendado:** [Oracle JDK 25](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK 24](https://jdk.java.net/24/).

---

### 🎮 Opção 1: Executando o Jogo (Arquivo .JAR)

Esta é a forma mais simples, recomendada para quem quer apenas jogar.

#### **Modo A: Sem Terminal (Duplo Clique)**
1.  Certifique-se de ter o Java 24 ou 25 instalado.
2.  Baixe o arquivo `projeto-poo.jar`.
3.  **Dê dois cliques** no arquivo.
    * *O jogo deve abrir imediatamente.*

#### **Modo B: Via Terminal **
Se o duplo clique não funcionar, use o terminal para ver o log de execução.

1.  Abra o terminal na pasta onde está o arquivo `.jar`.
2.  Execute o comando:
    ```bash
    java -jar projeto-poo.jar
    ```

---

### 💻 Opção 2: Rodando pelo Código Fonte (Para Desenvolvedores)

Use esta opção se você deseja modificar o código ou compilar manualmente.

1.  Abra seu terminal.
2.  Clone o repositório e entre na pasta:
    ```bash
    git clone [https://github.com/kylorenjr/projeto-poo.git](https://github.com/kylorenjr/projeto-poo.git)
    cd projeto-poo
    ```

3.  Navegue até a pasta de código-fonte `src`:
    ```bash
    cd src
    ```

4.  **Compile** todos os arquivos `.java` de todos os pacotes:
    ```bash
    javac main/*.java enemies/*.java helpers/*.java inputs/*.java managers/*.java objects/*.java scenes/*.java ui/*.java
    ```

5.  **Execute** o projeto chamando a classe principal:
    ```bash
    java main.Game
    ```

---

## 📊 Diagrama de Classes

Aqui está o diagrama de classes do projeto, mostrando as principais entidades e suas relações.

```mermaid
classDiagram
    direction TD

    %% -- Classes "Soltas" (sem relações visíveis no diagrama) --
    class Utilz
    class Tile
    class Game
    class Tower
    class ImgFix
    class PathPoint
    class LoadSave
    class MyButton
    class GameStates
    class GameScreen

    %% -- Classes de UI e Telas (Scenes) --
    class GameScene
    class Constants
    class SceneMethods {
        <<interface>>
    }
    class Playing
    class Editing
    class Settings
    class Menu

    %% -- Relações das Cenas --
    GameScene <|-- Playing
    GameScene <|-- Editing
    GameScene <|-- Settings
    GameScene <|-- Menu
    
    SceneMethods <|.. Playing
    SceneMethods <|.. Editing
    SceneMethods <|.. Settings
    SceneMethods <|.. Menu
    
    GameScene --> Constants

    %% -- Classes de Inimigos (Enemy) --
    class Enemy
    class Orc
    class Bat
    class Wolf
    class Knight

    %% -- Relações dos Inimigos --
    Enemy <|-- Orc
    Enemy <|-- Bat
    Enemy <|-- Wolf
    Enemy <|-- Knight
    
    %% -- Gerenciadores (Managers) --
    class EnemyManager
    class TowerManager
    class TileManager
    class ProjectileManager
    
    EnemyManager --- TowerManager
    ProjectileManager --> Enemy

    %% -- Classes de Input e UI Auxiliar --
    class KeyListener
    class MyMouseListener
    class ToolBar
    class ActionBar
    class Bar

    KeyListener --- TileManager
    MyMouseListener --> ToolBar
    ActionBar --> ToolBar
    Bar --> ActionBar

    %% -- Outras Classes do Jogo --
    class Projectile
    class Render
    
    Projectile --- Render
