package br.com.fastEmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.Equipament;


public interface EquipamentRepository extends JpaRepository<Equipament, Long> {
	
	@Query(value = "select * from TB_EQUIPAMENTO f where f.ID_HOSPITAL=:hospitalId", nativeQuery = true)
	List<Equipament> findAllByHospital(@Param(value = "hospitalId") Long hospitalId);

}
