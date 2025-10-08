package mercado;
import java.util.ArrayList;
import java.util.List;



public class caixa {
	private contaBancaria contaRestaurante;
	private boolean caixaAberto;
	
	
	//contrutor
	public caixa(contaBancaria conta) {
		this.contaRestaurante=conta;
		this.caixaAberto =false;
	}
	
	 public void abrirCaixa(float fundoInicial) {
	        if (!caixaAberto) {
	            // Deposita fundo inicial na conta
	            contaRestaurante.depositar(fundoInicial);
	            caixaAberto = true;  // Marca caixa como aberto

	            System.out.println("Caixa aberto com sucesso!");
	        } else {
	            System.out.println("Caixa já está aberto!");
	        }
	    }
	
	 public void fecharCaixa() {
	        if (caixaAberto) {
	            caixaAberto = false;  // Marca caixa como fechado
	            
	        
	        }
	    }
	
	 public boolean processarPagamento(mesa mesa, float valorRecebido, String formaPagamento) {
	        // Verifica se caixa está aberto
	        if (!caixaAberto) {
	            System.out.println("Erro: Caixa fechado!");
	            return false;
	        }
	        
	        // Valida parâmetros
	        if (mesa == null || valorRecebido <= 0) {
	            System.out.println("Dados inválidos para pagamento");
	            return false;
	        }
	        
	        // Tenta processar pagamento na mesa
	        if (mesa.pagarDebito(valorRecebido)) {
	            // Se sucesso, deposita valor na conta
	            contaRestaurante.depositar(valorRecebido);
	            
	            // Registra transação no histórico
	            String transacao = String.format("Mesa %d | %s | R$ %.2f", 
	                mesa.getNumero(), formaPagamento, valorRecebido);
	         
	            
	            System.out.println("Pagamento processado com sucesso!");
	            return true;
	        } else {
	            System.out.println("Falha no pagamento. Valor insuficiente.");
	            return false;
	        }
	    }
	    
	  
	    
	    /**
	     * Verifica se o caixa está aberto
	     * @return true se caixa está aberto
	     */
	    public boolean isCaixaAberto() {
	        return caixaAberto;
	    }
	 
	 
}
