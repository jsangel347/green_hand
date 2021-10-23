package co.edu.poli.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    public Producto() {
    }

    @Id
	@Column(name = "id", unique = true)
    public int id;
    
	@Column(name = "nombre")
    public String nombre;
    
    @ManyToMany
    @JoinTable(name = "material_producto", 
               joinColumns = { @JoinColumn( name="fk_producto") },
               inverseJoinColumns = { @JoinColumn(name = "fk_material") }) 
    public List<Material> materiales;
    
    @ManyToMany(mappedBy = "productos", 
            fetch = FetchType.LAZY)
    public List<Compra> compras;

}