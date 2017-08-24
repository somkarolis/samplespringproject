package lt.somka.samplespringproject.service;

import lt.somka.samplespringproject.domain.QuestionValue;
import lt.somka.samplespringproject.service.repositories.QuestionValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class QuestionValueService {

    private QuestionValueRepository questionValueRepository;

    @Autowired
    public QuestionValueService(QuestionValueRepository questionValueRepository) {
        this.questionValueRepository = questionValueRepository;
    }

    @Transactional
    public void createQuestionValue(List<String> answerValues, Integer questionID) {
        for (String answerValue : answerValues) {
            QuestionValue questionValue = new QuestionValue(answerValue, questionID);
            questionValueRepository.save(questionValue);
        }
    }

    @Transactional(readOnly = true)
    public List<QuestionValue> getAllQuestionValues() {
        return questionValueRepository.findAll();
    }

}
