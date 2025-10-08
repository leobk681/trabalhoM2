package mercado;

import java.util.List;
import java.util.ArrayList;


public class mesa {
private int mesaNUM;
private float debito;
private List <Pedido> comanda;
private boolean ocupada ;

//contrutor
public mesa(int mesaN) {
	this.mesaNUM = mesaN;
	this.debito = 0f;
	this.comanda = new ArrayList<>();
	this.ocupada = false;
	
	
}
public int getNumero() { return mesaNUM; }
public float getDebito() { return debito; }
public boolean isOcupada() { return ocupada; }
/**
 * return Cópia da comanda para evitar modificações externas
 */
public List<Pedido> getComanda() { 
    return new ArrayList<>(comanda); 
}
public void setNumero(int numero) { this.mesaNUM = numero; }
public void setOcupada(boolean ocupada) { this.ocupada = ocupada; }

public void adicionarPedido(Pedido pedido) {
    // Se é o primeiro pedido, marca mesa como ocupada
    if (!ocupada) {
        ocupada = true;
    }
    this.comanda.add(pedido);              // Adiciona à comanda
    this.debito += pedido.getValor();      // Atualiza débito total
    System.out.println("Pedido adicionado: " );
}

public boolean pagarDebito(float valorPago) {
    // Verifica se valor pago cobre o débito e se há débito para pagar
    if (valorPago >= debito && debito > 0) {
        float troco = valorPago - debito;  // Calcula troco
        debito = 0;                       // Zera débito
        comanda.clear();                  // Limpa comanda
        ocupada = false;                  // Libera mesa
        
        // Informa sobre troco se necessário
        if (troco > 0) {
            System.out.println("Pagamento realizado! Troco: R$ " + troco);
        } else {
            System.out.println("Pagamento realizado com valor exato!");
        }
        return true;  // Pagamento bem sucedido
    }
    return false;  // Valor insuficiente ou sem débito
}







 
}
