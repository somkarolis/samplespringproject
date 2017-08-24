package lt.somka.samplespringproject.controller;


import lt.somka.samplespringproject.controller.dto.QuizElementDTO;
import lt.somka.samplespringproject.domain.QuestionValue;
import lt.somka.samplespringproject.domain.Question;
import lt.somka.samplespringproject.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {

    private QuestionService questionService;

    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<QuizElementDTO> getAllQuizElements() {
        List<QuizElementDTO> quizElements = new ArrayList<>();

        for (Question question: questionService.getAllQuestions()) {
            List<String> answerTexts = new ArrayList<>();
            for (QuestionValue questionValue : question.getQuestionValues()) {
                answerTexts.add(questionValue.getText());
            }
            quizElements.add(new QuizElementDTO(question.getText(), answerTexts));
        }

        return quizElements;
    }

}
