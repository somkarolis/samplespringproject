package lt.somka.samplespringproject.controller.dto;

public class AnswerDTO {
    private String input;
    private Integer questionValueID;

    public AnswerDTO(String input, Integer questionValueID) {
        this.input = input;
        this.questionValueID = questionValueID;
    }

    public AnswerDTO(String input) {
        this.questionValueID = Integer.parseInt(input);
    }

    public AnswerDTO(Integer questionValueID) {
        this.questionValueID = questionValueID;
    }

    public AnswerDTO() {
    }

    public String getInput() {
        return input;
    }

    public Integer getquestionValueID() {
        return questionValueID;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setQuestionValueID(Integer questionValueID) {
        this.questionValueID = questionValueID;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "input='" + input + '\'' +
                ", QuestionValueID=" + questionValueID +
                '}';
    }
}
