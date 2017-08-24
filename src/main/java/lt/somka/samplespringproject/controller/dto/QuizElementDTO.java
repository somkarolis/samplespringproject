package lt.somka.samplespringproject.controller.dto;

import java.util.List;

public class QuizElementDTO {
    private String question;
    private List<String> answers;

    public QuizElementDTO(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
