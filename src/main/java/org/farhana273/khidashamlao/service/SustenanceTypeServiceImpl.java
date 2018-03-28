package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.SustenanceType;
import org.farhana273.khidashamlao.repository.SustenanceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SustenanceTypeServiceImpl implements SustenanceTypeService {

	private final SustenanceTypeRepository sustenanceTypeRepository;

	@Autowired
	public SustenanceTypeServiceImpl(SustenanceTypeRepository sustenanceTypeRepository) {
		this.sustenanceTypeRepository = sustenanceTypeRepository;
	}

	/**
     * @inheritDoc
     */
	public SustenanceType findSustenanceType(Long id) {
		SustenanceType sustenanceType = sustenanceTypeRepository.findOne(id);
		return sustenanceType;
	}
	
	/**
     * @inheritDoc
     */
	public Page<SustenanceType> showAllSustenanceTypes(Pageable pageable) {
		return sustenanceTypeRepository.findAll(pageable);
	}

	/**
     * @inheritDoc
     */
	public void saveSustenanceType(SustenanceType sustenanceType) {
		sustenanceTypeRepository.save(sustenanceType);
	}

	/**
     * @inheritDoc
     */
	public void deleteSustenanceType(Long id) {
		sustenanceTypeRepository.delete(id);
	}

}
