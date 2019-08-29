package br.com.fastEmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fastEmag.models.HospitalSector;

@Repository
public interface HospitalSectorRepository extends JpaRepository<HospitalSector, Long> {

	@Query(value = "select * from TB_SETOR_HOSPITAL sh WHERE sh.ID_SETOR_HOSPITAL=:hospitalSectorId", nativeQuery = true)
	HospitalSector find(@Param(value = "hospitalSectorId") Long hospitalSectorId);

	@Query(value = "select * from TB_SETOR_HOSPITAL sh WHERE sh.DS_NOME=:nome", nativeQuery = true)
	HospitalSector findByName(@Param(value = "nome") String hospitalSector);
}
