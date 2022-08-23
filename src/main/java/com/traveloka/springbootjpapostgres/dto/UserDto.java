package com.traveloka.springbootjpapostgres.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    @Id
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Boolean isActive;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<StoreDto> stores;
}
