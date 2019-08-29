package br.com.fastEmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.ServiceOrder;

public interface OSRepository extends JpaRepository<ServiceOrder, Long> {

	@Query(value = "select * from TB_ORDEM_SERVICO os WHERE os.DS_NOME=:nome", nativeQuery = true)
	ServiceOrder find(@Param(value = "nome") String nome);

}
