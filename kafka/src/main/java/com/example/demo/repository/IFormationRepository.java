package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FormationEntity;

@Repository
public interface IFormationRepository extends JpaRepository<FormationEntity, Long> {

    @Query("SELECT f FROM FormationEntity f WHERE f.titre =:titre")
    FormationEntity getFormationByTitre(String titre);

}
