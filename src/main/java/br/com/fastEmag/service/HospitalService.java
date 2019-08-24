package br.com.fastEmag.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastEmag.exception.ValidationException;
import br.com.fastEmag.models.Hospital;
import br.com.fastEmag.repository.HospitalRepository;

@Service
@Transactional
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository; 
	
	public List<Hospital> findAll(){ 
		List<Hospital> hospitals = hospitalRepository.findAll();
		if(hospitals.size() == 0) {
			throw new ValidationException("Nenhum hospital foi encontrado!");
		} else {
			return hospitals;
		}
	}

}
