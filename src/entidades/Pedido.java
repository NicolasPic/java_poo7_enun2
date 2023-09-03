package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enun.StatusDoPedido;

public class Pedido {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private StatusDoPedido status;
	
	private Cliente cliente;
	private List<ItemPedido> Items = new ArrayList<>();
	
	public Double total() {
		double som=0;
		for(ItemPedido e : Items) {
			som+=e.subTotal();
		}
		return som;
	}
	
	public void addItem(ItemPedido item) {
		Items.add(item);
	}
	
	public void remItem(ItemPedido item) {
		Items.remove(item);
	}
	@Override
	public String toString() {
				StringBuilder sb = new StringBuilder();
				sb.append("Momento do pedido: " + sdf.format(momento)); 
				sb.append("\nStatus do pedido: " + status);
				sb.append("\nCliente: " + cliente); 
				sb.append("\nItems pedidos:");
				for (ItemPedido e:Items) {
					sb.append("\n"+e);
				}
				sb.append("\nPreço total:\n");
				sb.append(String.format("%.2f", total()));
				
				return sb.toString();
	}
	
	public Pedido(Date momento, StatusDoPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}
	
	public void setMomento(Date momento) {
		this.momento = momento;
	}
	
	public StatusDoPedido getStatus() {
		return status;
	}
	
	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemPedido> getItems() {
		return Items;
	}
	
	

}
