package co.edu.poli.greenhand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import co.edu.poli.greenhand.model.Mail;
import co.edu.poli.greenhand.model.Material;
import co.edu.poli.greenhand.model.Producto;
import co.edu.poli.greenhand.repository.MaterialRepository;
import co.edu.poli.greenhand.repository.ProductoRepository;
//import co.edu.poli.greenhand.services.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = {"Class: ProductoController"})
@RestController
@RequestMapping("api/v1/")
public class ProductoController {

	@Autowired
	private ProductoRepository p_repository;
	@Autowired
	private MaterialRepository m_repository;
	//@Autowired
	//private MailService notificationService;

	@GetMapping("/product")
	@ApiOperation(value="*** Service Method Get All products***", notes = "***Get All Products to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error Get All Productos!! no path found***")})
	public List<Producto> selectProductos() {
		return p_repository.findAll();
	}
	
	@GetMapping("/product/{id_}")
	@ApiOperation(value="*** Service Method Get a product by id***", notes = "***Get Product by id to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error Get Product by id!! no path found***")})
	public Producto getProductoById(@PathVariable Integer id_) {
		Producto producto = p_repository.findById(id_).get();
		return producto;
	}
	
	@PostMapping("/product")//SOLO ADMIN
	@ApiOperation(value="*** Service Method Post a product***", notes = "***Post a product to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error post a product!! no path found***")})
	public Producto insertProducto(@RequestBody Producto producto) {
		
		/*Mail mail = new Mail();
		
		mail.setMailTo("fmoreno@poligran.edu.co");
		mail.setMailSubject("Nuevos productos disponibles!");
		mail.setMailContent("Ahora puedes ver nuevos productos para tu plan de reciclaje en greenhand!");
		
		notificationService.sendEmail(mail);*/
		return p_repository.save(producto);
	}

	/*@PostMapping("/store_collection")
	@ApiOperation(value="*** Service Method Post a store***", notes = "***Post several Store to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error post several store!! no path found***")})
	public List<Producto> insertProductos(@RequestBody List<Producto> productos_post) {
		p_repository.saveAll(productos_post);
		return productos_post;
	}*/

	

	@PutMapping("/product/{id_}")//SOLO ADMIN
	@ApiOperation(value="*** Service Method Put a product by Id***", notes = "***Put a product by Id to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error put a store by Id!! no path found***")})
	public Producto updateProducto(@PathVariable Integer id_, @RequestBody Producto producto) {
		Producto c_update = p_repository.getById(id_);

		c_update.setId(producto.getId());
		c_update.setNombre(producto.getNombre());
		c_update.setMateriales(producto.getMateriales());
		
		p_repository.save(c_update);

		return producto;
	}

	@DeleteMapping("/product/{id_}")//SOLO ADMIN	
	@ApiOperation(value="*** Service Method Delete a product***", notes = "***Delete a Product to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error delete a product!! no path found***")})
	public Producto deleteProducto(@PathVariable Integer id_) {
		Producto productodb = p_repository.findById(id_).get();
		productodb.setMateriales(null);
		p_repository.delete(productodb);
		return productodb;
	}
	
	@PutMapping("/product/{id_}/{id}")//SOLO ADMIN
	public Producto associate (@PathVariable Integer id_, @PathVariable String id) {
		Producto producto = p_repository.findById(id_).get();
		Material material = m_repository.findById(id).get();
		
		producto.getMateriales().add(material);
		material.getProductos().add(producto);
		
		p_repository.save(producto);
		m_repository.save(material);
		
		return producto;
	}
	
}
