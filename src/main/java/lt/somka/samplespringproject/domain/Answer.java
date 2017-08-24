package lt.somka.samplespringproject.domain;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "INPUT")
    private String input;

    @Column(name = "SUBMISSION_ID")
    private Integer submissionID;

    @Column(name = "QVALUE_ID")
    private Integer qValueID;

    public Answer(String input, Integer qValueID, Integer submissionID) {
        this.input = input;
        this.submissionID = submissionID;
        this.qValueID = qValueID;
    }

    public Answer(String input, Integer qValueID) {
        this.input = input;
        this.qValueID = qValueID;
    }

    public Answer(String input) {
        this.input = input;
    }

    public Answer(Integer qValueID) {
        this.qValueID = qValueID;
    }

    public Answer() {
    }

    public Integer getId() {
        return id;
    }

    public String getInput() {
        return input;
    }

    public Integer getSubmissionID() {
        return submissionID;
    }

    public Integer getqValueID() {
        return qValueID;
    }

}
