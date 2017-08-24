package lt.somka.samplespringproject.controller;

import lt.somka.samplespringproject.controller.dto.QuestionDTO;
import lt.somka.samplespringproject.domain.AnswerType;
import lt.somka.samplespringproject.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class QuestionsController {

    private QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/question", method = GET)
    public ModelAndView getQuestionElements() {
        ModelAndView model = new ModelAndView("createQuestion");
        QuestionDTO questionDTO = new QuestionDTO();
        model.addObject("question", questionDTO);
        model.addObject("questionTypes", Arrays.asList(AnswerType.values()));
        return model;
    }

    @PostMapping(value = "/create-new-question")
    public ModelAndView createQuestion(@ModelAttribute("question")QuestionDTO questionDTO,
                                  BindingResult result, ModelMap model) {
        questionService.createQuestion(questionDTO.getText(), questionDTO.getType(), questionDTO.getQuestionValues());
        return new ModelAndView("questionWasAdded");
    }

    /*
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createQuestion(@RequestBody QuestionDTO questionDTO) {
        questionService.createQuestion(questionDTO.getText(), questionDTO.getType(), questionDTO.getQuestionValues());
        return ResponseEntity.ok(HttpStatus.OK);
    }
    */

}
