package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Environment;
import org.farhana273.khidashamlao.repository.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {

	private final EnvironmentRepository environmentRepository;

	@Autowired
	public EnvironmentServiceImpl(EnvironmentRepository environmentRepository) {
		this.environmentRepository = environmentRepository;
	}

	/**
     * @inheritDoc
     */
	public Environment findEnvironment(Long id) {
		Environment environment = environmentRepository.findOne(id);
		return environment;
	}
	
	/**
     * @inheritDoc
     */
	public Page<Environment> showAllEnvironments(Pageable pageable) {
		return environmentRepository.findAll(pageable);
	}

	/**
     * @inheritDoc
     */
	public void saveEnvironment(Environment environment) {
		environmentRepository.save(environment);
	}

	/**
     * @inheritDoc
     */
	public void deleteEnvironment(Long id) {
		environmentRepository.delete(id);
	}

}
