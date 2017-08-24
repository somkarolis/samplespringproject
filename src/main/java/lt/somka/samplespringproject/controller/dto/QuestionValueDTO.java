package lt.somka.samplespringproject.controller.dto;

public class QuestionValueDTO {
    private String text;

    public QuestionValueDTO(String text) {
        this.text = text;
    }

    public QuestionValueDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "QuestionValueDTO{" +
                "text='" + text + '\'' +
                '}';
    }
}
