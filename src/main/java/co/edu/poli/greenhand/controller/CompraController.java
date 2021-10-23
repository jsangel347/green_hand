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

import co.edu.poli.model.Compra;
import co.edu.poli.repository.CompraRepository;

@RestController
@RequestMapping("api/compra/")
public class CompraController {

	@Autowired
	private CompraRepository c_repository;
	
	public CompraController() {

	}

	@PostMapping("/store")
	public Compra insertCompra(@RequestBody Compra compra) {
		c_repository.save(compra);
		return compra;
	}

	@PostMapping("/store_collection")
	public List<Compra> insertCompras(@RequestBody List<Compra> compras_post) {
		c_repository.saveAll(compras_post);
		return compras_post;
	}

	@GetMapping("/get")
	public List<Compra> selectCompras() {
		return c_repository.findAll();
	}

	@PutMapping("/update/{id}")
	public Compra updateCompra(@PathVariable Integer id, @RequestBody Compra compra) {
		Compra c_update = c_repository.getById(id);

		c_update.setFecha(compra.getFecha());
		c_update.setProductos(compra.getProductos());

		c_repository.save(c_update);

		return compra;
	}

	@DeleteMapping("/delete")
	public Object deleteCompra(@RequestParam("id") Integer id) {
		c_repository.deleteById(id);
		return "La compra se ha eliminado correctamente";
	}
}
