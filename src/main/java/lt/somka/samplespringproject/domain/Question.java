package lt.somka.samplespringproject.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Questions")
public class Question implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "TEXT")
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private AnswerType type;

    @OneToMany(mappedBy = "questionID")
    private List<QuestionValue> questionValues;

    public Question(String text, AnswerType type) {
        this.text  = text;
        this.type = type;
    }

    public Question(String text, AnswerType type, List<QuestionValue> questionValues) {
        this.text  = text;
        this.type = type;
        this.questionValues = questionValues;
    }

    public Question() {
    }

    public List<QuestionValue> getQuestionValues() {
        return questionValues;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public AnswerType getType() {
        return type;
    }

}
