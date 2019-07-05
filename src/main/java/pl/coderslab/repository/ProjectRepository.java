package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.User;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findFirstById(Long id);
    List<Project> findByUsersContains(User user);
    List<Project> findFirst5ByOrderByDateCreatedDesc();
    List<Project> findFirst5ByUsersContainsOrderByDateCreatedDesc(User user);
}
