package com.fiapst1.asset_manager_service.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetDto {

    private Long id;

    private String nome;

    private String status;

}
