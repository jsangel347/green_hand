package co.edu.poli.greenhand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greenhand.model.Producto;
import co.edu.poli.greenhand.repository.ProductoRepository;

@RestController
@RequestMapping("api/producto/")
public class ProductoController {

	@Autowired
	private ProductoRepository p_repository;
	
	public ProductoController() {

	}

	@PostMapping("/store")
	public Producto insertProducto(@RequestBody Producto producto) {
		p_repository.save(producto);
		return producto;
	}

	@PostMapping("/store_collection")
	public List<Producto> insertProductos(@RequestBody List<Producto> productos_post) {
		p_repository.saveAll(productos_post);
		return productos_post;
	}

	@GetMapping("/get")
	public List<Producto> selectProductos() {
		return p_repository.findAll();
	}

	@PutMapping("/update/{id}")
	public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
		Producto c_update = p_repository.getById(id);

		c_update.setNombre(producto.getNombre());
		c_update.setMateriales(producto.getMateriales());

		p_repository.save(c_update);

		return producto;
	}

	@DeleteMapping("/delete")
	public Object deleteProducto(@RequestParam("id") Integer id) {
		p_repository.deleteById(id);
		return "El producto se ha eliminado correctamente";
	}
}
