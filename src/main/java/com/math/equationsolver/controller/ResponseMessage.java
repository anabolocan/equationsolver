package com.math.equationsolver.controller;

import com.math.equationsolver.model.EquationResult;

public class ResponseMessage {
    private String message;
    private EquationResult equation;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EquationResult getEquation() {
        return equation;
    }

    public void setEquation(EquationResult equation) {
        this.equation = equation;
    }
}
