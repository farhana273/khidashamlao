package org.farhana273.khidashamlao.repository;

import org.farhana273.khidashamlao.domain.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
	
}
