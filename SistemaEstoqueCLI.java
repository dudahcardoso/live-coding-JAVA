import java.util.Scanner; // Importa a classe Scanner, essencial para ler entradas do usuário pelo console.
import java.util.Collection; // Importa a interface Collection, usada para lidar com a coleção de produtos retornada pelo gerenciador.

// SistemaEstoqueCLI.java
public class SistemaEstoqueCLI { // Declara a classe pública 'SistemaEstoqueCLI', que representa a interface de linha de comando do sistema de estoque.
    private static GerenciadorEstoque gerenciador = new GerenciadorEstoque(); // Declara e inicializa uma instância estática de 'GerenciadorEstoque' para gerenciar os produtos.
    private static Scanner scanner = new Scanner(System.in); // Declara e inicializa uma instância estática de 'Scanner' para ler a entrada do usuário do console.

    public static void main(String[] args) { // Método principal do programa, o ponto de entrada da aplicação.
        int opcao; // Declara uma variável inteira para armazenar a opção escolhida pelo usuário no menu.

        do { // Inicia um laço 'do-while', garantindo que o menu seja exibido pelo menos uma vez.
            exibirMenu(); // Chama o método para exibir as opções do menu ao usuário.
            System.out.print("Escolha uma opção: "); // Solicita ao usuário que digite uma opção.
            opcao = lerOpcao(); // Chama o método para ler a opção digitada pelo usuário, com tratamento de erros.

            switch (opcao) { // Inicia uma estrutura 'switch' para executar a ação correspondente à opção escolhida.
                case 1: // Se a opção for 1.
                    adicionarProduto(); // Chama o método para adicionar um novo produto.
                    break; // Sai do 'switch'.
                case 2: // Se a opção for 2.
                    removerProduto(); // Chama o método para remover um produto.
                    break; // Sai do 'switch'.
                case 3: // Se a opção for 3.
                    buscarProduto(); // Chama o método para buscar um produto.
                    break; // Sai do 'switch'.
                case 4: // Se a opção for 4.
                    listarProdutos(); // Chama o método para listar todos os produtos.
                    break; // Sai do 'switch'.
                case 5: // Se a opção for 5.
                    atualizarQuantidade(); // Chama o método para atualizar a quantidade de um produto.
                    break; // Sai do 'switch'.
                case 6: // Se a opção for 6.
                    darEntradaEstoque(); // Chama o método para dar entrada (aumentar) no estoque de um produto.
                    break; // Sai do 'switch'.
                case 7: // Se a opção for 7.
                    darSaidaEstoque(); // Chama o método para dar saída (diminuir) no estoque de um produto.
                    break; // Sai do 'switch'.
                case 0: // Se a opção for 0.
                    System.out.println("Saindo do sistema. Até mais!"); // Imprime uma mensagem de despedida.
                    break; // Sai do 'switch'.
                default: // Se a opção não corresponder a nenhum dos casos anteriores.
                    System.out.println("Opção inválida. Tente novamente."); // Informa ao usuário que a opção é inválida.
            }
            System.out.println("\n-----------------------------------\n"); // Imprime uma linha separadora para melhor organização visual.
        } while (opcao != 0); // Continua o laço 'do-while' enquanto a opção não for 0 (opção de sair).

        scanner.close(); // Fecha o objeto Scanner para liberar os recursos do sistema.
    }

    private static void exibirMenu() { // Método privado e estático para exibir o menu de opções ao usuário.
        System.out.println("----- Sistema de Gerenciamento de Estoque -----"); // Título do menu.
        System.out.println("1. Adicionar Produto"); // Opção 1.
        System.out.println("2. Remover Produto"); // Opção 2.
        System.out.println("3. Buscar Produto por ID"); // Opção 3.
        System.out.println("4. Listar Todos os Produtos"); // Opção 4.
        System.out.println("5. Atualizar Quantidade de Produto"); // Opção 5.
        System.out.println("6. Dar Entrada (Aumentar) em Estoque"); // Opção 6.
        System.out.println("7. Dar Saída (Diminuir) de Estoque"); // Opção 7.
        System.out.println("0. Sair"); // Opção 0 para sair do programa.
    }

    private static int lerOpcao() { // Método privado e estático para ler a opção do menu e validar se é um número inteiro.
        while (!scanner.hasNextInt()) { // Loop que continua enquanto a próxima entrada não for um inteiro.
            System.out.println("Entrada inválida. Por favor, digite um número."); // Mensagem de erro para entrada não numérica.
            scanner.next(); // Descarta a entrada inválida do buffer do scanner.
            System.out.print("Escolha uma opção: "); // Solicita a opção novamente.
        }
        int opcao = scanner.nextInt(); // Lê o número inteiro digitado pelo usuário.
        scanner.nextLine(); // Consome a quebra de linha restante no buffer após ler o inteiro (evita problemas com nextLine() posterior).
        return opcao; // Retorna a opção lida.
    }

