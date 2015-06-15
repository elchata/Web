package com.proyectos.comidasapp.clases;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prodvendido")
public class ProdVendido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idProdVendido; 	
	private Producto producto;
	private Double cantidad;
	private Pedido pedido;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProdVendido", unique = true, nullable = false)
	public Long getIdProdVendido() {
		return idProdVendido;
	}
	
	public void setIdProdVendido(Long idProdVendido) {
		this.idProdVendido = idProdVendido;
	}
	
	@ManyToOne
	@JoinColumn(name = "idProducto")
	public Producto getProducto() {
		return producto;
	}
	
	@ManyToOne
	@JoinColumn(name = "idPedido")
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
}
