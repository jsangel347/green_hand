package co.edu.poli.greenhand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.greenhand.model.Material;
import co.edu.poli.greenhand.repository.MaterialRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = {"Class: MaterialController"})
@RestController
@RequestMapping("api/v1/")
public class MaterialController {

	@Autowired
	private MaterialRepository m_repository;
	
	public MaterialController() {

	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/material")//SOLO ADMIN
	@ApiOperation(value="*** Service Method Post a material***", notes = "***Post a material to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error post a material!! no path found***")})
	public Material insertMaterial(@RequestBody Material material) {
		m_repository.save(material);
		return material;
	}

	/*@PostMapping("/material")
	@ApiOperation(value="*** Service Method Post all material***", notes = "***Post all material to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error post a material collection!! no path found***")})
	public List<Material> insertMaterials(@RequestBody List<Material> materiales_post) {
		m_repository.saveAll(materiales_post);
		return materiales_post;
	}*/

	@GetMapping("/material")
	@ApiOperation(value="*** Service Method Get All materials***", notes = "***Get All Materials to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error get all materials!! no path found***")})
	public List<Material> selectMaterials() {
		return m_repository.findAll();
	}

	@PutMapping("/material/{id}")//SOLO ADMIN
	@ApiOperation(value="*** Service Method Put materials***", notes = "***Put Materials to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error put material!! no path found***")})
	public Material updateMaterial(@PathVariable String id, @RequestBody Material material) {
		Material m_update = m_repository.findById(id).get();

		m_update.setCategoria(material.getCategoria());
		m_update.setNombre(material.getNombre());
		m_update.setReciclable(material.getReciclable());

		m_repository.save(m_update);

		return m_update;
	}

	@DeleteMapping("/material/{id}")//SOLO ADMIN
	@ApiOperation(value="*** Service Method Delete material***", notes = "***Delete Material to MySQL///WebApp***")
	@ApiResponses(value= {@ApiResponse(code=404, message="***Error delete material!! no path found***")})
	public Material deleteMaterial(@PathVariable String id) {
		Material _material = m_repository.findById(id).get();
		m_repository.deleteById(id);
		return _material;
	}
}
