package com.example.app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDTO {

    @NotNull(message = "Name must not be blank")
    private String name;

    @NotNull(message = "Address must not be blank")
    private String address;

    @NotNull(message = "Phone number must not be blank")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid")
    private String phone;
}
