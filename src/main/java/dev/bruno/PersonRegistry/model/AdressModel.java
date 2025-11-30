package dev.bruno.PersonRegistry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import java.util.List;

@Builder
@Table(name = "adress")
@Entity
public class AdressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adress", nullable = false, unique = true)
    private String adress;

    @Column(name = "number")
    private short number;

    @Column(name = "neighborhood")
    private String neighborhood;

    @OneToMany(mappedBy = "adress") // One address for multiple person
    @JsonIgnore
    private List<PersonModel> person;

    public AdressModel(){

    }

    public AdressModel(Long id, String adress, short number, String neighborhood,  List<PersonModel> person) {
        this.id = id;
        this.adress = adress;
        this.number = number;
        this.neighborhood = neighborhood;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<PersonModel> getPerson() {
        return person;
    }

    public void setPerson(List<PersonModel> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "AdressModel{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", number=" + number +
                ", neighborhood='" + neighborhood + '\'' +
                ", person=" + person +
                '}';
    }
}
