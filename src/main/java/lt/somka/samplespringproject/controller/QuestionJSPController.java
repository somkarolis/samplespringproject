package lt.somka.samplespringproject.controller;

import lt.somka.samplespringproject.controller.dto.SubmissionDTO;
import lt.somka.samplespringproject.domain.Question;
import lt.somka.samplespringproject.service.QuestionService;
import lt.somka.samplespringproject.service.SubmissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class QuestionJSPController {

    private QuestionService questionService;
    private SubmissionService submissionService;

    public QuestionJSPController(QuestionService questionService, SubmissionService submissionService) {
        this.questionService = questionService;
        this.submissionService = submissionService;
    }

    @RequestMapping(value = "/jsptest", method = GET)
    public String welcome(Map<String, Object> model) {
        model.put("message", "Labas VCS!");
        return "welcome";
    }

    @RequestMapping(value = "/quiztest", method = GET)
    public ModelAndView getQuizElements() {
        ModelAndView model = new ModelAndView("quiz");
        List<Question> questions = questionService.getAllQuestions();
        model.addObject("questions", questions);

        model.addObject("submission",
                SubmissionDTO.SubmissionDTOBuilder.aSubmissionDTO().
                withName("Vardenis").
                withSurname("Pavardenis").
                build()
                );

        return model;
    }

    @PostMapping(value = "/submit-quiz-answers")
    public ModelAndView solveQuiz(@ModelAttribute("submission")SubmissionDTO submissionDTO,
                                  BindingResult result, ModelMap model) {
        submissionService.createSubmission(submissionDTO.getName(), submissionDTO.getSurname(), submissionDTO.getAnswers());
        return new ModelAndView("quizEnd");
    }



}
