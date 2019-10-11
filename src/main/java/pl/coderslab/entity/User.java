package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.validation.UserRegisterValidationGroup;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = UserRegisterValidationGroup.class)
    @Column(name = "login", unique = true)
    private String login;

    @NotBlank(groups = UserRegisterValidationGroup.class)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(groups = UserRegisterValidationGroup.class)
    @Column(name = "last_name")
    String lastName;

    @NotBlank(groups = UserRegisterValidationGroup.class)
    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Project> projects = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return login;
    }
}
