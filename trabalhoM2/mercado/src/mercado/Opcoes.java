package mercado;

// Classe que representa os itens do cardápio do restaurante
// Cada item tem um nome e um preço
public class Opcoes {
    private String nome;
    private float preco;
    
    // Construtor - cria um novo item do cardápio
    public Opcoes(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    // GETTERS - métodos para pegar os valores
    public String getNome() {
        return nome;
    }
    
    public float getPreco() {
        return preco;
    }
    
    // SETTERS - métodos para alterar os valores
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    // Método que mostra o item de forma bonita
    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}