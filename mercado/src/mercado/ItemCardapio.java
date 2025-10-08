package mercado;

/**
 * Classe que representa um item do cardápio do restaurante
 * Cada item tem nome, preço e descrição
 */
public class ItemCardapio {
    // Atributos do item do cardápio
    private String nome;       // Nome do prato/bebida
    private float preco;       // Preço em reais
    private String descricao;  // Descrição detalhada do item
    
    /**
     * Construtor - Cria um novo item para o cardápio
     * @param nome Nome do item
     * @param preco Preço em reais
     * @param descricao Descrição detalhada
     */
    public ItemCardapio(String nome, float preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
    
    // ==================== MÉTODOS DE ACESSO (GETTERS) ====================
    
    /**
     * @return Nome do item
     */
    public String getNome() { 
        return nome; 
    }
    
    /**
     * @return Preço do item
     */
    public float getPreco() { 
        return preco; 
    }
    
    /**
     * @return Descrição do item
     */
    public String getDescricao() { 
        return descricao; 
    }
    
    // ==================== MÉTODOS DE MODIFICAÇÃO (SETTERS) ====================
    
    /**
     * Altera o nome do item
     * @param nome Novo nome
     */
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    /**
     * Altera o preço do item
     * @param preco Novo preço
     */
    public void setPreco(float preco) { 
        this.preco = preco; 
    }
    
    /**
     * Altera a descrição do item
     * @param descricao Nova descrição
     */
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
    
    // ==================== MÉTODOS DE REPRESENTAÇÃO ====================
    
    /**
     * Retorna representação em string do item
     * @return String formatada com nome e preço
     */
    @Override
    public String toString() {
        return String.format("%s - R$ %.2f", nome, preco);
    }
}