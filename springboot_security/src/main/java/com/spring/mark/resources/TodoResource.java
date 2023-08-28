package com.spring.mark.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> TODOS_LIST = List.of(new Todo("mark", "Learn AWS"), new Todo("mark", "Get AWS Certified"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodo() {
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        // CSRF 설정 전에 POST,PUT 등의 요청은 401 에러. 로깅이 안남음!!
        logger.info("Create {} for {}", todo, username);
    }
}

record Todo(String username, String description) {}