package com.traveloka.springbootjpapostgres.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
public class StoreDto {
    @Id
    private Long id;
    private String name;
    private String address;
    private Long user_id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private List<ProductDto> products;
}
