package lt.somka.samplespringproject.controller.dto;

import lt.somka.samplespringproject.domain.AnswerType;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {
    private String text;
    private AnswerType type;
    private List<QuestionValueDTO> dtos;

    public QuestionDTO(String text, AnswerType type, List<QuestionValueDTO> dtos) {
        this.text = text;
        this.type = type;
        this.dtos = dtos;
    }

    public QuestionDTO() {
        this.dtos = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public AnswerType getType() {
        return type;
    }

    public List<QuestionValueDTO> getDtos() {
        return dtos;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(AnswerType type) {
        this.type = type;
    }

    public void setDtos(List<QuestionValueDTO> dtos) {
        this.dtos = dtos;
    }

    public List<String> getQuestionValues() {
        List<String> questionValues = new ArrayList<>();
        for (QuestionValueDTO questionValueDTO : dtos) {
            if (questionValueDTO.getText().equals("") || type.equals("INPUT")) {
            } else {
                questionValues.add(questionValueDTO.getText());
            }
        }
        return questionValues;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "text='" + text + '\'' +
                ", type=" + type +
                ", dtos=" + dtos +
                '}';
    }
}
