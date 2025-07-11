package Project.OnlineExamSystem.service;
import Project.OnlineExamSystem.dtos.SubmissionDTO;
import Project.OnlineExamSystem.model.Question;
import Project.OnlineExamSystem.model.Result;
import Project.OnlineExamSystem.repository.QuestionRepository;
import Project.OnlineExamSystem.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final QuestionRepository questionRepository;
    //used to fetch question from database
    private final ResultRepository resultRepository;
    //used to store results in database

    public Result submitResult(SubmissionDTO submission) {
        //Get all questions for exam
        //Uses the questionRepository to find all questions for the given examId that the student submitted.
        List<Question> questions = questionRepository.findByExamId(submission.getExamId());

        // Count correct answers
        int correctCount = 0;
        for (Question question : questions) {
            String submittedAnswer = submission.getAnswers().get(question.getId());
            if (submittedAnswer != null && submittedAnswer.equalsIgnoreCase(question.getCorrectOption())) {
                correctCount++;
            }
        }

        //Calculate marks
        int totalQuestions = questions.size();
        int marksPerQuestion = 1;
        int totalMarks = totalQuestions * marksPerQuestion;
        int marksObtained = correctCount * marksPerQuestion;

        double percentage = ((double) marksObtained / totalMarks) * 100;

        //Grade
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 75) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 40) {
            grade = "C";
        } else {
            grade = "Fail";
        }

        // Save result
        Result result = new Result();
        result.setStudentId(submission.getStudentId());
        result.setExamId(submission.getExamId());
        result.setMarksObtained(marksObtained);
        result.setTotalMarks(totalMarks);
        result.setGrade(grade);

        return resultRepository.save(result);
    }
}