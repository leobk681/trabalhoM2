package mercado;

import java.util.ArrayList;
import java.util.List;

// Classe principal do restaurante - aqui tudo começa
public class restaurante {
    private String nome;
    private int QtdMesas;
    List<Opcoes> pratos = new ArrayList<>();
    
    // Construtor - cria o restaurante
    public restaurante(String nome, int qtdMesas) {
        this.nome = nome;
        this.QtdMesas = qtdMesas;
        this.pratos = new ArrayList<>();
        // Adiciona alguns pratos padrão
        pratos.add(new Opcoes("Pão com Manteiga", 5.0f));
        pratos.add(new Opcoes("Feijoada Completa", 35.0f));
    }
    
    // Método principal - onde o programa começa
    public static void main(String[] args) {
        System.out.println("🏪 INICIANDO SISTEMA DO RESTAURANTE\n");
        
        // Cria a conta bancária do restaurante
        contaBancaria contaDoRestaurante = new contaBancaria();
        
        // Cria o caixa do restaurante
        caixa caixaDoRestaurante = new caixa(contaDoRestaurante);
        
        // Abre o caixa com fundo inicial para troco
        caixaDoRestaurante.abrirCaixa(100.0f);
        
        // Cria o garçom
        Garcom garcomJoao = new Garcom("João Silva", 101, "joao", "1234", caixaDoRestaurante);
        
        // Inicia o trabalho do garçom
        garcomJoao.iniciarTrabalho();
        
        // Quando o garçom termina, fecha o caixa
        caixaDoRestaurante.fecharCaixa();
        
        System.out.println("👋 Sistema encerrado. Volte sempre!");
    }
}