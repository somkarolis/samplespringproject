package lt.somka.samplespringproject.service;

import lt.somka.samplespringproject.domain.Answer;
import lt.somka.samplespringproject.service.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AnswerService {
    private AnswersRepository answersRepository;

    @Autowired
    public AnswerService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Transactional
    public void createAnswer(List<Answer> answers, Integer submissionID) {
        for (Answer answerValue : answers) {
            Answer answer = new Answer(answerValue.getInput(), answerValue.getqValueID(), submissionID);
            answersRepository.save(answer);
        }
    }

    @Transactional(readOnly = true)
    public List<Answer> getAllAnswers() {
        return answersRepository.findAll();
    }
}
