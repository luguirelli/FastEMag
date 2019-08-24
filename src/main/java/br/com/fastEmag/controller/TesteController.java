package br.com.fastEmag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fastEmag.models.Hospital;
import br.com.fastEmag.repository.HospitalRepository;

@RestController
@RequestMapping(path = "/teste")
public class TesteController {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	
	@GetMapping(path = "/hospital", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hospital> findHospital() {
		return hospitalRepository.findAll();
		
}

}
