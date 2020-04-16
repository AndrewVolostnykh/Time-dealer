package own.hades.timedealer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String acceptance_criteria;
    private String status;

    @NotBlank(message = "Summary cannot be blank")
    private String summary;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User taskOwner;

    public Task(){}

    public Task(String acceptance_criteria, String summary, String status, User user)
    {
        this.acceptance_criteria = acceptance_criteria;
        this.summary = summary;
        this.status = status;
        this.taskOwner = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcceptance_criteria() {
        return acceptance_criteria;
    }

    public void setAcceptance_criteria(String acceptance_criteria) {
        this.acceptance_criteria = acceptance_criteria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public User getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(User taskOwner) {
        this.taskOwner = taskOwner;
    }
}
