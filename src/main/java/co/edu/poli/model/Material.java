package co.edu.poli.model;

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
    public int id;

    @Column(name = "categoria")
    public String categoria;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "reciclable")
    public Boolean reciclable;
    
    @ManyToMany(mappedBy = "materiales", 
            fetch = FetchType.LAZY)
    public Set<Producto> productos;

    public Material() {
    }
}