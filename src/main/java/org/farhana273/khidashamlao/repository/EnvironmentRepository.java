package org.farhana273.khidashamlao.repository;

import org.farhana273.khidashamlao.domain.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
}