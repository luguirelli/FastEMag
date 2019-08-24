package br.com.fastEmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fastEmag.models.OSEquipament;

public interface OSEquipamentRepository extends JpaRepository<OSEquipament, Long>{
	
	@Query(value = "select * from TB_OS_EQUIPAMENTO osEq", nativeQuery = true)
	List<OSEquipament> find();
	

}
