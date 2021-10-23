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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Class: ProductoController"})
@RestController
@RequestMapping("api/producto/")
public class ProductoController {

	@Autowired
	private ProductoRepository p_repository;
	
	public ProductoController() {

	}

	@PostMapping("/store")
	@ApiOperation(value="*** Service Method Post a product***", notes = "***Post a product to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error post a product!! no path found***")})
	public Producto insertProducto(@RequestBody Producto producto) {
		p_repository.save(producto);
		return producto;
	}

	@PostMapping("/store_collection")
	@ApiOperation(value="*** Service Method Post a store***", notes = "***Post several Store to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error post several store!! no path found***")})
	public List<Producto> insertProductos(@RequestBody List<Producto> productos_post) {
		p_repository.saveAll(productos_post);
		return productos_post;
	}

	@GetMapping("/get")
	@ApiOperation(value="*** Service Method Get All products***", notes = "***Get All Products to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error Get All Productos!! no path found***")})
	public List<Producto> selectProductos() {
		return p_repository.findAll();
	}

	@PutMapping("/update/{id}")
	@ApiOperation(value="*** Service Method Put a product by Id***", notes = "***Put a product by Id to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error put a store by Id!! no path found***")})
	public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
		Producto c_update = p_repository.getById(id);

		c_update.setNombre(producto.getNombre());
		c_update.setMateriales(producto.getMateriales());

		p_repository.save(c_update);

		return producto;
	}

	@DeleteMapping("/delete/{id}")		
	@ApiOperation(value="*** Service Method Delete a product***", notes = "***Delete a Product to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error delete a product!! no path found***")})
	public Object deleteProducto(@RequestParam("id") Integer id) {
		p_repository.deleteById(id);
		return "El producto se ha eliminado correctamente";
	}
}
