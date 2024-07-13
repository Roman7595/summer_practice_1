package org.example.practice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name="clients")
public class Client extends BaseEntity{
    private String firstName;
    private String middleName;
    private String lastName;
    private String passportNumberAndSeries;

    private Set<Auto> autos;
    public Client(String firstName, String middleName, String lastName, String passportNumberAndSeries) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportNumberAndSeries = passportNumberAndSeries;
    }

    @Column(name="first_name", nullable=false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name="middle_name", nullable=false)
    public String getMiddleName() {
        return middleName;
    }

    @Column(name="last_name", nullable=false)
    public String getLastName() {
        return lastName;
    }

    @Column(name="passport_number_and_series", nullable=false, unique=true)
    public String getPassportNumberAndSeries() {
        return passportNumberAndSeries;
    }

    @OneToMany(mappedBy="client")
    public Set<Auto> getAutos() {
        return autos;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportNumberAndSeries(String passportNumberAndSeries) {
        this.passportNumberAndSeries = passportNumberAndSeries;
    }

    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }
}
