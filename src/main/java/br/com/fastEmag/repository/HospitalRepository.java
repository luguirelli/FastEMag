package br.com.fastEmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fastEmag.models.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	List<Hospital> findAll();

}
