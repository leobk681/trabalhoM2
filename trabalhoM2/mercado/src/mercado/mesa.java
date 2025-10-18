package mercado;

import java.util.ArrayList;
import java.util.List;

// Classe que representa cada mesa do restaurante
// Controla os pedidos, o débito e se está ocupada ou não
public class mesa {
    private int mesaNUM;
    private float debito;
    private List<Pedido> comanda;
    private boolean ocupada;
    
    // Construtor - prepara uma nova mesa
    public mesa(int mesaN) {
        this.mesaNUM = mesaN;
        this.debito = 0f;
        this.comanda = new ArrayList<>();
        this.ocupada = false;
    }
    
    // GETTERS - métodos para ver as informações da mesa
    public int getNumero() { 
        return mesaNUM; 
    }
    
    public float getDebito() { 
        return debito; 
    }
    
    public boolean isOcupada() { 
        return ocupada; 
    }
    
    // Pega uma cópia da comanda pra ninguém mexer na original
    public List<Pedido> getComanda() { 
        return new ArrayList<>(comanda); 
    }
    
    // SETTERS - métodos para mudar as informações
    public void setNumero(int numero) { 
        this.mesaNUM = numero; 
    }
    
    public void setOcupada(boolean ocupada) { 
        this.ocupada = ocupada; 
    }

    // Adiciona um novo pedido na mesa
    public void adicionarPedido(Pedido pedido) {
        // Se é o primeiro pedido, marca a mesa como ocupada
        if (!ocupada) {
            ocupada = true;
        }
        this.comanda.add(pedido);              // Coloca na comanda
        this.debito += pedido.getValor();      // Soma no débito total
        System.out.println("✓ Pedido adicionado: " + pedido.toString());
    }

    // Processa o pagamento da mesa
    public boolean pagarDebito(float valorPago) {
        // Verifica se o cliente pagou pelo menos o que deve
        if (valorPago >= debito && debito > 0) {
            float troco = valorPago - debito;  // Calcula o troco
            debito = 0;                       // Zera a dívida
            comanda.clear();                  // Limpa a comanda
            ocupada = false;                  // Libera a mesa
            
            // Avisa sobre o troco se tiver
            if (troco > 0) {
                System.out.println("✓ Pagamento feito! Troco: R$ " + troco);
            } else {
                System.out.println("✓ Pagamento feito com valor certo!");
            }
            return true;  // Deu tudo certo
        }
        return false;  // O cliente não pagou o suficiente
    }
}