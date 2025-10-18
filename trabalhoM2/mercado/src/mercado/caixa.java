package mercado;

import java.util.ArrayList;
import java.util.List;

// Classe que controla o caixa do restaurante
// Aqui é onde o dinheiro das vendas entra
public class caixa {
    private contaBancaria contaRestaurante;
    private boolean caixaAberto;
    private List<String> historico;  // Guarda todas as vendas do dia
    
    // Construtor - liga o caixa com a conta bancária
    public caixa(contaBancaria conta) {
        this.contaRestaurante = conta;
        this.caixaAberto = false;
        this.historico = new ArrayList<>();
    }
    
    // Abre o caixa com um fundo inicial de troco
    public void abrirCaixa(float fundoInicial) {
        if (!caixaAberto) {
            // Coloca o fundo inicial na conta
            contaRestaurante.depositar(fundoInicial);
            caixaAberto = true;  // Marca que o caixa está aberto
            historico.clear();   // Limpa o histórico do dia anterior
            
            System.out.println("✓ Caixa aberto com fundo de R$ " + fundoInicial);
        } else {
            System.out.println("✗ O caixa já está aberto!");
        }
    }
    
    // Fecha o caixa no final do dia
    public void fecharCaixa() {
        if (caixaAberto) {
            caixaAberto = false;  // Marca que o caixa fechou
            
            // Mostra o relatório do dia
            System.out.println("\n=== FECHAMENTO DO CAIXA ===");
            System.out.println("Saldo final: R$ " + contaRestaurante.getSaldo());
            System.out.println("Total de vendas: " + historico.size());
            System.out.println("============================\n");
        }
    }
    
    // Processa o pagamento de uma mesa
    public boolean processarPagamento(mesa mesa, float valorRecebido, String formaPagamento) {
        // Verifica se o caixa está aberto
        if (!caixaAberto) {
            System.out.println("✗ Erro: Caixa fechado! Abra o caixa primeiro.");
            return false;
        }
        
        // Verifica se os dados estão certos
        if (mesa == null || valorRecebido <= 0) {
            System.out.println("✗ Dados inválidos para pagamento");
            return false;
        }
        
        // Tenta receber o pagamento na mesa
        if (mesa.pagarDebito(valorRecebido)) {
            // Se deu certo, deposita o valor na conta
            contaRestaurante.depositar(valorRecebido);
            
            // Guarda essa venda no histórico
            String transacao = "Mesa " + mesa.getNumero() + " | " + 
                             formaPagamento + " | R$ " + valorRecebido;
            historico.add(transacao);
            
            System.out.println("✓ Pagamento processado com sucesso!");
            return true;
        } else {
            System.out.println("✗ Falha no pagamento. Valor insuficiente.");
            return false;
        }
    }
    
    // GETTER - verifica se o caixa está aberto
    public boolean isCaixaAberto() {
        return caixaAberto;
    }
    
    // Mostra o saldo atual do caixa
    public void verSaldo() {
        System.out.println("💵 Saldo do caixa: R$ " + contaRestaurante.getSaldo());
    }
    
    // Mostra todo o histórico de vendas do dia
    public void verHistorico() {
        System.out.println("\n=== HISTÓRICO DE VENDAS ===");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma venda hoje.");
        } else {
            for (int i = 0; i < historico.size(); i++) {
                System.out.println((i+1) + ". " + historico.get(i));
            }
        }
        System.out.println("===========================\n");
    }
}