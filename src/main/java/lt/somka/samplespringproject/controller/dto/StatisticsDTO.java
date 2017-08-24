package lt.somka.samplespringproject.controller.dto;


import lt.somka.samplespringproject.domain.Answer;
import lt.somka.samplespringproject.domain.Question;
import lt.somka.samplespringproject.domain.QuestionValue;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsDTO {
    private List<Question> questions;
    private List<QuestionValue> questionValues;
    private List<Answer> answers;
    private Map<String, Map<String, Integer>> statistics = new HashMap<>();

    public StatisticsDTO(List<Question> questions, List<QuestionValue> questionValues, List<Answer> answers) {
        this.questions = questions;
        this.questionValues = questionValues;
        this.answers = answers;
        this.statistics = calculateStatistics();
    }

    public StatisticsDTO() {
    }


    //todo move calculations to services
    private Map<String, Map<String, Integer>> calculateStatistics() {
        Map<String, Map<String, Integer>> statistics = new HashMap<>();
        Integer count = 0;
        for (Question question : questions) {
            Map<String, Integer> answersCount = new HashMap<>();
            if (question.getType().name().equals("INPUT")) {
                for (QuestionValue questionValue : questionValues) {
                    if (question.getId() == questionValue.getQuestionID()) {
                        for (Answer answer : answers) {
                            if (answer.getqValueID() == questionValue.getId()) {
                                answersCount.put(answer.getInput(), null);
                            }
                        }
                        statistics.put(question.getText(), answersCount);
                    }
                }
            } else {
                for (QuestionValue questionValue : questionValues) {
                    if (question.getId() == questionValue.getQuestionID()) {
                        for (Answer answer : answers) {
                            if (answer.getqValueID() == questionValue.getId()) {
                                count++;
                            }
                        }
                        answersCount.put(questionValue.getText(), count);
                        statistics.put(question.getText(), answersCount);
                        count = 0;
                    }
                }
            }
        }

        return statistics;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<QuestionValue> getQuestionValues() {
        return questionValues;
    }

    public void setQuestionValues(List<QuestionValue> questionValues) {
        this.questionValues = questionValues;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Map<String, Map<String, Integer>> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<String, Map<String, Integer>> statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "StatisticsDTO{" +
                "questions=" + questions +
                ", questionValues=" + questionValues +
                ", answers=" + answers +
                ", statistics=" + statistics +
                '}';
    }
}
