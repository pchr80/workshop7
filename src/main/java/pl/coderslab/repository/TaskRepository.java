package pl.coderslab.repository;

// import jdk.javadoc.internal.doclets.formats.html.markup.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findFirstById(Long id);
    List<Task> findByUser(User user);
    List<Task> findAllByProject_IdAndUser(Long projectId, User user);
    List<Task> findAllByProject_Id(Long projectId);
}
