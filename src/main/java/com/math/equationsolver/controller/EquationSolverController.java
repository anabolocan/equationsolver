package com.math.equationsolver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.math.equationsolver.model.Equation;
import com.math.equationsolver.model.EquationResult;
import com.math.equationsolver.service.EquationSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/equationsolver")
public class EquationSolverController {
    @Autowired
    EquationSolverService equationSolverService;

    @GetMapping("/")
    public ResponseEntity<String> checkConnection() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/allEquations")
    public ResponseEntity<List<EquationResult>> getAllEquationSolvers() {
        List<EquationResult> equationResultList = new ArrayList<>(equationSolverService.getAllEquationResults());
        return new ResponseEntity<>(equationResultList, HttpStatus.OK);
    }
    @PostMapping("/calculateEquation")
    public ResponseEntity<ResponseMessage> calculateEquation(@RequestBody String equation) {
        ResponseMessage responseMessage = new ResponseMessage();
        EquationResult equationResult;
        try {
            Equation equationData = new ObjectMapper().readValue(equation, Equation.class);
            equationResult = equationSolverService.calculateEquation(equationData);
        } catch (Exception e) {
            responseMessage.setMessage(e.getMessage());
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        responseMessage.setEquation(equationResult);
        responseMessage.setMessage("The request was successful");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
