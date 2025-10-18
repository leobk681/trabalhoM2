package mercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe do garçom que atende as mesas
// Pode fazer pedidos e fechar contas
public class Garcom extends funcionario {
    private List<mesa> mesas;
    private List<Opcoes> cardapio;
    private Scanner scanner;
    private caixa caixaRestaurante;
    
    // Construtor - cria um novo garçom
    public Garcom(String nome, int codigo, String usuario, String senha, caixa caixa) {
        super(nome, codigo, usuario, senha);
        this.mesas = new ArrayList<>();
        this.cardapio = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.caixaRestaurante = caixa;
        inicializarCardapio();
        inicializarMesas();
    }
    
    // Prepara o cardápio com os itens disponíveis
    private void inicializarCardapio() {
        cardapio.add(new Opcoes("Café", 5.00f));
        cardapio.add(new Opcoes("Suco Natural", 8.00f));
        cardapio.add(new Opcoes("Sanduíche", 15.00f));
        cardapio.add(new Opcoes("Salada", 12.00f));
        cardapio.add(new Opcoes("Prato Executivo", 25.00f));
        cardapio.add(new Opcoes("Sobremesa", 10.00f));
        cardapio.add(new Opcoes("Refrigerante", 6.00f));
        cardapio.add(new Opcoes("Água", 4.00f));
    }
    
    // Cria as mesas do restaurante
    private void inicializarMesas() {
        for (int i = 1; i <= 10; i++) { // 10 mesas no total
            mesas.add(new mesa(i));
        }
    }
    
    // Mostra que é um garçom
    @Override
    public String getCargo() {
        return "Garçom";
    }
    
    // Menu principal do garçom
    public void iniciarTrabalho() {
        System.out.println("👨‍🍳 " + getNome() + " começando o turno!");
        
        // Pede login do garçom
        System.out.print("Digite seu usuário: ");
        String usuario = scanner.next();
        System.out.print("Digite sua senha: ");
        String senha = scanner.next();
        
        if (!autenticar(usuario, senha)) {
            System.out.println("✗ Login falhou! Usuário ou senha errados.");
            return;
        }
        
        System.out.println("✓ Login feito com sucesso! Bem-vindo, " + getNome() + "!");
        
        boolean trabalhando = true;
        while (trabalhando) {
            System.out.println("\n=== SISTEMA DO GARÇOM ===");
            System.out.println("Garçom: " + getNome());
            System.out.println("1 - Atender uma mesa");
            System.out.println("2 - Ver minhas informações");
            System.out.println("3 - Ver saldo do caixa");
            System.out.println("4 - Sair do sistema");
            System.out.print("Escolha uma opção: ");
            
            int escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1:
                    atenderMesa();
                    break;
                case 2:
                    System.out.println(getInfoFuncionario());
                    break;
                case 3:
                    caixaRestaurante.verSaldo();
                    break;
                case 4:
                    trabalhando = false;
                    logout();
                    System.out.println("👋 " + getNome() + " saindo do sistema...");
                    break;
                default:
                    System.out.println("✗ Opção inválida! Tente novamente.");
            }
        }
    }
    
    // Atende uma mesa específica
    public void atenderMesa() {
        // Verifica se o garçom está logado
        if (!isAutenticado()) {
            System.out.println("✗ Você precisa estar logado para atender mesas!");
            return;
        }
        
        System.out.print("\n🎯 Qual mesa você vai atender? (1-10): ");
        int numeroMesa = scanner.nextInt();
        
        mesa mesa = buscarMesa(numeroMesa);
        if (mesa == null) {
            System.out.println("✗ Mesa não encontrada!");
            return;
        }
        
        System.out.println("\n👨‍🍳 " + getNome() + " atendendo a Mesa " + numeroMesa);
        gerenciarMesa(mesa);
    }
    
    // Menu de opções para uma mesa
    private void gerenciarMesa(mesa mesa) {
        boolean atendendo = true;
        
        while (atendendo) {
            System.out.println("\n--- MESA " + mesa.getNumero() + " ---");
            System.out.println("Débito atual: R$ " + mesa.getDebito());
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Ver comanda");
            System.out.println("3 - Fechar conta");
            System.out.println("4 - Voltar ao menu anterior");
            System.out.print("O que fazer? ");
            
            int escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1:
                    fazerPedido(mesa);
                    break;
                case 2:
                    verComanda(mesa);
                    break;
                case 3:
                    fecharConta(mesa);
                    atendendo = false;
                    break;
                case 4:
                    atendendo = false;
                    break;
                default:
                    System.out.println("✗ Opção inválida!");
            }
        }
    }
    
    // Adiciona um pedido na mesa
    private void fazerPedido(mesa mesa) {
        System.out.println("\n📖 CARDÁPIO:");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println((i+1) + ". " + cardapio.get(i));
        }
        
        System.out.print("Escolha o item (1-" + cardapio.size() + "): ");
        int itemIndex = scanner.nextInt() - 1;
        
        if (itemIndex >= 0 && itemIndex < cardapio.size()) {
            System.out.print("Quantas unidades? ");
            int quantidade = scanner.nextInt();
            
            if (quantidade > 0) {
                Opcoes item = cardapio.get(itemIndex);
                Pedido pedido = new Pedido(item, quantidade);
                mesa.adicionarPedido(pedido);
            } else {
                System.out.println("✗ Quantidade tem que ser maior que zero!");
            }
        } else {
            System.out.println("✗ Item não existe!");
        }
    }
    
    // Mostra todos os pedidos da mesa
    private void verComanda(mesa mesa) {
        System.out.println("\n📋 COMANDA DA MESA " + mesa.getNumero());
        List<Pedido> comanda = mesa.getComanda();
        
        if (comanda.isEmpty()) {
            System.out.println("Nenhum pedido ainda.");
        } else {
            for (int i = 0; i < comanda.size(); i++) {
                System.out.println((i+1) + ". " + comanda.get(i));
            }
            System.out.println("💳 TOTAL: R$ " + mesa.getDebito());
        }
    }
    
    // Fecha a conta da mesa
    private void fecharConta(mesa mesa) {
        System.out.println("\n🧾 FECHANDO CONTA DA MESA " + mesa.getNumero());
        verComanda(mesa);
        
        if (mesa.getDebito() > 0) {
            System.out.print("Quanto o cliente pagou? R$ ");
            float valorRecebido = scanner.nextFloat();
            
            // Usa o caixa para processar o pagamento
            if (caixaRestaurante.processarPagamento(mesa, valorRecebido, "Dinheiro")) {
                System.out.println("✓ Conta fechada com sucesso!");
            } else {
                System.out.println("✗ Erro ao fechar a conta!");
            }
        } else {
            System.out.println("Esta mesa não tem nada para pagar.");
        }
    }
    
    // Procura uma mesa pelo número
    private mesa buscarMesa(int numero) {
        for (mesa m : mesas) {
            if (m.getNumero() == numero) {
                return m;
            }
        }
        return null;
    }
}