package com.pruebameli.mutants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebameli.mutants.dto.DNADTO;
import com.pruebameli.mutants.entity.Stats;
import com.pruebameli.mutants.entity.Validation;
import com.pruebameli.mutants.repository.MutantRepository;

/**
 * 
 * Class for builder the logic that reponse the values
 * 
 * @author Jhon Lara
 *
 */
@Service
public class MutantsService {

	@Autowired
	private MutantRepository mutantRepository;

	/**
	 * Method that call to the validate is mutant
	 * 
	 * @param dna
	 * @return boolean value with the validation
	 */
	public boolean isMutant(DNADTO dna) {
		return validateIsMutant(dna);
	}

	/**
	 * Method that send the stats
	 * 
	 * @return stats of the validations
	 */
	public Stats getStats() {
		return new Stats(mutantRepository.countByIsMutant(false), mutantRepository.countByIsMutant(true));
	}

	/*
	 * Method that validate if the dna sequence is mutant
	 * 
	 * @return boolean value with the validation
	 * 
	 */
	public boolean validateIsMutant(DNADTO dna) {
		if (dna.getDna() == null || dna.getDna().length < 4) {
			return false;
		}
		char[][] dnas = generateMatrix(dna);
		int mutants = validateRows(dnas);
		boolean res = mutants > 1 ? true
				: (mutants += validateCols(dnas)) > 1 ? true
						: (mutants += validateDiagonalAsc(dnas)) > 1 ? true
								: (mutants += validateDiagonalDesc(dnas)) > 1 ? true : false;
		Validation validation = new Validation();
		validation.setDna(dna.toString());
		validation.setMutant(res);
		mutantRepository.save(validation);
		return res;
	}

	/*
	 * Method that validate if the dna columns have mutants value
	 * 
	 * @return validations number that find
	 * 
	 */
	private int validateCols(char[][] dnas) {
		int cont = 0;
		for (int i = 0; i < dnas.length; i++) {
			if (validateCol(dnas, i) != 0) {
				cont++;
			}
		}
		return cont;
	}

	/*
	 * Method that validate if the dna rows have mutants value
	 * 
	 * @return validations number that find
	 * 
	 */
	private int validateRows(char[][] dnas) {
		int cont = 0;
		for (int i = 0; i < dnas.length; i++) {
			if (validateRow(dnas[i]) != 0) {
				cont++;
			}
		}
		return cont;
	}

	/*
	 * Method that validate if the dna row have mutants value
	 * 
	 * @return validations number that find
	 * 
	 */
	private int validateRow(char[] dnas) {
		int validations = 0;
		long cont = 0;
		char ant = '0';
		for (char c : dnas) {
			if (c == ant) {
				cont++;
			} else {
				ant = c;
				cont = 0;
			}
			if (cont >= 3) {
				validations++;
			}
		}
		return validations;
	}

	/*
	 * Method that validate if the dna column have mutants value
	 * 
	 * @return validations number that find
	 * 
	 */
	private int validateCol(char[][] dnas, int col) {
		int validations = 0;
		long cont = 0;
		char ant = 0;
		for (int i = 0; i < dnas.length; i++) {
			if (dnas[i][col] == ant) {
				cont++;
			} else {
				ant = dnas[i][col];
				cont = 0;
			}
			if (cont >= 3) {
				validations++;
			}
		}
		return validations;
	}

	/*
	 * Method that generate two-dimensional matrix
	 * 
	 * @return two-dimensional matrix dna
	 * 
	 */
	private char[][] generateMatrix(DNADTO dna) {
		int size = dna.getDna().length;
		char[][] dnaMatrix = new char[size][size];

		for (int i = 0; i < size; i++) {
			String dnaItem = dna.getDna()[i];
			dnaMatrix[i] = dnaItem.toUpperCase().toCharArray();
		}
		return dnaMatrix;
	}

	/*
	 * Method that validate if the dna diagonals asc have mutants value
	 * 
	 * @return validations number that find
	 * 
	 */
	static int validateDiagonalAsc(char matriz[][]) {
		int validations = 0;
		int d = matriz.length;
		for (int i = d - 1; i >= 0; i--) {
			int col = i, row = 0, cont = 0;
			char ant = 0;
			while (col < d && row < d) {
				if (matriz[col][row] == ant) {
					cont++;
				} else {
					ant = matriz[col][row];
					cont = 0;
				}
				if (cont >= 3) {
					validations++;
				}
				col++;
				row++;
			}
		}
		for (int j = 0; j < d - 1; j++) {
			int row = 0, col = j + 1, cont = 0;
			char ant = 0;
			while (row < d && col < d) {
				if (matriz[col][row] == ant) {
					cont++;
				} else {
					ant = matriz[col][row];
					cont = 0;
				}
				if (cont >= 3) {
					validations++;
				}
				col++;
				row++;
			}
		}
		return validations;
	}

	/*
	 * Method that validate if the dna diagonals desc have mutants value
	 * 
	 * @return validations number that find
	 * 
	 */
	static int validateDiagonalDesc(char matriz[][]) {

		int validations = 0;
		int d = matriz.length;
		for (int i = 0; i <= d - 1; i++) {
			int col = i, row = 0, cont = 0;
			char ant = 0;
			while (col < d && row < d && col >= 0) {
				if (matriz[col][row] == ant) {
					cont++;
				} else {
					ant = matriz[col][row];
					cont = 0;
				}
				if (cont >= 3) {
					validations++;
				}
				col--;
				row++;
			}
		}
		for (int j = 0; j < d - 1; j++) {
			int row = d - 1, col = j + 1, cont = 0;
			char ant = 0;
			while (row < d && col < d) {
				if (matriz[col][row] == ant) {
					cont++;
				} else {
					ant = matriz[col][row];
					cont = 0;
				}
				if (cont >= 3) {
					validations++;
				}
				col++;
				row--;
			}
		}
		return validations;
	}

}
