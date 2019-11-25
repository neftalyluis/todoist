package mx.neftaly.todoist.params;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TodoSetParams {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
}
