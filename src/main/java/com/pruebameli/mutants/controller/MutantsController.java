package com.pruebameli.mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebameli.mutants.dto.DNADTO;
import com.pruebameli.mutants.entity.Stats;
import com.pruebameli.mutants.service.MutantsService;

/**
 * Controller for expose the services
 * 
 * @author jhonlara10
 */
@RestController
@RequestMapping("/mutants")
public class MutantsController {

	@Autowired
	private MutantsService mutantsService;

	@GetMapping("/stats")
	public Stats getStatsMutants() {
		return mutantsService.getStats();
	}

	@PostMapping("/mutant")
	public ResponseEntity<Void> isMutant(@RequestBody DNADTO dna) {
		return mutantsService.validateIsMutant(dna) ? ResponseEntity.ok().build()
				: ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

}
