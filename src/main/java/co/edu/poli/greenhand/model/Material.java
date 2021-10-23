package co.edu.poli.greenhand.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material {

	@Id
	@Column(name = "id", unique = true)
	public Integer id;

	@Column(name = "categoria")
	public String categoria;

	@Column(name = "nombre")
	public String nombre;

	@Column(name = "reciclable")
	public Boolean reciclable;

	@ManyToMany(mappedBy = "materiales", fetch = FetchType.LAZY)
	public Set<Producto> productos;

	public Material() {
	}

	public Material(Integer id, String categoria, String nombre, Boolean reciclable) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.reciclable = reciclable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}