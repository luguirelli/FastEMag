package br.com.fastEmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.HistoricoDefeito;

public interface HistoricoDefeitoRepository extends JpaRepository<HistoricoDefeito, Long> {

	@Query(value = "select * from TB_HISTORICO_DEFEITO hf where hf.ID_HOSPITAL=:hospitalId", nativeQuery = true)
	List<HistoricoDefeito> findAllByHospital(@Param(value = "hospitalId") Long hospitalId);

}
