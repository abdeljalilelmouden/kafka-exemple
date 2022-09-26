package com.example.demo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.FormationEntity;
import com.example.demo.repository.IFormationRepository;

@Component
public class DataInit implements CommandLineRunner {

	@Autowired
	private IFormationRepository formationRepository;

	/**
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {

		formationRepository.save(new FormationEntity(null, "JAVA", false));

		formationRepository.save(new FormationEntity(null, "PHP", false));

		formationRepository.save(new FormationEntity(null, "PYTHON", false));

		formationRepository.save(new FormationEntity(null, "CASSANDRA", false));

		formationRepository.save(new FormationEntity(null, "ANGULAR", false));
	}
}