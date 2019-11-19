package mx.neftaly.todoist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean completed;

    @ManyToOne
    private TodoSet todoSet;
}
