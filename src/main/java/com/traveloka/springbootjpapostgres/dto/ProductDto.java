package com.traveloka.springbootjpapostgres.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
public class ProductDto {
    @Id
    private Long id;
    private String name;
    private String description;
    private Long store_id;
}
