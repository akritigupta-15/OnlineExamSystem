package Project.OnlineExamSystem.controller;

import Project.OnlineExamSystem.dtos.SubmissionDTO;
import Project.OnlineExamSystem.model.Result;
import Project.OnlineExamSystem.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @PostMapping("/submit")
    public Result submitResult(@RequestBody SubmissionDTO submission) {
        //Controller only passes request to service
        return resultService.submitResult(submission);
    }
}
