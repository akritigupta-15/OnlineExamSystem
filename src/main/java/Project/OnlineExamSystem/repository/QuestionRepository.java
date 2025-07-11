package Project.OnlineExamSystem.repository;

import Project.OnlineExamSystem.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
     List<Question> findByExamId(Long examId);
    // 👉 Custom method: get all questions linked to a specific exam
}

