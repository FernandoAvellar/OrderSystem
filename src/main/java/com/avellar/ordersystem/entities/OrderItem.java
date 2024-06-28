package com.avellar.ordersystem.entities;

import java.io.Serializable;
import java.util.Objects;

import com.avellar.ordersystem.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/* O par Produto e Pedido que vai identificar um Item da ordem
Note que o item da ordem precisa possuir uma chave primária
que redireciona pra classe auxiliar, pois, essa entidade
depende da existência de duas outras entidades. 
Nesse caso dependeremos de uma classe auxiliat (OrderItemPK)
pra fazer esse relacionamento entre as classes Product e Order
Note que o construtor não recebe esse id e nem temos getters
and setter pra esse atributo. Note também que o contrutor
precisou receber uma Order e um Product além de criarmos
pra ambos os getters and setters manualmente. Note também
o mértidi getOrder que precisou receber um @JsonIgnore
pra evitar referências cíclicas*/

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK(); // classes com Ids compostos precisam ser instanciadas pra não ficar
												// como Null e quebrar já no construtor

	private Integer quantity;
	private Double price;

	protected OrderItem() {
	}

	public OrderItem(Order order, Product product, Integer quantity) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = product.getPrice();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Double getSubTotal() {
		return getPrice() * getQuantity();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

}
