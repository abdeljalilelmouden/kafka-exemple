package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FormationEntity;
import com.example.demo.service.impl.FormationService;

@RequestMapping(path = "/formation/api")
@RestController
public class FormationController {

	public static final Logger logger = LoggerFactory.getLogger(FormationController.class);

	@Autowired
	private FormationService formationService;

	/**
	 * find all formations
	 *
	 * @return List<FormationEntity>
	 */
	@GetMapping(value = "v0")
	public List<FormationEntity> getAllFormations() {

		logger.info("gat all formation from database - Formation Controller ");

		return formationService.getAllFormation();
	}

	/**
	 * create formation in database
	 *
	 * @param formationEntity
	 * @return FormationEntity
	 */
	@PostMapping(value = "v0")
	public FormationEntity createFormation(@RequestBody FormationEntity formationEntity) {

		logger.info("create formation in database - Formation Controller ");
		return formationService.createFormation(formationEntity);
	}

	@PutMapping(value = "v0")
	public FormationEntity updateFormation(@RequestBody FormationEntity formationEntity) {

		logger.info("update formation in database - Formation Controller ");

		return formationService.updateFormation(formationEntity);
	}

	@DeleteMapping(value = "v0/{idFormation}")
	public void deleteFormation(@PathVariable(name = "idFormation") Long id) {

		logger.info("delete formation from database - Formation Controller ");

		formationService.deleteFormation(id);
	}

	@GetMapping(value = "v1/{idFormation}")
	public FormationEntity getById(@PathVariable(name = "idFormation") Long id) {

		logger.info("gat by id formation from database - Formation Controller ");
		return formationService.getById(id);
	}

	@GetMapping(value = "v0/{titreFormation}")
	public FormationEntity getFormationByTitre(@PathVariable(name = "titreFormation") String titre) {

		logger.info("gat by titre formation from database - Formation Controller ");

		return formationService.getFormationByTitre(titre);
	}

}