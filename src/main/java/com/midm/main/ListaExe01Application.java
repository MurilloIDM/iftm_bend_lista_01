package com.midm.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.midm.main.exe01.TodoList;
import com.midm.main.exe01.TodoListItem;
import com.midm.main.exe01.TodoListItemRepository;
import com.midm.main.exe01.TodoListRepository;

@SpringBootApplication
public class ListaExe01Application implements CommandLineRunner {
	
	@Autowired
	TodoListItemRepository todoListItemRepo;
	
	@Autowired
	TodoListRepository todoListRepo;

	public static void main(String[] args) {
		SpringApplication.run(ListaExe01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Exercício 1
		TodoList todoList = new TodoList("Lista de BEND");
		
		TodoListItem itemOne = new TodoListItem("Caminhar", todoList);
		TodoListItem itemTwo = new TodoListItem("Estudar", todoList);
		
		todoList.getItems().add(itemOne);
		todoList.getItems().add(itemTwo);
		
		todoListRepo.save(todoList);
		todoListItemRepo.save(itemOne);
		todoListItemRepo.save(itemTwo);
		
	}

}
