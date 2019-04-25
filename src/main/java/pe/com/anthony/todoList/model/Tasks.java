package pe.com.anthony.todoList.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Tasks {
    private Long taskId;
    private String nombre;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date fechaInicio;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date fechaFin;
}
