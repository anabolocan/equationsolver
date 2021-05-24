package com.math.equationsolver.model;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class EquationResult {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer coefficienta;
    private Integer coefficientb;
    private Integer coefficientc;
    private Double discriminant;
    private String firstroot;
    private String secondroot;
    private boolean validequation;
    private String logtime;

    public EquationResult() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoefficienta() {
        return coefficienta;
    }

    public void setCoefficienta(Integer coefficienta) {
        this.coefficienta = coefficienta;
    }

    public Integer getCoefficientb() {
        return coefficientb;
    }

    public void setCoefficientb(Integer coefficientb) {
        this.coefficientb = coefficientb;
    }

    public Integer getCoefficientc() {
        return coefficientc;
    }

    public void setCoefficientc(Integer coefficientc) {
        this.coefficientc = coefficientc;
    }

    public Double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(Double discriminant) {
        this.discriminant = discriminant;
    }

    public String getFirstroot() {
        return firstroot;
    }

    public void setFirstroot(String firstroot) {
        this.firstroot = firstroot;
    }

    public String getSecondroot() {
        return secondroot;
    }

    public void setSecondroot(String secondroot) {
        this.secondroot = secondroot;
    }

    public boolean isValidequation() {
        return validequation;
    }

    public void setValidequation(boolean validequation) {
        this.validequation = validequation;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }
}
