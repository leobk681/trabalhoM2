package mercado;

public class contaBancaria {
	private float saldo;

	public float getSaldo() {
		return saldo;
	}

	public  void setSaldo(float saldo) {
		this.saldo += saldo;
	}
	public contaBancaria() {
		this.saldo=0;
	}

	public void depositar(float deposito) {
		if (deposito > 0) {
			this.saldo += deposito;
		}else {
			 throw new IllegalArgumentException("Valor de depósito deve ser positivo");
			
		}
		
	}
	
	
}
