package mercado;

// Classe base para todos os funcionários do restaurante
// Garçom, cozinheiro, gerente, etc.
public class funcionario {
    // Informações básicas de cada funcionário
    private String nome;
    private int codigo;
    private String usuario;
    private String senha;
    private boolean autenticado;
    
    // Construtor - cadastra um novo funcionário
    public funcionario(String nome, int codigo, String usuario, String senha) {
        this.nome = nome;
        this.codigo = codigo;
        this.usuario = usuario;
        this.senha = senha;
        this.autenticado = false;  // Começa deslogado
    }
    
    // GETTERS - métodos para ver as informações
    public String getNome() { 
        return nome; 
    }
    
    public int getCodigo() { 
        return codigo; 
    }
    
    public boolean isAutenticado() { 
        return autenticado; 
    }
    
    // SETTERS - métodos para mudar as informações
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }
    
    // Sistema de login do funcionário
    public boolean autenticar(String usuario, String senha) {
        // Verifica se usuário e senha estão certos
        this.autenticado = this.usuario.equals(usuario) && this.senha.equals(senha);
        return this.autenticado;
    }
    
    // Desloga o funcionário
    public void logout() {
        this.autenticado = false;
    }
    
    // Mostra qual o cargo do funcionário
    public String getCargo() {
        return "Funcionário";
    }
    
    // Mostra todas as informações do funcionário
    public String getInfoFuncionario() {
        return "Código: " + codigo + " | Nome: " + nome + " | Cargo: " + getCargo() + 
               " | Status: " + (autenticado ? "LOGADO" : "DESLOGADO");
    }
}