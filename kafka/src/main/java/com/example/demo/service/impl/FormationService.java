package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FormationEntity;
import com.example.demo.repository.IFormationRepository;
import com.example.demo.service.IFormationService;

@Service
public class FormationService implements IFormationService {

    public static final Logger LOGGER = LoggerFactory.getLogger(FormationService.class);
    @Autowired
    private IFormationRepository formationRepository;

    /**
     * @return List<FormationEntity>
     */
    @Override
    public List<FormationEntity> getAllFormation() {
        LOGGER.info("get all formation - Service Formation");
        return formationRepository.findAll();
    }

    /**
     * @param formationEntity
     * @return
     */
    @Override
    public FormationEntity createFormation(FormationEntity formationEntity) {
        LOGGER.info("create formation - Service Formation");
        return formationRepository.save(formationEntity);
    }

    /**
     * @param formationEntity
     * @return
     */
    @Override
    public FormationEntity updateFormation(FormationEntity formationEntity) {
        LOGGER.info("update formation - Service Formation");
        return formationRepository.save(formationEntity);
    }

    /**
     * @param idFormation
     */
    @Override
    public void deleteFormation(Long idFormation) {
        LOGGER.info("delete formation - Service Formation");
        formationRepository.deleteById(idFormation);
    }

    /**
     * @param idFormation
     * @return
     */
    @Override
    public FormationEntity getById(Long idFormation) {
        LOGGER.info("get formation by id formation - Service Formation");
        return formationRepository.findById(idFormation).get();
    }

    /**
     * @param titre
     * @return
     */
    @Override
    public FormationEntity getFormationByTitre(String titre) {
        LOGGER.info("get formation by titre formation - Service Formation");
        return formationRepository.getFormationByTitre(titre);
    }
}

