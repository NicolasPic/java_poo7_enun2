package java_b_poo7_enum2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enun.StatusDoPedido;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do cliente:");
		System.out.println("Nome:");
		String nome = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		System.out.println("Data de nascimento:");
		Date nascimento = sdf.parse(sc.nextLine());
		Cliente cliente = new Cliente(nome,email,nascimento);
		
		System.out.println("Entre os dados do pedido:");
		System.out.println("Status:");
		String status = sc.nextLine();
		StatusDoPedido statusDoPedido = StatusDoPedido.valueOf(status);
		System.out.println("Quantos items para o pedido:");
		int n = sc.nextInt();
		
		Pedido pedido = new Pedido(new Date(),statusDoPedido,cliente);
		
		Produto produto;
		ItemPedido itemPedido;
		for(int i = 0;i<n;i++) {
			sc.nextLine();
			System.out.println("Entre #"+(i+1)+ " item:");
			System.out.println("Nome do produto:");
			String nomeP = sc.nextLine();
			System.out.println("Preço do produto:");
			double preco = sc.nextDouble();
			System.out.println("Quantidade do produto:");
			int quantidade = sc.nextInt();
			produto = new Produto(nomeP,preco);
			itemPedido = new ItemPedido(quantidade,preco,produto);
			pedido.addItem(itemPedido);
		}
		
		System.out.println("Resumo do pedido:");
		System.out.println(pedido);
		
		
		sc.close();

	}

}
