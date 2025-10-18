package mercado;

// Classe que representa um pedido feito em uma mesa
// Guarda qual item foi pedido e quantas unidades
public class Pedido {
    private Opcoes item;
    private int quantidade;
    
    // Construtor - cria um novo pedido
    public Pedido(Opcoes item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }
    
    // GETTERS - métodos para pegar os valores
    public Opcoes getItem() { 
        return item; 
    }
    
    public int getQuantidade() { 
        return quantidade; 
    }
    
    // Calcula quanto vale esse pedido (preço x quantidade)
    public float getValor() {
        return item.getPreco() * quantidade;
    }
    
    // Mostra o pedido de forma organizada
    @Override
    public String toString() {
        return quantidade + "x " + item.getNome() + " - R$ " + getValor();
    }
}