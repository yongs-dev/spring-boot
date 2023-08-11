package com.springboot.mark.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private final TodoRepository todoRepository;


    public TodoControllerJpa(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private String getLoggedInUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        modelMap.put("todos", todoRepository.findByUsername(getLoggedInUsername()));
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap) {
        Todo todo = new Todo(0, getLoggedInUsername(), "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUsername(getLoggedInUsername());
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam long id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam long id, ModelMap modelMap) {
        modelMap.addAttribute("todo", todoRepository.findById(id).orElseThrow(IllegalArgumentException::new));
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTpdp(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUsername(getLoggedInUsername());
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
}
