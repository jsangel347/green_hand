package co.edu.poli.greenhand.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;	
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "materiales")
public class Material {

	@Id
	@Column(name = "id", unique = true)
	public String id;

	@Column(name = "categoria")
	public String categoria;

	@Column(name = "nombre")
	public String nombre;

	@Column(name = "reciclable")
	public Boolean reciclable;

	@ManyToMany(mappedBy = "materiales")
	@JsonIgnore
	public Set<Producto> productos;

	public Material() {
	}

	public Material(String id, String categoria, String nombre, Boolean reciclable, Set<Producto> productos) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.reciclable = reciclable;
		this.productos = productos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getReciclable() {
		return reciclable;
	}

	public void setReciclable(Boolean reciclable) {
		this.reciclable = reciclable;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	

}