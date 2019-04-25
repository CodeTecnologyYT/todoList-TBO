package pe.com.anthony.todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.anthony.todoList.model.Tasks;
import pe.com.anthony.todoList.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void save(Tasks task){
        taskRepository.insert(task);
    }
    public List<Tasks> getAll(){
        return taskRepository.getAll();
    }
    public void delete(Long id){ taskRepository.delete(id);}

    public Tasks getId(Long id){ return taskRepository.getId(id);}

    public void update(Tasks task){taskRepository.update(task);}



}
