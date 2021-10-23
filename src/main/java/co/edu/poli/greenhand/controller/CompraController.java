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

import co.edu.poli.greenhand.model.Compra;
import co.edu.poli.greenhand.repository.CompraRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Class: CompraController"})
@RestController
@RequestMapping("api/compra/")
public class CompraController {

	@Autowired
	private CompraRepository c_repository;
	
	public CompraController() {

	}

	@PostMapping("/store")
	@ApiOperation(value="*** Service Method Post a store***", notes = "***Post a Store to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error post a store!! no path found***")})
	public Compra insertCompra(@RequestBody Compra compra) {
		c_repository.save(compra);
		return compra;
	}

	@PostMapping("/store_collection")
	@ApiOperation(value="*** Service Method Post a store***", notes = "***Post several Store to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error post several store!! no path found***")})
	public List<Compra> insertCompras(@RequestBody List<Compra> compras_post) {
		c_repository.saveAll(compras_post);
		return compras_post;
	}

	@GetMapping("/get")
	@ApiOperation(value="*** Service Method Get All store***", notes = "***Get All Store to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error Get All store!! no path found***")})
	public List<Compra> selectCompras() {
		return c_repository.findAll();
	}

	@PutMapping("/update/{id}")
	@ApiOperation(value="*** Service Method Put a store by Id***", notes = "***Put a Store by Id to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error put a store by Id!! no path found***")})
	public Compra updateCompra(@PathVariable Integer id, @RequestBody Compra compra) {
		Compra c_update = c_repository.getById(id);

		c_update.setFecha(compra.getFecha());
		c_update.setProductos(compra.getProductos());

		c_repository.save(c_update);

		return compra;
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value="*** Service Method Delete a store***", notes = "***Delete a Store to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error delete a store!! no path found***")})
	public Object deleteCompra(@RequestParam("id") Integer id) {
		c_repository.deleteById(id);
		return "La compra se ha eliminado correctamente";
	}
}
