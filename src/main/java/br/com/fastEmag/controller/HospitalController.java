package br.com.fastEmag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fastEmag.exception.BRException;
import br.com.fastEmag.models.Hospital;
import br.com.fastEmag.service.HospitalService;

@RestController
@RequestMapping(path = "/hospital")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hospital> findHospital(){
		try {
			return hospitalService.findAll();
		}  catch (Exception ex) {
			throw new BRException("Erro ao listar todos os hospitais cadastrados: " + ex.toString());
}

}
}