package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.Status;
import pl.coderslab.entity.User;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findFirstById(Long id);
    List<Status> findByActive(Boolean active);
}