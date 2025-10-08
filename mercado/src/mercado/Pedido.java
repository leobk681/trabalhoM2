package mercado;

public class Pedido {

	public static int contadorId = 1;
	
	private int id;
	private String nome;
	private float valor;
	private int mesaNUM;
	
	public Pedido(String nome, float valor, int mesa) {
		this.nome=nome;
		this.valor = valor;
		this.mesaNUM= mesa;
	}
	public int getId() { return id; }
	public String  getNome () {return nome;}
	public int getMesa() {return mesaNUM;}
	public float getValor() {return valor;}
	
}