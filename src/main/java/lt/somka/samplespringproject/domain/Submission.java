package lt.somka.samplespringproject.domain;

import javax.persistence.*;

@Entity
@Table(name = "submissions")
public class Submission {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    public Submission(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Submission() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}


