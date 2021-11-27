package co.edu.poli.greenhand.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@Column(name = "id", unique = true)
	public Integer id;

	@Column(name = "nombre")
	public String nombre;

	@ManyToMany
	@JoinTable(name = "material_producto", 
			   joinColumns = { @JoinColumn(name = "fk_producto") }, 
			   inverseJoinColumns = { @JoinColumn(name = "fk_material") })
	private Set<Material> materiales;


	public Producto() {
	}

	public Producto(Integer id, String nombre, Set<Material> materiales) {
		this.id = id;
		this.nombre = nombre;
		this.materiales = materiales;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(Set<Material> materiales) {
		this.materiales = materiales;
	}

}