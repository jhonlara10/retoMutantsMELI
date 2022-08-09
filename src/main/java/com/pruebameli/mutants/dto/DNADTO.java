package com.pruebameli.mutants.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Class for build a dna sequence
 */
public class DNADTO {

	/**
	 * cadena de dna
	 */
	private @Setter @Getter String[] dna;

	@Override
	public String toString() {
		return String.join(",", dna);
	}

}
