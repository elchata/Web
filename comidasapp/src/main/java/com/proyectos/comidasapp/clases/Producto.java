package com.proyectos.comidasapp.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto") 
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idProducto;
    private String nombre;
    private Double precio;
    private Double stock;

	private Categoria categoria;
    private Unidad unidad;
    
    @ManyToOne
	@JoinColumn(name = "idUnidad")
    public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	@ManyToOne
	@JoinColumn(name = "idCategoria")
    public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

    @Id
    @Column(name = "idProducto")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdProducto()
    {
        return idProducto;
    }

    public void setIdProducto(Long id)
    {
        this.idProducto = id;
    } 

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String description) {
        this.nombre = description;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public void setPrecio(Double price) {
        this.precio = price;
    }

    public Double getStock() {
		return stock;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Nombre: " + nombre + ";");
        buffer.append("Precio: " + precio);
        return buffer.toString();
    }
}