package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByLogin(String login);
    User findFirstById(Long id);
    List<User> findAllByProjects(Project project);
}
