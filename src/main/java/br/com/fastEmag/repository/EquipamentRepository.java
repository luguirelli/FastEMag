package br.com.fastEmag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fastEmag.models.Equipament;


public interface EquipamentRepository extends JpaRepository<Equipament, Long> {

}
