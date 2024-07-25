package com.example.circula.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.circula.dto.AutoValidationResponse;
import com.example.circula.entity.AutoEntity;

public interface AutoService {
    List<AutoEntity> findAll();
    AutoEntity findByPlaca(String placa);
    AutoEntity save(AutoEntity autoEntity);
    AutoValidationResponse validateAuto(String placa, LocalDateTime fechaHora);
}