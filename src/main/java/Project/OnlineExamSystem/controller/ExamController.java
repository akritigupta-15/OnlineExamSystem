package Project.OnlineExamSystem.controller;

import Project.OnlineExamSystem.model.Exam;
import Project.OnlineExamSystem.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping("/create")
    public Exam createExam(@RequestBody Exam exam)
    {
        return examService.saveExam(exam);
    }

    @GetMapping("/all")
    public List<Exam> getAll()
    {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exam getById(@PathVariable Long id)
    {
        return examService.getExamById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return "Exam deleted successfully!";
    }
}
