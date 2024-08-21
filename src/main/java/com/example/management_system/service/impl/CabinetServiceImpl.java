package com.example.management_system.service.impl;

import com.example.management_system.dto.CabinetDto;
import com.example.management_system.exception.ResourceNotFoundException;
import com.example.management_system.mapper.CabinetMapper;
import com.example.management_system.model.Cabinet;
import com.example.management_system.repository.CabinetRepository;
import com.example.management_system.service.CabinetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CabinetServiceImpl implements CabinetService {

    private CabinetRepository cabinetRepository;

    @Override
    public CabinetDto createCabinet(CabinetDto cabinetDto) {
        Cabinet cabinet = CabinetMapper.mapToCabinet(cabinetDto);
        Cabinet savedCabinet = cabinetRepository.save(cabinet);
        return CabinetMapper.mapToCabinetDto(savedCabinet);
    }

    @Override
    public CabinetDto getCabinetById(Long id) {
        Cabinet cabinet = cabinetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cabinet not found"));
        return CabinetMapper.mapToCabinetDto(cabinet);
    }

    @Override
    public List<CabinetDto> getAllCabinets() {
        List<Cabinet> cabinets = cabinetRepository.findAll();
        return cabinets.stream().map(CabinetMapper::mapToCabinetDto).collect(Collectors.toList());
    }

    @Override
    public CabinetDto updateCabinet(Long id, CabinetDto updatedCabinet) {
        Cabinet cabinet = cabinetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cabinet not found"));
        cabinet.setCabinetName(updatedCabinet.getCabinetName());
        cabinet.setCabinetAddress(updatedCabinet.getCabinetAddress());
        Cabinet savedCabinet = cabinetRepository.save(cabinet);
        return CabinetMapper.mapToCabinetDto(savedCabinet);
    }

    @Override
    public void deleteCabinet(Long id) {
        cabinetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cabinet not found"));
        cabinetRepository.deleteById(id);
    }
}
