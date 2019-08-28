package br.com.fastEmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.Hospital;
import br.com.fastEmag.models.HospitalSector;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	List<Hospital> findAll();
	
	@Query(value = "select * from TB_HOSPITAL  WHERE ID_HOSPITAL=:hospitalId", nativeQuery = true)
	Hospital find(@Param(value = "hospitalId") Long hospitalSectorId);

}
