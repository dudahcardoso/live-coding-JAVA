# Sistema de Gerenciamento de Estoque Simplificado

Este projeto é um sistema básico de gerenciamento de estoque desenvolvido em Java, ideal para demonstrar conceitos fundamentais de Algoritmos e Estruturas de Dados em um cenário prático e voltado para o mercado de trabalho. Ele permite adicionar, remover, buscar, listar e atualizar produtos em um "estoque" virtual através de uma interface de linha de comando (CLI).

✨ **Funcionalidades**

O sistema oferece as seguintes operações CRUD (Create, Read, Update, Delete) para o gerenciamento de produtos:

**Adicionar Produto:** Insere um novo produto com ID único, nome, quantidade e preço.
**Remover Produto:** Exclui um produto do estoque pelo seu ID.
**Buscar Produto:** Localiza e exibe os detalhes de um produto específico usando seu ID.
**Listar Produtos:** Apresenta todos os produtos atualmente registrados no estoque.
**Atualizar Quantidade:** Modifica a quantidade em estoque de um produto existente.
**Dar Entrada em Estoque:** Aumenta a quantidade de um produto específico no estoque.
**Dar Saída de Estoque:** Diminui a quantidade de um produto específico no estoque, com validação para evitar estoque negativo.

🚀 **Conceitos Abordados**

Este projeto foi projetado para ilustrar e reforçar os seguintes conceitos-chave de Algoritmos e Estruturas de Dados:

**-Classes e Objetos:** Representação de entidades do mundo real (Produto) como objetos em Java.
**-Encapsulamento:** Uso de modificadores de acesso (private) e métodos getters/setters para controlar o acesso aos dados.
**-HashMap (Tabela Hash):** Utilizado para armazenar e gerenciar os produtos no GerenciadorEstoque. Este é um ponto crucial para demonstrar a eficiência de busca em O(1) (tempo constante, em média) em comparação com uma busca linear em listas.
**-Busca:** Implementação de busca por ID, explorando a eficiência do HashMap.
**-Validação de Dados:** Algoritmos simples para garantir a integridade dos dados (ex: quantidades não negativas).
**-Manipulação de Coleções:** Adição, remoção e iteração sobre coleções de objetos.
**-Estrutura de Menu/CLI:** Lógica para interagir com o usuário via linha de comando.

🛠️ #Como Rodar o Projeto
Para executar este projeto em sua máquina, siga os passos abaixo:

#Pré-requisitos
Java Development Kit (JDK): Versão 8 ou superior (recomenda-se JDK 17+).
Visual Studio Code (VS Code): Ou qualquer outra IDE Java (IntelliJ IDEA, Eclipse).
Extensão "Extension Pack for Java" (para VS Code): Instale-o através da aba de Extensões do VS Code.

#Passos
Clone ou Baixe o Repositório:

git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
(Se você não tem um repositório, crie uma pasta e copie os arquivos para ela).

Organize os Arquivos:
Certifique-se de que seus arquivos .java (Produto.java, GerenciadorEstoque.java, SistemaEstoqueCLI.java) estejam dentro de uma pasta src na raiz do seu projeto.

seu-projeto/
├── src/
│   ├── Produto.java
│   ├── GerenciadorEstoque.java
│   └── SistemaEstoqueCLI.java
└── ... outros arquivos do VS Code

#Abra no VS Code:
Abra a pasta raiz do seu projeto (seu-projeto) no Visual Studio Code (File > Open Folder...). O VS Code deve reconhecer automaticamente o projeto Java.

#Execute o Programa:

Abra o arquivo SistemaEstoqueCLI.java.
Clique no botão "Run" (o triângulo verde) que aparece acima do método main.

#Alternativamente, você pode usar a aba "Run and Debug" no VS Code ou executar via terminal:

cd src
javac *.java
java SistemaEstoqueCLI
O programa iniciará no terminal do VS Code (ou no seu terminal padrão), exibindo o menu de opções para gerenciar o estoque.

🧑‍💻 #Estrutura do Código

O projeto é dividido em três classes principais:

Produto.java: Define a estrutura de um produto, incluindo ID, nome, quantidade e preço. Contém getters e setters para acessar e modificar seus atributos.
GerenciadorEstoque.java: Responsável por todas as operações de estoque. Utiliza um HashMap para armazenar os produtos, otimizando a busca por ID.
SistemaEstoqueCLI.java: A classe principal com o método main. Fornece a interface de linha de comando para o usuário interagir com o sistema, exibindo menus e processando as entradas.
