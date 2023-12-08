package com.challenge1.module.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CheckAddress {
    // We need address and this should not be not null and not blank
    @NotNull
    @NotBlank
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
