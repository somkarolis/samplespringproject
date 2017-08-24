package lt.somka.samplespringproject.service;

import lt.somka.samplespringproject.domain.Answer;
import lt.somka.samplespringproject.domain.Submission;
import lt.somka.samplespringproject.service.repositories.AnswersRepository;
import lt.somka.samplespringproject.service.repositories.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SubmissionService {
    private SubmissionRepository submissionRepository;
    private AnswerService answerService;

    @Autowired
    public SubmissionService(SubmissionRepository submissionRepository, AnswerService answerService) {
        this.submissionRepository = submissionRepository;
        this.answerService = answerService;
    }

    @Transactional
    public void createSubmission(String name, String surname, List<Answer> answers) {
        Submission submission = new Submission(name, surname);
        submissionRepository.saveAndFlush(submission);
        answerService.createAnswer(answers, submission.getId());
    }
}
