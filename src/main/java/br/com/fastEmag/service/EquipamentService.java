package br.com.fastEmag.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastEmag.models.DefectEquipament;
import br.com.fastEmag.models.Equipament;
import br.com.fastEmag.models.EquipamentTO;
import br.com.fastEmag.models.HospitalSector;
import br.com.fastEmag.models.OSEquipament;
import br.com.fastEmag.models.PatternEquipament;
import br.com.fastEmag.repository.DefectEquipamentRepository;
import br.com.fastEmag.repository.EquipamentRepository;
import br.com.fastEmag.repository.HospitalSectorRepository;
import br.com.fastEmag.repository.OSEquipamentRepository;
import br.com.fastEmag.repository.PatternEquipamentRepository;

@Service
@Transactional
public class EquipamentService {

	@Autowired
	EquipamentRepository equipamentRepository;

	@Autowired
	HospitalSectorRepository hospitalSectorRepository;

	@Autowired
	PatternEquipamentRepository patternEquipamentRepository;

	@Autowired
	OSEquipamentRepository osEquipamentRepository;

	@Autowired
	DefectEquipamentRepository defectEquipamentRepository;

	public Equipament newEquipament(EquipamentTO equipamento) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date data = formato.parse(equipamento.getNextPreventive());

		HospitalSector hospitalSector = hospitalSectorRepository.find(equipamento.getHospitalSector());
		PatternEquipament patternEquipament = patternEquipamentRepository.find(equipamento.getPatternEquipament());
		Equipament equipament = new Equipament();
		equipament.setName(equipamento.getName());
		equipament.setAnvisaNumber(equipamento.getAnvisaNumber());
		equipament.setCriticality(equipamento.getCriticality());
		equipament.setFunction(equipamento.getFunction());
		equipament.setHospitalSector(hospitalSector);
		equipament.setPatternEquipament(patternEquipament);
		equipament.setModel(equipamento.getModel());
		equipament.setImportance(equipamento.getImportance());
		equipament.setProducer(equipamento.getProducer());
		equipament.setSerialNumber(equipamento.getSerialNumber());
		equipament.setNextPreventive(data);

		return equipamentRepository.save(equipament);
	}

	public List<Equipament> listEquipament() {
		return equipamentRepository.findAll();
	}

	public List<OSEquipament> findAllOS() {
		return osEquipamentRepository.find();
	}

	public List<DefectEquipament> findAllDefects() {
		return defectEquipamentRepository.find();
	}

}
