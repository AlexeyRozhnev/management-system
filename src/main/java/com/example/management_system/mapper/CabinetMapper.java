package com.example.management_system.mapper;

import com.example.management_system.dto.CabinetDto;
import com.example.management_system.model.Cabinet;

public class CabinetMapper {
    public static CabinetDto mapToCabinetDto(Cabinet cabinet) {
        CabinetDto cabinetDto = new CabinetDto();
        cabinetDto.setId(cabinet.getId());
        cabinetDto.setCabinetName(cabinet.getCabinetName());
        cabinetDto.setCabinetAddress(cabinet.getCabinetAddress());
        return cabinetDto;
    }
    public static Cabinet mapToCabinet(CabinetDto cabinetDto) {
        Cabinet cabinet = new Cabinet();
        cabinet.setId(cabinetDto.getId());
        cabinet.setCabinetName(cabinetDto.getCabinetName());
        cabinet.setCabinetAddress(cabinetDto.getCabinetAddress());
        return cabinet;
    }
}
