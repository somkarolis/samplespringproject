package lt.somka.samplespringproject.controller.dto;

import java.util.List;

public class UserDTO {
    private String name;
    private String surname;
    private String gender;
    private List<String> possibleGenders;

    public UserDTO(String name, String surname, String gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getPossibleGenders() {
        return possibleGenders;
    }

    public void setPossibleGenders(List<String> possibleGenders) {
        this.possibleGenders = possibleGenders;
    }
}
