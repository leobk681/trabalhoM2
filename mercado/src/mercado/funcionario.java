package mercado;

/**
 * Classe que representa um funcionário do restaurante
 * Serve como base para Garcom, Cozinheiro, Gerente, etc.
 * CORREÇÃO: Removida a abstract pois estamos instanciando Garcom diretamente
 */
public class funcionario {
    // Atributos comuns a todos os funcionários
    private String nome;
    private int codigo;
    private String usuario;
    private String senha;
    private boolean autenticado;
    
    /**
     * Construtor - Inicializa dados básicos do funcionário
     * @param nome Nome completo
     * @param codigo Código identificador
     * @param usuario Usuário para login
     * @param senha Senha para login (em sistema real usar hash)
     */
    public funcionario(String nome, int codigo, String usuario, String senha) {
        this.nome = nome;
        this.codigo = codigo;
        this.usuario = usuario;
        this.senha = senha; // EM SISTEMA REAL: usar hash com salt!
        this.autenticado = false;  // Inicia não autenticado
    }
    
    // ==================== MÉTODOS DE ACESSO (GETTERS) ====================
    
    public String getNome() { return nome; }
    public int getCodigo() { return codigo; }
    public boolean isAutenticado() { return autenticado; }
    
    // ==================== MÉTODOS DE MODIFICAÇÃO (SETTERS) ====================
    
    public void setNome(String nome) { this.nome = nome; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    // ==================== SISTEMA DE AUTENTICAÇÃO ====================
    
    /**
     * Autentica o funcionário no sistema
     * @param usuario Usuário fornecido
     * @param senha Senha fornecida
     * @return true se autenticação bem sucedida
     */
    public boolean autenticar(String usuario, String senha) {
        // Verifica credenciais (em sistema real: comparar hashes)
        this.autenticado = this.usuario.equals(usuario) && this.senha.equals(senha);
        return this.autenticado;
    }
    
    /**
     * Desconecta o funcionário do sistema
     */
    public void logout() {
        this.autenticado = false;
    }
    
    // ==================== MÉTODO PARA IDENTIFICAÇÃO ====================
    
    /**
     * Retorna o cargo/função do funcionário
     * @return String com o cargo
     * CORREÇÃO: Método concreto em vez de abstract
     */
    public String getCargo() {
        return "Funcionário";  // Retorno padrão, pode ser sobrescrito
    }
    
    /**
     * Retorna informações completas do funcionário
     * @return String formatada com dados do funcionário
     */
    public String getInfoFuncionario() {
        return String.format("Código: %d | Nome: %s | Cargo: %s | Status: %s",
            codigo, nome, getCargo(), autenticado ? "LOGADO" : "DESLOGADO");
    }
}