package lt.somka.samplespringproject.controller;

import lt.somka.samplespringproject.controller.dto.StatisticsDTO;
import lt.somka.samplespringproject.domain.Answer;
import lt.somka.samplespringproject.domain.Question;
import lt.somka.samplespringproject.domain.QuestionValue;
import lt.somka.samplespringproject.service.AnswerService;
import lt.somka.samplespringproject.service.QuestionService;
import lt.somka.samplespringproject.service.QuestionValueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StatisticsController {
    private AnswerService answerService;
    private QuestionService questionService;
    private QuestionValueService questionValueService;

    public StatisticsController(AnswerService answerService, QuestionService questionService, QuestionValueService questionValueService) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.questionValueService = questionValueService;
    }

    @GetMapping(value = "/get-statistics")
    public ModelAndView getQuizStatistics() {
        ModelAndView model = new ModelAndView("statistics");
        List<Question> questions = questionService.getAllQuestions();
        List<Answer> answers = answerService.getAllAnswers();
        List<QuestionValue> questionValues = questionValueService.getAllQuestionValues();
        StatisticsDTO statisticsDTO = new StatisticsDTO(questions, questionValues, answers);
        model.addObject("statistics", statisticsDTO);

//        model.addObject("questionValues", questionValues);
//        model.addObject("answers", answers);
//        model.addObject("questions", questions);


        return model;
    }


}
