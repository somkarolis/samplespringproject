package lt.somka.samplespringproject.domain;

import javax.persistence.*;

@Entity
@Table(name = "question_values")
public class QuestionValue {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "QUESTION_ID")
    private Integer questionID;

    public QuestionValue(String text, Integer questionID) {
        this.text = text;
        this.questionID = questionID;
    }

    public QuestionValue(String text) {
        this.text = text;
    }

    public QuestionValue() {
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getQuestionID() {
        return questionID;
    }
}
