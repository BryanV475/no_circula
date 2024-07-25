package com.example.circula.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "auto")
public class AutoEntity {
    @Id
    @Column(name = "placa")
    private String placa;

    @Column(name = "chasis")
    private String chasis;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    public AutoEntity() {
    }

    public AutoEntity(String placa, String chasis, String modelo, String color) {
        this.placa = placa;
        this.chasis = chasis;
        this.modelo = modelo;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


