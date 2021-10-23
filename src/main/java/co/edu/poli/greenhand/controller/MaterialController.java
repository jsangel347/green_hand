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

import co.edu.poli.model.Material;
import co.edu.poli.repository.MaterialRepository;

@RestController
@RequestMapping("api/material/")
public class MaterialController {

	@Autowired
	private MaterialRepository m_repository;
	
	public MaterialController() {

	}

	@PostMapping("/store")
	public Material insertMaterial(@RequestBody Material material) {
		m_repository.save(material);
		return material;
	}

	@PostMapping("/store_collection")
	public List<Material> insertMaterials(@RequestBody List<Material> materiales_post) {
		m_repository.saveAll(materiales_post);
		return materiales_post;
	}

	@GetMapping("/get")
	public List<Material> selectMaterials() {
		return m_repository.findAll();
	}

	@PutMapping("/update/{id}")
	public Material updateMaterial(@PathVariable Integer id, @RequestBody Material material) {
		Material m_update = m_repository.getById(id);

		m_update.setCategoria(material.getCategoria());
		m_update.setNombre(material.getNombre());
		m_update.setReciclable(material.getReciclable());

		m_repository.save(m_update);

		return material;
	}

	@DeleteMapping("/delete")
	public Object deleteMaterial(@RequestParam("id") Integer id) {
		m_repository.deleteById(id);
		return "El material se ha eliminado correctamente";
	}
}
