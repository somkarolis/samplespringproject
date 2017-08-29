package lt.somka.samplespringproject.service;

import lt.somka.samplespringproject.domain.Answer;
import lt.somka.samplespringproject.domain.Question;
import lt.somka.samplespringproject.domain.QuestionValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StatisticsService {
    private AnswerService answerService;
    private QuestionService questionService;
    private QuestionValueService questionValueService;

    @Autowired
    public StatisticsService(AnswerService answerService, QuestionService questionService, QuestionValueService questionValueService) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.questionValueService = questionValueService;
    }

    public Map<String, Map<String, Integer>> calculateStatistics() {
        List<Answer> answers = answerService.getAllAnswers();
        List<Question> questions = questionService.getAllQuestions();
        List<QuestionValue> questionValues = questionValueService.getAllQuestionValues();
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
}
