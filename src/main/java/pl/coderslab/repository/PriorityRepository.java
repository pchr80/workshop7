package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Priority;
import pl.coderslab.entity.Status;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
    Priority findFirstById(Long id);
    List<Priority> findByActive(Boolean active);
}
