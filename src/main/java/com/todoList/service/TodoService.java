package com.todoList.service;

import com.todoList.domain.entity.TodoEntity;
import com.todoList.domain.repository.TodoRepository;
import com.todoList.dto.TodoEntityDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoEntityDto getTodoById(Long id) {
        TodoEntity entity = todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 글이 없습니다. id = " + id));
        return new TodoEntityDto(entity);
    }
    public List<TodoEntityDto> getTodoList() {
        return todoRepository.findAll().stream()
                .map(TodoEntityDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public Long update(Long id, TodoEntityDto requestDto) {
        TodoEntity entity = todoRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        entity.update(requestDto.getTitle(), requestDto.getContent(),
                requestDto.getImageURl(), requestDto.getProgressCount(), requestDto.getColorCount());

        return id;
    }

    @Transactional
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    @Transactional
    public TodoEntityDto save(TodoEntityDto todoEntityDto) {
        TodoEntity entity =  todoRepository.save(todoEntityDto.toEntity());
        return new TodoEntityDto(entity);
    }
}
