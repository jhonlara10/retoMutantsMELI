package com.pruebameli.mutants;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pruebameli.mutants.dto.DNADTO;
import com.pruebameli.mutants.service.MutantsService;

@SpringBootTest
class MutantsMeliApplicationTests {

	@Autowired
	MutantsService mutantsService;

	@Test
	public void testHumanDNA() throws Exception {
		String[] dna = { "ACCTATC", "CTCACTT", "ACGCTAT", "ACCTACC", "CAATTCC", "CACCAAT", "CAACAAT" };
		DNADTO dnaDTO = new DNADTO();
		dnaDTO.setDna(dna);
		assertFalse(mutantsService.isMutant(dnaDTO));
	}

	@Test
	public void testMutanDNA() throws Exception {
		String[] dna = { "ACCTATC", "ATCACTT", "ACGCTAT", "ACCTACC", "CAATTCT", "CACCAAT", "CAACAAT" };
		DNADTO dnaDTO = new DNADTO();
		dnaDTO.setDna(dna);
		assertFalse(mutantsService.isMutant(dnaDTO));
	}

	@Test
	public void testStats() throws Exception {
		assertNotNull(mutantsService.getStats());
		assertNotNull(mutantsService.getStats().getCount_human_dna());
		assertNotNull(mutantsService.getStats().getCount_mutant_dna());
		assertNotNull(mutantsService.getStats().getRatio());
	}

}
