package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Activity;
import pl.coderslab.entity.Priority;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.User;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findFirstById(Long id);
    List<Activity> findFirst25ByOrderByActDateDesc();
    List<Activity> findFirst25ByUserOrderByActDateDesc(User user);
}
