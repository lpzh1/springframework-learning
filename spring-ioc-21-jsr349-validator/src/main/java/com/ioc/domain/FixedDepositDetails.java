package com.ioc.domain;

import lombok.Data;

import javax.validation.constraints.*;


@Data
public class FixedDepositDetails {

    @NotNull
    private Long id;
    @Min(100)
    @Max(50000)
    private float depositAmount;
    @Min(6)
    private int tenure;
    @NotBlank
    @Size(min = 5,max = 100)
    @Email
    private String email;


}

