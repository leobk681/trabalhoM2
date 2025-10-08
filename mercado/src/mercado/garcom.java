package mercado;

/**
 * Classe que representa um garçom do restaurante
 * Herda de Funcionario e tem funcionalidades específicas para atendimento
 * CORREÇÃO: Agora herda de classe concreta
 */
public class garcom extends funcionario {
    // Atributo específico do garçom - controla total de vendas realizadas
    private float totalVendas;
    
    /**
     * Construtor - Inicializa um garçom com dados básicos
     * @param nome Nome do garçom
     * @param codigo Código identificador
     * @param usuario Usuário para login
     * @param senha Senha para login
     */
    public garcom(String nome, int codigo, String usuario, String senha) {
        // Chama construtor da classe pai (Funcionario)
        super(nome, codigo, usuario, senha);
        this.totalVendas = 0.0f;  // Inicia com vendas zeradas
    }
    
    // ==================== SOBRESCRITA DO MÉTODO GETCARGO ====================
    
    /**
     * Retorna o cargo específico do garçom
     * @return String com o cargo
     */
    @Override
    public String getCargo() {
        return "Garçom";
    }
    
    // ==================== MÉTODOS ESPECÍFICOS DO GARÇOM ====================
    
    /**
     * Anota um novo pedido para uma mesa
     * @param mesa Mesa que está fazendo o pedido
     * @param descricao Descrição do pedido
     * @param valor Valor total do pedido
     * @throws SecurityException Se garçom não estiver autenticado
     * @throws IllegalArgumentException Se dados forem inválidos
     */
    public void anotarPedido(mesa mesa, String descricao, float valor) {
        // Verifica se garçom está autenticado
        if (!isAutenticado()) {
            throw new SecurityException("Garçom não autenticado!");
        }
        
        // Valida parâmetros
        if (mesa == null) {
            throw new IllegalArgumentException("Mesa não pode ser nula");
        }
        
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pedido deve ser positivo");
        }
        
        // Cria novo pedido e adiciona à mesa
        Pedido pedido = new Pedido(descricao, valor, mesa.getNumero());
        mesa.adicionarPedido(pedido);
        
        // Atualiza total de vendas do garçom
        totalVendas += valor;
        
        System.out.println("Pedido anotado com sucesso por " + getNome());
    }
    
    /**
     * Retorna o total de vendas realizadas por este garçom
     * @return Valor total em vendas
     */
    public float getTotalVendas() {
        return totalVendas;
    }
    
    /**
     * Exibe a comanda de uma mesa específica
     * @param mesa Mesa para visualizar comanda
     * @throws SecurityException Se garçom não estiver autenticado
     */
    public void visualizarComanda(mesa mesa) {
        if (!isAutenticado()) {
            throw new SecurityException("Acesso negado!");
        }
       
    }
    
    /**
     * Retorna informações específicas do garçom
     * @return String com dados do garçom incluindo vendas
     */
    @Override
    public String getInfoFuncionario() {
        return String.format("%s | Total de Vendas: R$ %.2f", 
            super.getInfoFuncionario(), totalVendas);
    }
}