package mercado;

// Classe que representa a conta bancária do restaurante
// Aqui fica todo o dinheiro do negócio
public class contaBancaria {
    private float saldo;
    
    // Construtor - inicia a conta com saldo zero
    public contaBancaria() {
        this.saldo = 0;
    }
    
    // GETTER - mostra quanto dinheiro tem na conta
    public float getSaldo() {
        return saldo;
    }
    
    // Coloca dinheiro na conta - só aceita valores positivos
    public void depositar(float deposito) {
        if (deposito > 0) {
            this.saldo += deposito;
            System.out.println("✓ Depositado R$ " + deposito + " | Saldo atual: R$ " + saldo);
        } else {
            System.out.println("✗ Valor de depósito tem que ser positivo!");
        }
    }
    
    // Método simples pra ajustar o saldo se precisar
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}