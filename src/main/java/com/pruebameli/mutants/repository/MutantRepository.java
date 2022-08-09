package com.pruebameli.mutants.repository;

import org.springframework.data.repository.CrudRepository;

import com.pruebameli.mutants.entity.Validation;

public interface MutantRepository extends CrudRepository<Validation, Long> {
	Integer countByIsMutant(boolean value);
}