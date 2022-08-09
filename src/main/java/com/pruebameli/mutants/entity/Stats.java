package com.pruebameli.mutants.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class for build the stats
 * 
 * @author Jhon Lara
 *
 */
public class Stats {

	private @Getter @Setter long count_mutant_dna;
	private @Getter @Setter long count_human_dna;
	private @Getter @Setter double ratio;

	/**
	 *
	 * Build a stat
	 * 
	 * @param countHumanDNA  numero de humanos
	 * @param countMutantDNA numero de mutantes
	 */
	public Stats(long countHumanDNA, long countMutantDNA) {
		this.count_mutant_dna = countMutantDNA;
		this.count_human_dna = countHumanDNA;
		this.ratio = 1.0 * count_mutant_dna / count_human_dna;
	}
}
