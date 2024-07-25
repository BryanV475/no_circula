package com.example.circula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.circula.service.AutoService;
import com.example.circula.dto.AutoValidationResponse;
import com.example.circula.entity.AutoEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/auto")
@CrossOrigin(origins = "*")
public class AutoController {
    @Autowired
    private AutoService autoService;

    @GetMapping
    public List<AutoEntity> findAll() {
        return autoService.findAll();
    }

    @GetMapping("/{placa}")
    public AutoEntity findByPlaca(String placa) {
        return autoService.findByPlaca(placa);
    }

    @PostMapping
    public AutoEntity save(@RequestBody AutoEntity autoEntity) {
        return autoService.save(autoEntity);
    }

    @PostMapping("/validate")
    public ResponseEntity<AutoValidationResponse> validateCirculation(@RequestParam String placa, @RequestParam String fechaHora) {
        try {
            LocalDateTime fechaHoraDT = LocalDateTime.parse(fechaHora);
            AutoValidationResponse response = autoService.validateAuto(placa, fechaHoraDT);
            return ResponseEntity.ok(response);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body(new AutoValidationResponse(null, false, "Formato de fecha y hora inválido."));
        }
    }

}
