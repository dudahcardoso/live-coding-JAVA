// Produto.java
public class Produto { // Declaração da classe 'Produto', que é pública e pode ser acessada de qualquer lugar.
    private int id; // Atributo privado 'id' do tipo inteiro para armazenar o identificador único do produto.
    private String nome; // Atributo privado 'nome' do tipo String para guardar o nome do produto.
    private int quantidadeEmEstoque; // Atributo privado 'quantidadeEmEstoque' do tipo inteiro para controlar o número de itens disponíveis.
    private double precoUnitario; // Atributo privado 'precoUnitario' do tipo double para armazenar o preço de uma unidade, permitindo valores decimais.

    public Produto(int id, String nome, int quantidadeEmEstoque, double precoUnitario) { // Construtor da classe 'Produto'. É público e aceita parâmetros para inicializar os atributos.
        this.id = id; // Atribui o valor do parâmetro 'id' ao atributo 'id' da instância atual do objeto.
        this.nome = nome; // Atribui o valor do parâmetro 'nome' ao atributo 'nome' da instância.
        this.quantidadeEmEstoque = quantidadeEmEstoque; // Atribui o valor do parâmetro 'quantidadeEmEstoque' ao atributo 'quantidadeEmEstoque' da instância.
        this.precoUnitario = precoUnitario; // Atribui o valor do parâmetro 'precoUnitario' ao atributo 'precoUnitario' da instância.
    }

    // Getters
    public int getId() { // Método 'getId()', público, retorna um inteiro. É um "getter" para o atributo 'id'.
        return id; // Retorna o valor atual do atributo 'id'.
    }

    public String getNome() { // Método 'getNome()', público, retorna uma String. É um "getter" para o atributo 'nome'.
        return nome; // Retorna o valor atual do atributo 'nome'.
    }

    public int getQuantidadeEmEstoque() { // Método 'getQuantidadeEmEstoque()', público, retorna um inteiro. "Getter" para a quantidade em estoque.
        return quantidadeEmEstoque; // Retorna o valor atual do atributo 'quantidadeEmEstoque'.
    }

    public double getPrecoUnitario() { // Método 'getPrecoUnitario()', público, retorna um double. "Getter" para o preço unitário.
        return precoUnitario; // Retorna o valor atual do atributo 'precoUnitario'.
    }

    // Setters (para permitir atualização de quantidade e, opcionalmente, nome/preço)
    public void setNome(String nome) { // Método 'setNome()', público, não retorna nada (void). É um "setter" para o atributo 'nome'.
        this.nome = nome; // Define o valor do atributo 'nome' com o valor passado como parâmetro.
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) { // Método 'setQuantidadeEmEstoque()', público, não retorna nada. "Setter" para a quantidade em estoque.
        this.quantidadeEmEstoque = quantidadeEmEstoque; // Define o valor do atributo 'quantidadeEmEstoque' com o valor passado como parâmetro.
    }

    public void setPrecoUnitario(double precoUnitario) { // Método 'setPrecoUnitario()', público, não retorna nada. "Setter" para o preço unitário.
        this.precoUnitario = precoUnitario; // Define o valor do atributo 'precoUnitario' com o valor passado como parâmetro.
    }

    @Override // Anotação que indica que este método está sobrescrevendo um método da superclasse (Object).
    public String toString() { // Método 'toString()', público, retorna uma String. Fornece uma representação textual do objeto.
        return "ID: " + id + // Concatena a string "ID: " com o valor do 'id'.
                ", Nome: " + nome + // Concatena ", Nome: " com o valor do 'nome'.
                ", Quantidade: " + quantidadeEmEstoque + // Concatena ", Quantidade: " com o valor da 'quantidadeEmEstoque'.
                ", Preço Unitário: R$" + String.format("%.2f", precoUnitario); // Concatena ", Preço Unitário: R$" e formata o 'precoUnitario' para ter duas casas decimais.
    }
} // Fecha a declaração da classe 'Produto'.