package br.com.fastEmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.HistoricoProcedimento;

public interface HistoricoProcedimentoRepository extends JpaRepository<HistoricoProcedimento, Long> {
	
	@Query(value = "select * from TB_HISTORICO_PROCEDIMENTO hp where hp.ID_HOSPITAL=:hospitalId", nativeQuery = true)
	List<HistoricoProcedimento> findAllByHospital(@Param(value = "hospitalId") Long hospitalId);

}
