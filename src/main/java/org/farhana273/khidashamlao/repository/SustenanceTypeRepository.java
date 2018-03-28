package org.farhana273.khidashamlao.repository;

import org.farhana273.khidashamlao.domain.SustenanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SustenanceTypeRepository extends JpaRepository<SustenanceType, Long> {
}