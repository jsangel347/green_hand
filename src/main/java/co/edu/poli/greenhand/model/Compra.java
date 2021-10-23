package co.edu.poli.greenhand.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@Column(name = "id", unique = true)
	public Integer id;

	@Column(name = "fecha")
	public String fecha;

	@ManyToMany
	@JoinTable(name = "producto_compra", joinColumns = { @JoinColumn(name = "fk_compra") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_producto") })
	public Set<Producto> productos;

	public Compra() {
	}

	public Compra(Integer id, String fecha, Set<Producto> productos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.productos = productos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}