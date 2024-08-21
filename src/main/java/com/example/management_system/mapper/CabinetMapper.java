package com.example.management_system.mapper;

import com.example.management_system.dto.CabinetDto;
import com.example.management_system.model.Cabinet;

public class CabinetMapper {
    public static CabinetDto mapToCabinetDto(Cabinet cabinet) {
        return new CabinetDto(
                cabinet.getId(),
                cabinet.getCabinetName(),
                cabinet.getCabinetAddress()
        );
    }
    public static Cabinet mapToCabinet(CabinetDto cabinetDto) {
        return new Cabinet(
                cabinetDto.getId(),
                cabinetDto.getCabinetName(),
                cabinetDto.getCabinetAddress()
        );
    }
}
