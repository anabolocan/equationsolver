package com.math.equationsolver.repository;

import com.math.equationsolver.model.EquationResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquationResultRepository extends JpaRepository<EquationResult, Integer> {

    EquationResult findByCoefficientaAndCoefficientbAndCoefficientc(Integer coefficienta, Integer coefficientb, Integer coefficientc);

}
