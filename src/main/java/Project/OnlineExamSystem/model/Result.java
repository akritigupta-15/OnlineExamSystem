package Project.OnlineExamSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    // 👉 Which student submitted this result.

    private Long examId;
    // 👉 For which exam this result is.

    private Integer marksObtained;
    private Integer totalMarks;

    private String grade;
}

