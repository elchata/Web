package com.proyectos.comidasapp.clases;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPedido;
	private Double precioFinal;
	private Date fecha;
	private List<ProdVendido> productos = new ArrayList<ProdVendido>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPedido", unique = true, nullable = false)
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFin) {
		precioFinal = precioFin;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ProdVendido> getProductos() {
		return productos;
	}
	
	public void setProductos(List<ProdVendido> productos) {
		this.productos = productos;
	}
	
	

	

}