    private static void adicionarProduto() { // Método privado e estático para solicitar informações e adicionar um produto.
        System.out.print("Nome do produto: "); // Solicita o nome do produto.
        String nome = scanner.nextLine(); // Lê o nome do produto digitado pelo usuário.
        System.out.print("Quantidade inicial: "); // Solicita a quantidade inicial.
        int quantidade = lerInteiro(); // Chama o método auxiliar para ler um inteiro (quantidade).
        System.out.print("Preço unitário: "); // Solicita o preço unitário.
        double preco = lerDouble(); // Chama o método auxiliar para ler um double (preço).

        gerenciador.adicionarProduto(nome, quantidade, preco); // Chama o método 'adicionarProduto' do objeto 'gerenciador' com os dados fornecidos.
    }

    private static void removerProduto() { // Método privado e estático para solicitar o ID e remover um produto.
        System.out.print("ID do produto a remover: "); // Solicita o ID do produto a ser removido.
        int id = lerInteiro(); // Lê o ID do produto.
        gerenciador.removerProduto(id); // Chama o método 'removerProduto' do 'gerenciador'.
    }

    private static void buscarProduto() { // Método privado e estático para solicitar o ID e buscar um produto.
        System.out.print("ID do produto a buscar: "); // Solicita o ID do produto a ser buscado.
        int id = lerInteiro(); // Lê o ID do produto.
        Produto produto = gerenciador.buscarProduto(id); // Chama o método 'buscarProduto' do 'gerenciador' e armazena o resultado.
        if (produto != null) { // Verifica se o produto foi encontrado (não é null).
            System.out.println("Produto encontrado:\n" + produto); // Imprime os detalhes do produto usando o método toString() da classe Produto.
        } else { // Se o produto não foi encontrado.
            System.out.println("Produto com ID " + id + " não encontrado."); // Imprime uma mensagem informando que o produto não foi encontrado.
        }
    }

    private static void listarProdutos() { // Método privado e estático para listar todos os produtos no estoque.
        Collection<Produto> produtos = gerenciador.listarTodosProdutos(); // Obtém uma coleção de todos os produtos do 'gerenciador'.
        if (produtos.isEmpty()) { // Verifica se a coleção de produtos está vazia.
            System.out.println("Nenhum produto no estoque."); // Imprime uma mensagem se não houver produtos.
        } else { // Se houver produtos.
            System.out.println("----- Produtos em Estoque -----"); // Imprime um cabeçalho.
            for (Produto p : produtos) { // Itera sobre cada 'Produto' na coleção 'produtos'.
                System.out.println(p); // Imprime a representação em string de cada produto (usando seu toString()).
            }
        }
    }

    private static void atualizarQuantidade() { // Método privado e estático para atualizar a quantidade de um produto.
        System.out.print("ID do produto para atualizar quantidade: "); // Solicita o ID do produto.
        int id = lerInteiro(); // Lê o ID.
        System.out.print("Nova quantidade: "); // Solicita a nova quantidade.
        int novaQuantidade = lerInteiro(); // Lê a nova quantidade.
        gerenciador.atualizarQuantidade(id, novaQuantidade); // Chama o método 'atualizarQuantidade' do 'gerenciador'.
    }
    
    private static void darEntradaEstoque() { // Método privado e estático para registrar uma entrada de estoque.
        System.out.print("ID do produto para dar entrada: "); // Solicita o ID do produto.
        int id = lerInteiro(); // Lê o ID.
        System.out.print("Quantidade a adicionar: "); // Solicita a quantidade a ser adicionada.
        int quantidade = lerInteiro(); // Lê a quantidade.
        gerenciador.darEntrada(id, quantidade); // Chama o método 'darEntrada' do 'gerenciador'.
    }

    private static void darSaidaEstoque() { // Método privado e estático para registrar uma saída de estoque.
        System.out.print("ID do produto para dar saída: "); // Solicita o ID do produto.
        int id = lerInteiro(); // Lê o ID.
        System.out.print("Quantidade a retirar: "); // Solicita a quantidade a ser retirada.
        int quantidade = lerInteiro(); // Lê a quantidade.
        gerenciador.darSaida(id, quantidade); // Chama o método 'darSaida' do 'gerenciador'.
    }

    // Métodos auxiliares para ler entradas numéricas com tratamento de erro
    private static int lerInteiro() { // Método auxiliar privado e estático para ler um número inteiro com validação.
        while (!scanner.hasNextInt()) { // Loop que continua enquanto a próxima entrada não for um inteiro.
            System.out.println("Entrada inválida. Por favor, digite um número inteiro."); // Mensagem de erro.
            scanner.next(); // Consome a entrada inválida para evitar loop infinito.
            System.out.print("Digite novamente: "); // Solicita a entrada novamente.
        }
        int valor = scanner.nextInt(); // Lê o inteiro válido.
        scanner.nextLine(); // Consome a quebra de linha restante.
        return valor; // Retorna o valor inteiro.
    }

    private static double lerDouble() { // Método auxiliar privado e estático para ler um número decimal (double) com validação.
        while (!scanner.hasNextDouble()) { // Loop que continua enquanto a próxima entrada não for um double.
            System.out.println("Entrada inválida. Por favor, digite um número decimal."); // Mensagem de erro.
            scanner.next(); // Consome a entrada inválida.
            System.out.print("Digite novamente: "); // Solicita a entrada novamente.
        }
        double valor = scanner.nextDouble(); // Lê o double válido.
        scanner.nextLine(); // Consome a quebra de linha restante.
        return valor; // Retorna o valor double.
    }
} // Fecha a declaração da classe 'SistemaEstoqueCLI'.