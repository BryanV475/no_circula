package com.example.circula.dto;

import com.example.circula.entity.AutoEntity;

public class AutoValidationResponse {
    private AutoEntity auto;
    private boolean puedeCircular;
    private String mensaje;

    // Constructor
    public AutoValidationResponse(AutoEntity auto, boolean puedeCircular, String mensaje) {
        this.auto = auto;
        this.puedeCircular = puedeCircular;
        this.mensaje = mensaje;
    }

    public AutoEntity getAuto() {
        return auto;
    }

    public void setAuto(AutoEntity auto) {
        this.auto = auto;
    }

    public boolean isPuedeCircular() {
        return puedeCircular;
    }

    public void setPuedeCircular(boolean puedeCircular) {
        this.puedeCircular = puedeCircular;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

