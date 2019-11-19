package mx.neftaly.todoist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TodoSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "todoSet")
    private List<Task> tasks;
}
