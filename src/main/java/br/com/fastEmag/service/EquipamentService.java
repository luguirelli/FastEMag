package br.com.fastEmag.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastEmag.models.Defect;
import br.com.fastEmag.models.DefectEquipament;
import br.com.fastEmag.models.Equipament;
import br.com.fastEmag.models.EquipamentTO;
import br.com.fastEmag.models.HistoricoDefeito;
import br.com.fastEmag.models.HistoricoDefeitoId;
import br.com.fastEmag.models.HistoricoProcedimento;
import br.com.fastEmag.models.HistoricoProcedimentoId;
import br.com.fastEmag.models.Hospital;
import br.com.fastEmag.models.HospitalSector;
import br.com.fastEmag.models.HospitalTO;
import br.com.fastEmag.models.OSEquipament;
import br.com.fastEmag.models.PatternEquipament;
import br.com.fastEmag.models.ServiceOrder;
import br.com.fastEmag.repository.DefectEquipamentRepository;
import br.com.fastEmag.repository.DefectRepository;
import br.com.fastEmag.repository.EquipamentRepository;
import br.com.fastEmag.repository.HistoricoDefeitoRepository;
import br.com.fastEmag.repository.HistoricoProcedimentoRepository;
import br.com.fastEmag.repository.HospitalRepository;
import br.com.fastEmag.repository.HospitalSectorRepository;
import br.com.fastEmag.repository.OSEquipamentRepository;
import br.com.fastEmag.repository.OSRepository;
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

	@Autowired
	HospitalRepository hospitalRepository;

	@Autowired
	OSRepository osRepository;

	@Autowired
	HistoricoProcedimentoRepository historicoProcedimentoRepository;

	@Autowired
	DefectRepository defectRepository;

	@Autowired
	HistoricoDefeitoRepository historicoDefeitoRepository;

	public Equipament newEquipament(EquipamentTO equipamento) throws ParseException {
//		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
//		Date data = formato.parse(equipamento.getNextPreventive());

		Hospital hospital = hospitalRepository.find(equipamento.getHospitalId());
		HospitalSector hospitalSector = hospitalSectorRepository.findByName(equipamento.getSector());
		PatternEquipament patternEquipament = patternEquipamentRepository.findByName(equipamento.getPatternEquipament());
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
		equipament.setNextPreventive(equipamento.getNextPreventive());
		equipament.setHospital(hospital);

		return equipamentRepository.save(equipament);
	}

	public List<Equipament> listEquipament() {
		return equipamentRepository.findAll();
	}

	public List<HistoricoDefeito> listHistDef(HospitalTO hospitalTO) {
		return historicoDefeitoRepository.findAllByHospital(hospitalTO.getId());
	}

	public List<HistoricoProcedimento> listHistProc(HospitalTO hospitalTO) {
		return historicoProcedimentoRepository.findAllByHospital(hospitalTO.getId());
	}

	public List<Equipament> listAllEquipamentByHospital(HospitalTO hospitalTO) {
		return equipamentRepository.findAllByHospital(hospitalTO.getId());
	}

	public List<OSEquipament> findAllOS(HospitalTO hospitalTO) {
		return osEquipamentRepository.findAllByHospital(hospitalTO.getId());
	}

	public List<DefectEquipament> findAllDefects(HospitalTO hospitalTO) {
		return defectEquipamentRepository.findAll(hospitalTO.getId());
	}

	public HistoricoProcedimento saveProcedimento(String serialNumber, String osName) {
		Equipament equipament = equipamentRepository.findBySerialNumber(serialNumber);
		ServiceOrder os = osRepository.find(osName);
		HistoricoProcedimentoId historicoProcedimentoId = new HistoricoProcedimentoId();
		historicoProcedimentoId.setEquipament(equipament);
		historicoProcedimentoId.setOs(os);
		HistoricoProcedimento historicoProcedimento = new HistoricoProcedimento();
		historicoProcedimento.setHistoricoProcedimentoId(historicoProcedimentoId);
		historicoProcedimento.setHospital(equipament.getHospital());
		Date date = new Date();
		String dtProcedure = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
		historicoProcedimento.setDtProcedure(dtProcedure);

		return historicoProcedimentoRepository.save(historicoProcedimento);

	}

	public HistoricoDefeito saveDefeito(String serialNumber, String defectName) {
		Equipament equipament = equipamentRepository.findBySerialNumber(serialNumber);
		Defect defect = defectRepository.find(defectName);
		HistoricoDefeitoId historicoDefeitoId = new HistoricoDefeitoId();
		historicoDefeitoId.setEquipament(equipament);
		historicoDefeitoId.setDefect(defect);
		HistoricoDefeito historicoDefeito = new HistoricoDefeito();
		historicoDefeito.setHistoricoDefeitoId(historicoDefeitoId);
		historicoDefeito.setHospital(equipament.getHospital());

		return historicoDefeitoRepository.save(historicoDefeito);

	}

	public Equipament updateEquipament(String date, String serialNumber) {
		Equipament equipament = equipamentRepository.findBySerialNumber(serialNumber);
		equipament.setNextPreventive(date);
		return equipamentRepository.save(equipament);
	}

}
