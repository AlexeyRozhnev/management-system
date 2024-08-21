package com.example.management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabinetDto {
    private Long id;
    private String CabinetName;
    private String CabinetAddress;
}
