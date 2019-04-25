package pe.com.anthony.todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.anthony.todoList.model.Tasks;
import pe.com.anthony.todoList.service.TaskService;

@Controller
public class TodoListController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/")
    public String index(Model model){
        model.addAttribute("task",new Tasks());
        model.addAttribute("listaTask",taskService.getAll());
        return "index";
    }
    @PostMapping(value="/task/create")
    public String agregarTask(@ModelAttribute("task") Tasks tasks,Model model){
        System.out.println(tasks.toString());
        taskService.save(tasks);
        return "redirect:/";
    }


    @GetMapping(value="/task/delete/{id}")
    public String deleteTask(@PathVariable(name = "id") Long id){
        taskService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value="/task/get/{id}")
    public String getIdTask(@PathVariable(name="id")Long id,Model model){
        model.addAttribute("task",taskService.getId(id));
        model.addAttribute("metodo","update");
        return "task/modales::modal";
    }

    @GetMapping(value="/task/new")
    public String createTask(Model model){
        model.addAttribute("task",new Tasks());
        model.addAttribute("metodo","create");
        return "task/modales::modal";
    }
    @PostMapping(value="/task/update")
    public String updateTask(@ModelAttribute("task") Tasks tasks,Model model){
        taskService.update(tasks);
        return "redirect:/";
    }

}
