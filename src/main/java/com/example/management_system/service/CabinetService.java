package com.example.management_system.service;

import com.example.management_system.dto.CabinetDto;

import java.util.List;

public interface CabinetService {
    CabinetDto createCabinet(CabinetDto cabinetDto);
    CabinetDto getCabinetById(Long id);
    List<CabinetDto> getAllCabinets();
    CabinetDto updateCabinet(Long id, CabinetDto updatedCabinet);
    void deleteCabinet(Long id);
}
