package br.com.fastEmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.PatternEquipament;

public interface PatternEquipamentRepository extends JpaRepository<PatternEquipament, Long> {
	
	@Query(value = "select * from TB_EQUIPAMENTO_PADRAO eq where eq.ID_EQUIPAMENTO_PADRAO=:patternEquipamentId", nativeQuery = true)
	PatternEquipament find(@Param(value = "patternEquipamentId") Long patternEquipamentId);
	

}
