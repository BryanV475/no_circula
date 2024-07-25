package com.example.circula.service.impl;

import com.example.circula.repository.AutoRepository;
import com.example.circula.dto.AutoValidationResponse;
import com.example.circula.entity.AutoEntity;
import com.example.circula.service.AutoService;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;

    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public List<AutoEntity> findAll() {
        return autoRepository.findAll();
    }

    @Override
    public AutoEntity findByPlaca(String placa) {
        return autoRepository.findById(placa).orElse(null);
    }

    @Override
    public AutoEntity save(AutoEntity autoEntity) {
        return autoRepository.save(autoEntity);
    }

    @Override
    public AutoValidationResponse validateAuto(String placa, LocalDateTime fechaHora) {
        Optional<AutoEntity> autoOpt = autoRepository.findById(placa);
        if (autoOpt.isEmpty()) {
            return new AutoValidationResponse(null, false, "Vehículo no encontrado.");
        }

        AutoEntity auto = autoOpt.get();
        boolean puedeCircular = !hourRestriction(fechaHora) || !noCirculationDay(placa, fechaHora);
        String mensaje = puedeCircular ? "El vehículo puede circular." : "El vehículo no puede circular.";

        return new AutoValidationResponse(auto, puedeCircular, mensaje);

    }

    private boolean hourRestriction(LocalDateTime fechaHora) {
        LocalTime hora = fechaHora.toLocalTime();
        return (hora.isAfter(LocalTime.of(6, 0)) && hora.isBefore(LocalTime.of(9, 30))) ||
                (hora.isAfter(LocalTime.of(16, 0)) && hora.isBefore(LocalTime.of(20, 0)));
    }

    private boolean noCirculationDay(String placa, LocalDateTime fechaHora) {
        DayOfWeek diaSemana = fechaHora.getDayOfWeek();
        char ultimoDigito = placa.charAt(placa.length() - 1);
        int digitoPlaca = Character.getNumericValue(ultimoDigito);

        switch (diaSemana) {
            case MONDAY:
                return digitoPlaca == 1 || digitoPlaca == 2;
            case TUESDAY:
                return digitoPlaca == 3 || digitoPlaca == 4;
            case WEDNESDAY:
                return digitoPlaca == 5 || digitoPlaca == 6;
            case THURSDAY:
                return digitoPlaca == 7 || digitoPlaca == 8;
            case FRIDAY:
                return digitoPlaca == 9 || digitoPlaca == 0;
            default:
                return false; // Sábados y domingos no tienen restricción
        }

    }
}
