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

    public StatisticsDTO(List<Question> questions, List<QuestionValue> questionValues, List<Answer> answers, Map<String, Map<String, Integer>> statistics) {
        this.questions = questions;
        this.questionValues = questionValues;
        this.answers = answers;
        this.statistics = statistics;
    }

    public StatisticsDTO() {
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
