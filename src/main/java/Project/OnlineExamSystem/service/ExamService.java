package Project.OnlineExamSystem.service;

import Project.OnlineExamSystem.model.Exam;
import Project.OnlineExamSystem.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public Exam saveExam(Exam exam)
    {
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams()
    {
        return examRepository.findAll();
    }

    public  Exam getExamById(Long id)
    {
        return examRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found!"));
    }

    public void deleteExam(Long id)
    {
        examRepository.deleteById(id);
    }
}
