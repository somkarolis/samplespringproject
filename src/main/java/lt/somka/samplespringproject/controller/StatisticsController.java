package lt.somka.samplespringproject.controller;

import lt.somka.samplespringproject.controller.dto.StatisticsDTO;
import lt.somka.samplespringproject.domain.Answer;
import lt.somka.samplespringproject.domain.Question;
import lt.somka.samplespringproject.domain.QuestionValue;
import lt.somka.samplespringproject.service.AnswerService;
import lt.somka.samplespringproject.service.QuestionService;
import lt.somka.samplespringproject.service.QuestionValueService;
import lt.somka.samplespringproject.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StatisticsController {
    private AnswerService answerService;
    private QuestionService questionService;
    private QuestionValueService questionValueService;
    private StatisticsService statisticsService;

    public StatisticsController(AnswerService answerService,
                                QuestionService questionService,
                                QuestionValueService questionValueService,
                                StatisticsService statisticsService) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.questionValueService = questionValueService;
        this.statisticsService = statisticsService;
    }

    @GetMapping(value = "/get-statistics")
    public ModelAndView getQuizStatistics() {
        ModelAndView model = new ModelAndView("statistics");
        StatisticsDTO statisticsDTO = new StatisticsDTO(
                questionService.getAllQuestions(),
                questionValueService.getAllQuestionValues(),
                answerService.getAllAnswers(),
                statisticsService.calculateStatistics()
                );
        model.addObject("statistics", statisticsDTO);

//        model.addObject("questionValues", questionValues);
//        model.addObject("answers", answers);
//        model.addObject("questions", questions);


        return model;
    }


}
