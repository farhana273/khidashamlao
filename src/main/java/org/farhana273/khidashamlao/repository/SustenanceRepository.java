package org.farhana273.khidashamlao.repository;

import org.farhana273.khidashamlao.domain.Sustenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SustenanceRepository extends JpaRepository<Sustenance, Long> {

}