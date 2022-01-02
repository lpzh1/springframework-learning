package com.ioc.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class FixedDepositDetails {

    @NotNull
    private Long id = null;
    private float depositAmount;
    private int tenure;
    private String email;


}

