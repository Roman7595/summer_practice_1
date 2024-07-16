package org.example.practice.DTO;


public class ClientDTO {
    public int id;
    public String firstName;
    public String middleName;
    public String lastName;
    public String passportNumberAndSeries;
    public ClientDTO(int id, String firstName, String middleName, String lastName, String passportNumberAndSeries) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportNumberAndSeries = passportNumberAndSeries;
    }
}
