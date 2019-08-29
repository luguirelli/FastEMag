package br.com.fastEmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.Defect;

public interface DefectRepository extends JpaRepository<Defect, Long> {
 
	@Query(value = "select * from TB_DEFEITO d WHERE d.DS_NOME=:nome", nativeQuery = true)
	Defect find(@Param(value = "nome") String nome);

}
