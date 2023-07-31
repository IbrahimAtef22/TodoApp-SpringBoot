package org.jobhacker.springboot.app.service;

import org.jobhacker.springboot.app.entity.Todo;
import org.jobhacker.springboot.app.repository.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class TodoServiceImplTest {

    @Mock
    private TodoRepository todoRepository;
    private TodoService todoService;
    AutoCloseable autoCloseable;
    Todo todo;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        todoService = new TodoServiceImpl(todoRepository);
        todo = new Todo(5, "fifth task", "this is my fifth task");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testCreateTodo() {
        mock(Todo.class);
        mock(TodoRepository.class);

        when(todoRepository.save(todo)).thenReturn(todo);
        assertThat(todoService.createTodo(todo)).isEqualTo(todo);
    }

    @Test
    void testGetAllTodos() {
        mock(Todo.class);
        mock(TodoRepository.class);

        when(todoRepository.findAll()).thenReturn(new ArrayList<>(Collections.singleton(todo)));
        assertThat(todoService.getAllTodos().get(0).getTitle()).isEqualTo(todo.getTitle());
    }

    @Test
    void testGetTodo() {
        mock(Todo.class);
        mock(TodoRepository.class);

        when(todoRepository.findById(1)).thenReturn(Optional.ofNullable(todo));
        assertThat(todoService.getTodo(1)).isEqualTo(todo);
    }

    @Test
    void testEditTodo() {
        mock(Todo.class);
        mock(TodoRepository.class);

        when(todoRepository.save(todo)).thenReturn(todo);
    }

    @Test
    void testDeleteTodo() {
        mock(Todo.class);
        mock(TodoRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(todoRepository).deleteById(any());
    }
}