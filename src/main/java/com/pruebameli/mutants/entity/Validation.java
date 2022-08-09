package com.pruebameli.mutants.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 * Class for build the entity that saves the information
 */
@Entity
@Table(name = "validation")
public class Validation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * El tamaño de este campo depende de MAX_DNA_SIZE. Cambiar los dos en
	 * simultaneo.
	 */
	@Column(name = "dna", length = 1000000)
	private @Getter @Setter String dna;

	@Column(name = "ismutant")
	private @Getter @Setter boolean isMutant;
}
