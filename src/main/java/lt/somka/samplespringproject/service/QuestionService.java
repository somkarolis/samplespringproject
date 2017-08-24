package lt.somka.samplespringproject.service;

import lt.somka.samplespringproject.domain.AnswerType;
import lt.somka.samplespringproject.domain.Question;
import lt.somka.samplespringproject.service.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
public class QuestionService {

    private QuestionsRepository questionsRepository;
    private QuestionValueService questionValueService;

    @Autowired
    public QuestionService(QuestionsRepository questionsRepository, QuestionValueService questionValueService) {
        this.questionsRepository = questionsRepository;
        this.questionValueService = questionValueService;
    }

    @Transactional(readOnly = true)
    public List<Question> getAllQuestions() {
        return questionsRepository.findAll();
    }

    @Transactional
    public void createQuestion(String questionText, AnswerType questionType, List<String> questionValues) {
        Question question = new Question(questionText, questionType);
        questionsRepository.saveAndFlush(question);
        if (questionType.name().equals("INPUT") && questionValues.isEmpty()) {
            questionValues.add("");
        }
        questionValueService.createQuestionValue(questionValues, question.getId());
    }
}
