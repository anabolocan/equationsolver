package com.math.equationsolver.service;

import com.math.equationsolver.model.Equation;
import com.math.equationsolver.model.EquationResult;
import com.math.equationsolver.repository.EquationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EquationSolverService {

    @Autowired
    EquationResultRepository equationResultRepository;

    public List<EquationResult> getAllEquationResults() {
        List<EquationResult> equationResultList = new ArrayList<>(equationResultRepository.findAll());

        return equationResultList;
    }

    public EquationResult calculateEquation(Equation equation) {
        //try to find same equation in db
        EquationResult equationResult = equationResultRepository.findByCoefficientaAndCoefficientbAndCoefficientc(equation.getA(), equation.getB(), equation.getC());
        if (equationResult == null) {
            //in this case we didn't find result in db
            equationResult = calculateEquationResult(equation);

            //just save in db new result
            equationResultRepository.save(equationResult);
        }
        else if(equation.isComplexSolution() == (equationResult.getFirstroot() == null)){
            //recalculate result with db
            int id = equationResult.getId();
            equationResult = calculateEquationResult(equation);
            equationResult.setId(id);

            //just save in db new result
            equationResultRepository.save(equationResult);
        }

        return equationResult;
    }

    private EquationResult calculateEquationResult(Equation equation) {
        EquationResult equationResult = new EquationResult();

        equationResult.setCoefficienta(equation.getA());
        equationResult.setCoefficientb(equation.getB());
        equationResult.setCoefficientc(equation.getC());

        double discriminant = Math.pow(equation.getB(), 2) - 4 * equation.getA() * equation.getC();
        equationResult.setDiscriminant(discriminant);
        if (discriminant < 0) {
            equationResult.setValidequation(false);
            if(equation.isComplexSolution()){
                equationResult.setFirstroot("(" + (equation.getB() < 0 ? equation.getB() : "-" + equation.getB()) + " + " +"i√" + discriminant + ") / " + 2 * equation.getA());
                equationResult.setSecondroot("(" + (equation.getB() < 0 ? equation.getB() : "-" + equation.getB()) + " - " +"i√" + discriminant + ") / " + 2 * equation.getA());
            }
        } else {
            equationResult.setValidequation(true);
            double x1 = (-1 * equation.getB() + Math.sqrt(discriminant)) / (2 * equation.getA());
            double x2 = (-1 * equation.getB() - Math.sqrt(discriminant)) / (2 * equation.getA());
            equationResult.setFirstroot(Double.toString(x1));
            equationResult.setSecondroot(Double.toString(x2));
        }

        equationResult.setLogtime(new SimpleDateFormat("yyyy:MM:dd | HH:mm:ss").format(new Date()));
        return equationResult;
    }
}
