package pe.com.anthony.todoList.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pe.com.anthony.todoList.model.Tasks;

import java.util.List;

@Repository
public interface TaskRepository {
    public int insert(@Param("Tasks")Tasks task);
    public List<Tasks> getAll();
    public int delete(@Param("id")Long id);
    public Tasks getId(@Param("id")Long id);
    public void update(@Param("Tasks")Tasks task);
}
