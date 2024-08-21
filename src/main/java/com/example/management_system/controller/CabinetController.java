package com.example.management_system.controller;

import com.example.management_system.dto.CabinetDto;
import com.example.management_system.service.CabinetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cabinet")
public class CabinetController {
    private final CabinetService cabinetService;

    @PostMapping
    public ResponseEntity<CabinetDto> createCabinet(@RequestBody CabinetDto cabinetDto) {
        CabinetDto savedCabinet = cabinetService.createCabinet(cabinetDto);
        return new ResponseEntity<>(savedCabinet, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CabinetDto> getCabinetById(@PathVariable Long id) {
        CabinetDto cabinetDto = cabinetService.getCabinetById(id);
        return new ResponseEntity<>(cabinetDto, HttpStatus.OK);
    }

    @GetMapping("/cabinets")
    public ResponseEntity<List<CabinetDto>> getCabinets() {
        List<CabinetDto> cabinets = cabinetService.getAllCabinets();
        return new ResponseEntity<>(cabinets, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CabinetDto> updateCabinet(@PathVariable Long id, @RequestBody CabinetDto updatedCabinet) {
        CabinetDto cabinetDto = cabinetService.updateCabinet(id, updatedCabinet);
        return new ResponseEntity<>(cabinetDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCabinet(@PathVariable Long id) {
        cabinetService.deleteCabinet(id);
        return ResponseEntity.ok("Cabinet deleted");
    }
}
