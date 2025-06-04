import java.util.HashMap; // Importa a classe HashMap, que é uma implementação de Map para armazenar dados em pares chave-valor.
import java.util.Map; // Importa a interface Map, que define o comportamento de um mapa (coleção de pares chave-valor).
import java.util.Collection; // Importa a interface Collection, usada aqui para retornar uma coleção de produtos.

// GerenciadorEstoque.java
public class GerenciadorEstoque { // Declaração da classe pública 'GerenciadorEstoque', responsável por gerenciar os produtos no estoque.
    // Usamos um HashMap para armazenar os produtos.
    // A chave (Integer) é o ID do produto, e o valor (Produto) é o objeto Produto.
    // Isso permite buscas por ID em tempo O(1) em média.
    private Map<Integer, Produto> estoque; // Declara um atributo privado 'estoque' do tipo Map. Ele guardará objetos 'Produto' associados aos seus 'ID's.
    private int proximoId; // Atributo privado 'proximoId' do tipo inteiro, usado para gerar IDs únicos para novos produtos.

    public GerenciadorEstoque() { // Construtor da classe 'GerenciadorEstoque'. É chamado quando um novo objeto GerenciadorEstoque é criado.
        this.estoque = new HashMap<>(); // Inicializa o atributo 'estoque' com uma nova instância de HashMap vazia.
        this.proximoId = 1; // Inicializa 'proximoId' com 1, garantindo que o primeiro produto terá ID 1.
    }

    public Produto adicionarProduto(String nome, int quantidade, double preco) { // Método público para adicionar um novo produto ao estoque.
        if (quantidade < 0 || preco < 0) { // Verifica se a quantidade ou o preço são valores negativos (validação de entrada).
            System.out.println("Erro: Quantidade e preço não podem ser negativos."); // Imprime uma mensagem de erro se a validação falhar.
            return null; // Retorna null indicando que o produto não foi adicionado.
        }
        // Cria um novo objeto 'Produto', usando o 'proximoId' (e incrementando-o para a próxima vez), nome, quantidade e preço.
        Produto novoProduto = new Produto(proximoId++, nome, quantidade, preco);
        estoque.put(novoProduto.getId(), novoProduto); // Adiciona o 'novoProduto' ao 'estoque' usando seu ID como chave.
        System.out.println("Produto '" + nome + "' adicionado com ID: " + novoProduto.getId()); // Imprime uma mensagem de sucesso com o ID do produto.
        return novoProduto; // Retorna o objeto 'novoProduto' recém-criado.
    }

   
    public boolean removerProduto(int id) { // Método público para remover um produto do estoque dado seu ID.
        if (estoque.containsKey(id)) { // Verifica se o 'estoque' contém um produto com o 'id' especificado.
            Produto produtoRemovido = estoque.remove(id); // Remove o produto do 'estoque' e armazena o objeto removido.
            System.out.println("Produto '" + produtoRemovido.getNome() + "' (ID: " + id + ") removido."); // Imprime mensagem de sucesso informando qual produto foi removido.
            return true; // Retorna true indicando que a remoção foi bem-sucedida.
        } else { // Se o produto com o ID não for encontrado.
            System.out.println("Erro: Produto com ID " + id + " não encontrado."); // Imprime uma mensagem de erro.
            return false; // Retorna false indicando que o produto não foi encontrado e não pôde ser removido.
        }
    }

    
    public Produto buscarProduto(int id) { // Método público para buscar um produto pelo seu ID.
        return estoque.get(id); // Retorna o objeto 'Produto' associado ao 'id' no 'estoque'. Retorna 'null' se não encontrar.
    }

    /**
     * Lista todos os produtos atualmente no estoque.
     * @return Uma coleção de todos os produtos no estoque.
     */
    public Collection<Produto> listarTodosProdutos() { // Método público para obter uma coleção de todos os produtos no estoque.
        return estoque.values(); // Retorna uma Collection contendo todos os objetos 'Produto' (os valores) presentes no mapa 'estoque'.
    }

  
    public boolean atualizarQuantidade(int id, int novaQuantidade) { // Método público para atualizar diretamente a quantidade de um produto.
        if (novaQuantidade < 0) { // Valida se a 'novaQuantidade' é negativa.
            System.out.println("Erro: Nova quantidade não pode ser negativa."); // Imprime erro se for negativa.
            return false; // Retorna false indicando falha na atualização.
        }
        Produto produto = buscarProduto(id); // Busca o produto pelo ID usando o método 'buscarProduto'.
        if (produto != null) { // Verifica se o produto foi encontrado.
            produto.setQuantidadeEmEstoque(novaQuantidade); // Define a nova quantidade diretamente no objeto 'Produto'.
            System.out.println("Quantidade do produto '" + produto.getNome() + "' (ID: " + id + ") atualizada para " + novaQuantidade + "."); // Mensagem de sucesso.
            return true; // Retorna true indicando sucesso na atualização.
        } else { // Se o produto não foi encontrado.
            System.out.println("Erro: Produto com ID " + id + " não encontrado para atualização."); // Imprime mensagem de erro.
            return false; // Retorna false.
        }
    }
    
   
    public boolean darEntrada(int id, int quantidade) { // Método público para adicionar (dar entrada) uma quantidade ao estoque de um produto.
        if (quantidade <= 0) { // Valida se a 'quantidade' a ser adicionada é não positiva.
            System.out.println("Erro: A quantidade de entrada deve ser positiva."); // Imprime erro.
            return false; // Retorna false.
        }
        Produto produto = buscarProduto(id); // Busca o produto pelo ID.
        if (produto != null) { // Se o produto for encontrado.
            // Atualiza a quantidade do produto, somando a quantidade existente com a nova quantidade de entrada.
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() + quantidade); 
            System.out.println("Entrada de " + quantidade + " unidades do produto '" + produto.getNome() + "' (ID: " + id + ") registrada."); // Mensagem de sucesso.
            return true; // Retorna true.
        } else { // Se o produto não for encontrado.
            System.out.println("Erro: Produto com ID " + id + " não encontrado para entrada."); // Imprime mensagem de erro.
            return false; // Retorna false.
        }
    }

    
    public boolean darSaida(int id, int quantidade) { // Método público para subtrair (dar saída) uma quantidade do estoque de um produto.
        if (quantidade <= 0) { // Valida se a 'quantidade' a ser retirada é não positiva.
            System.out.println("Erro: A quantidade de saída deve ser positiva."); // Imprime erro.
            return false; // Retorna false.
        }
        Produto produto = buscarProduto(id); // Busca o produto pelo ID.
        if (produto != null) { // Se o produto for encontrado.
            if (produto.getQuantidadeEmEstoque() >= quantidade) { // Verifica se há estoque suficiente para a saída.
                // Atualiza a quantidade do produto, subtraindo a quantidade a ser retirada.
                produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade); 
                System.out.println("Saída de " + quantidade + " unidades do produto '" + produto.getNome() + "' (ID: " + id + ") registrada."); // Mensagem de sucesso.
                return true; // Retorna true.
            } else { // Se não houver estoque suficiente.
                System.out.println("Erro: Quantidade insuficiente em estoque para o produto '" + produto.getNome() + "'. Disponível: " + produto.getQuantidadeEmEstoque()); // Mensagem de erro.
                return false; // Retorna false.
            }
        } else { // Se o produto não for encontrado.
            System.out.println("Erro: Produto com ID " + id + " não encontrado para saída."); // Imprime mensagem de erro.
            return false; // Retorna false.
        }
    }
} // Fecha a declaração da classe 'GerenciadorEstoque'.