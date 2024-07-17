package org.example.practice.DTO.toAdd;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ClientToAddDTO {
    @NotNull(message = "first name is missing")
    @NotEmpty(message = "first name is missing")
    public String firstName;
    @NotNull(message = "middle name is missing")
    @NotEmpty(message = "middle name is missing")
    public String middleName;
    @NotNull(message = "last name is missing")
    @NotEmpty(message = "last name is missing")
    public String lastName;
    @NotNull(message = "passport number or series is missing")
    @NotEmpty(message = "passport number or series is missing")
    public String passportNumberAndSeries;

    public ClientToAddDTO(String firstName, String middleName, String lastName, String passportNumberAndSeries) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportNumberAndSeries = passportNumberAndSeries;
    }
}
