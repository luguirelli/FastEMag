package br.com.fastEmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.DefectEquipament;

public interface DefectEquipamentRepository extends JpaRepository<DefectEquipament, Long> {

	@Query(value = "select * from TB_DEFEITO_EQUIPAMENTO defEq", nativeQuery = true)
	List<DefectEquipament> find();
	
	@Query(value = "select * from TB_DEFEITO_EQUIPAMENTO defEq WHERE defEq.ID_HOSPITAL=:hospitalId", nativeQuery = true)
	List<DefectEquipament> findAll(@Param(value = "hospitalId") Long hospitalId);


}
