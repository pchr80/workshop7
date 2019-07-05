package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import java.time.LocalDate;
//import java.time.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "date_created")
    private Date dateCreated = new Date();
    @NotBlank
    @Size(max=100)
    @Column(name = "name")
    private String name;
    @Size(max=160)
    @Column(name = "description")
    private String description;
    @URL
    @Column(name = "url")
    private String url;
    @Size(max=100)
    @Column(name = "identifier")
    private String identifier;
    @Column(name = "active")
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "project")
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        char [] tab = name.toCharArray();
        for (int i=0; i<tab.length; i++) {
            if (Character.isWhitespace(tab[i])) {
                tab[i] = '-';
            }
        }
        String temp = String.valueOf(tab);
        this.identifier = temp.replace('ą', 'a').replace('ć', 'c').replace('ę', 'e').replace
                ('ł', 'l').replace('ń', 'n').replace('ó','o');
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
