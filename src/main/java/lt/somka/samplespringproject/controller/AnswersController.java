package lt.somka.samplespringproject.controller;

import lt.somka.samplespringproject.controller.dto.SubmissionDTO;
import lt.somka.samplespringproject.service.AnswerService;
import lt.somka.samplespringproject.service.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/answer")
public class AnswersController {

    private SubmissionService submissionService;

    public AnswersController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createAnswer(@RequestBody SubmissionDTO submissionDTO) {
        submissionService.createSubmission(submissionDTO.getName(), submissionDTO.getSurname(), submissionDTO.getAnswers());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /*
    {
        "name": "Karolis",
            "surname": "Somka",
            "answerDTOs": [
        {
            "input": "Taip"
        },
        {
            "questionValueID": "4"
        },
        {
            "questionValueID": "2"
        }
    ]
    }
    */
}
