package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Sustenance;
import org.farhana273.khidashamlao.repository.SustenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SustenanceServiceImpl implements SustenanceService {

	private final SustenanceRepository sustenanceRepository;

	@Autowired
	public SustenanceServiceImpl(SustenanceRepository sustenanceRepository) {
		this.sustenanceRepository = sustenanceRepository;
	}

	/**
     * @inheritDoc
     */
	public Sustenance findSustenance(Long id) {
		Sustenance sustenance = sustenanceRepository.findOne(id);
		return sustenance;
	}

	/**
     * @inheritDoc
     */
	public Page<Sustenance> showAllSustenances(Pageable pageable) {
		return sustenanceRepository.findAll(pageable);
	}

	/**
     * @inheritDoc
     */
	public void saveSustenance(Sustenance sustenance) {
		sustenanceRepository.save(sustenance);
	}

	/**
     * @inheritDoc
     */
	public void deleteSustenance(Long id) {
		sustenanceRepository.delete(id);
	}

}
