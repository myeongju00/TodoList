package com.todoList.controller;

import com.todoList.controller.annotation.Version1RestController;
import com.todoList.dto.TodoEntityDto;
import com.todoList.service.TodoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Version1RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todo/{id}")
    public TodoEntityDto getById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @GetMapping("/todos")
    public List<TodoEntityDto> getAllTodo() {
        return todoService.getTodoList();
    }

    @PutMapping("/todo/{id}")
    public Long update(@PathVariable Long id, @RequestBody TodoEntityDto requestDto) {
        return todoService.update(id, requestDto);
    }

    @ApiOperation(value = "TODO 등록",
        notes = "colorCount는 1, 2, 3 이 들어가야 합니다.")
    @PostMapping("/todo")
    public TodoEntityDto postTodo(@RequestBody TodoEntityDto requestDto) {
        return todoService.save(requestDto);
    }

    @DeleteMapping("/todo/{id}")
    public Long delete(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return id;
    }
}
