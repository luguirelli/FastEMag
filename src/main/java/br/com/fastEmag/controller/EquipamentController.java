package br.com.fastEmag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fastEmag.exception.BRException;
import br.com.fastEmag.models.DefectEquipamentTO;
import br.com.fastEmag.models.Equipament;
import br.com.fastEmag.models.EquipamentTO;
import br.com.fastEmag.models.EquipamentoTO;
import br.com.fastEmag.models.HistDefTO;
import br.com.fastEmag.models.HistProcTO;
import br.com.fastEmag.models.HistoricoDefeito;
import br.com.fastEmag.models.HistoricoDefeitoTO;
import br.com.fastEmag.models.HistoricoProcedimento;
import br.com.fastEmag.models.HistoricoProcedimentoTO;
import br.com.fastEmag.models.HospitalTO;
import br.com.fastEmag.models.OSEquipamentTO;
import br.com.fastEmag.models.PreventivasTO;
import br.com.fastEmag.service.EquipamentService;

@RestController
@RequestMapping(path = "/equipament")
public class EquipamentController {

	@Autowired
	EquipamentService equipamentService;

	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Equipament newEquipament(@RequestBody EquipamentTO equipamento) {
		try {
			return equipamentService.newEquipament(equipamento);
		} catch (Exception ex) {
			throw new BRException("Erro ao cadastrar equipamento: " + ex.toString());
		}
	}

	@PostMapping(value = "/find", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Equipament> findAll(@RequestBody HospitalTO hospitalTO) {
		try {
			return equipamentService.listAllEquipamentByHospital(hospitalTO);
		} catch (Exception ex) {
			throw new BRException("Erro ao listar todos os equipamentos: " + ex.toString());
		}
	}

	@GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Equipament> list() {
		try {
			return equipamentService.listEquipament();
		} catch (Exception ex) {
			throw new BRException("Erro ao listar todos os equipamentos: " + ex.toString());
		}
	}

	@PostMapping(path = "/findOS", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OSEquipamentTO> listOS(@RequestBody HospitalTO hospitalTO) {
		try {
			List<OSEquipamentTO> osEquipamentTOlist = OSEquipamentTO
					.listConverter(equipamentService.findAllOS(hospitalTO));
			return osEquipamentTOlist;
		} catch (Exception ex) {
			throw new BRException("Erro ao listar as ordens de serviço: " + ex.toString());
		}
	}

	@PostMapping(path = "/findHistProc", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HistProcTO> listProc(@RequestBody HospitalTO hospitalTO) {
		try {
			List<HistProcTO> histProcTOlist = HistProcTO.listConverter(equipamentService.listHistProc(hospitalTO));
			return histProcTOlist;
		} catch (Exception ex) {
			throw new BRException("Erro ao listar o histórico de procedimentos: " + ex.toString());
		}
	}

	@PostMapping(path = "/findHistDef", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HistDefTO> listDef(@RequestBody HospitalTO hospitalTO) {
		try {
			List<HistDefTO> histDefTOlist = HistDefTO.listConverter(equipamentService.listHistDef(hospitalTO));
			return histDefTOlist;
		} catch (Exception ex) {
			throw new BRException("Erro ao listar o histórico de defeitos: " + ex.toString());
		}
	}

//	@GetMapping(path = "/findDefects", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<DefectEquipamentTO> listDefects() {
//		try {
//			List<DefectEquipamentTO> defectEquipamentTOlist = DefectEquipamentTO.listConverter(equipamentService.findAllDefects());
//			return defectEquipamentTOlist;
//		} catch (Exception ex) {
//			throw new BRException("Erro ao listar os defeitos: " + ex.toString());
//		}
//	}

	@PostMapping(value = "/findAllDefects", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DefectEquipamentTO> findAllDefects(@RequestBody HospitalTO hospitalTO) {
		try {
			List<DefectEquipamentTO> defectEquipamentTOlist = DefectEquipamentTO
					.listConverter(equipamentService.findAllDefects(hospitalTO));
			return defectEquipamentTOlist;
		} catch (Exception ex) {
			throw new BRException("Erro ao listar todos os defeitos: " + ex.toString());
		}
	}

	@PostMapping(path = "/findPreventivas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PreventivasTO> listPreventivas(@RequestBody HospitalTO hospitalTO) {
		try {
			List<PreventivasTO> preventivasTOlist = PreventivasTO.listConverter(equipamentService.listAllEquipamentByHospital(hospitalTO));
			return preventivasTOlist;
		} catch (Exception ex) {
			throw new BRException("Erro ao listar todas as preventivas: " + ex.toString());
		}
	}

	@PostMapping(value = "/saveHistProc", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HistoricoProcedimento saveHistoricoProcedimento(
			@RequestBody HistoricoProcedimentoTO historicoProcedimentoTO) {
		try {
			return equipamentService.saveProcedimento(historicoProcedimentoTO.getSerialNumber(),
					historicoProcedimentoTO.getNameOs());
		} catch (Exception ex) {
			throw new BRException("Erro ao salvar historico de procedimentos: " + ex.toString());
		}
	}

	@PostMapping(value = "/saveHistDef", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HistoricoDefeito saveHistoricoDefeito(@RequestBody HistoricoDefeitoTO historicoDefeitoTO) {
		try {
			return equipamentService.saveDefeito(historicoDefeitoTO.getSerialNumber(), historicoDefeitoTO.getDefect());
		} catch (Exception ex) {
			throw new BRException("Erro ao salvar historico de defeitos: " + ex.toString());
		}
	}

	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Equipament update(@RequestBody EquipamentoTO equipamentoTO) {
		try {
			return equipamentService.updateEquipament(equipamentoTO.getNextPreventive(), equipamentoTO.getSerialNumber());
		} catch (Exception ex) {
			throw new BRException("Erro ao atualizar data da próxima preventiva: " + ex.toString());
		}
	}
}
