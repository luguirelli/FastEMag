package br.com.fastEmag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fastEmag.models.Equipament;

public interface EquipamentRepository extends JpaRepository<Equipament, Long> {

	@Query(value = "select * from TB_EQUIPAMENTO f where f.ID_HOSPITAL=:hospitalId", nativeQuery = true)
	List<Equipament> findAllByHospital(@Param(value = "hospitalId") Long hospitalId);
	
	@Query(value = "select * from TB_EQUIPAMENTO f where f.ID_EQUIPAMENTO=:id", nativeQuery = true)
	Equipament find(@Param(value = "id") Long id);

	@Query(value = "select * from TB_EQUIPAMENTO f where f.DS_NUMERO_SERIE=:serialNumber", nativeQuery = true)
	Equipament findBySerialNumber(@Param(value = "serialNumber") String serialNumber);
	
//	@Query(value = "UPDATE TB_EQUIPAMENTO SET DT_PROXIMA_PREVENTIVA=:date WHERE ID_EQUIPAMENTO=:id", nativeQuery = true)
//	void update(@Param(value = "date") String date, @Param(value="id") Long id);

}
