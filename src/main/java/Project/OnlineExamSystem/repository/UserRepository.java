package Project.OnlineExamSystem.repository;

import Project.OnlineExamSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByUsername(String username);
    //findByUsername is custom — needed to check if a user exists (during register + login).
}
