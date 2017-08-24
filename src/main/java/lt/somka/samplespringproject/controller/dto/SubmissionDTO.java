package lt.somka.samplespringproject.controller.dto;

import lt.somka.samplespringproject.domain.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubmissionDTO {
    private String name;
    private String surname;
    private List<AnswerDTO> answerDTOs;
    private Map<Integer, String> inputs;

    public SubmissionDTO() {
        answerDTOs = new ArrayList<AnswerDTO>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<AnswerDTO> getAnswerDTOs() {
        return answerDTOs;
    }

    //todo create static method in AnswerDTO
    public List<Answer> getAnswers() {
        List<Answer> answers = new ArrayList<>();
        for (AnswerDTO answerDTO : answerDTOs) {
            answers.add(new Answer(answerDTO.getInput(), answerDTO.getquestionValueID()));
        }
        inputs.forEach((key, value) -> answers.add(new Answer(value, key)));
        return answers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAnswerDTOs(List<AnswerDTO> answerDTOs) {
        this.answerDTOs = answerDTOs;
    }

    public Map<Integer, String> getInputs() {
        return inputs;
    }

    public void setInputs(Map<Integer, String> inputs) {
        this.inputs = inputs;
    }

    @Override
    public String toString() {
        return "SubmissionDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", answerDTOs=" + answerDTOs +
                '}';
    }


    public static final class SubmissionDTOBuilder {
        private String name;
        private String surname;
        private List<String> possibleGenders;

        private SubmissionDTOBuilder() {
        }

        public static SubmissionDTOBuilder aSubmissionDTO() {
            return new SubmissionDTOBuilder();
        }

        public SubmissionDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SubmissionDTOBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }


        public SubmissionDTO build() {
            SubmissionDTO submissionDTO = new SubmissionDTO();
            submissionDTO.setName(name);
            submissionDTO.setSurname(surname);
            return submissionDTO;
        }
    }
}
