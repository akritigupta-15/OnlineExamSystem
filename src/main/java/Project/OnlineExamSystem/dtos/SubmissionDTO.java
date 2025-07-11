package Project.OnlineExamSystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SubmissionDTO {
    private Long studentId;
    private Long examId;
    private Map<Long, String> answers; // questionId -> selectedOption
    //Which option they picked for each question.
}
