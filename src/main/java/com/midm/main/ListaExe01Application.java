package com.midm.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.midm.main.exe01.TodoList;
import com.midm.main.exe01.TodoListItem;
import com.midm.main.exe01.TodoListItemRepository;
import com.midm.main.exe01.TodoListRepository;
import com.midm.main.exe02.Book;
import com.midm.main.exe02.BookRepository;
import com.midm.main.exe02.Library;
import com.midm.main.exe02.LibraryRepository;
import com.midm.main.exe03.Post;
import com.midm.main.exe03.PostComment;
import com.midm.main.exe03.PostCommentRepository;
import com.midm.main.exe03.PostRepository;

@SpringBootApplication
public class ListaExe01Application implements CommandLineRunner {
	
	@Autowired
	TodoListItemRepository todoListItemRepo;
	
	@Autowired
	TodoListRepository todoListRepo;
	
	@Autowired
	LibraryRepository libraryRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	PostCommentRepository postCommentRepo;

	public static void main(String[] args) {
		SpringApplication.run(ListaExe01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Exercício 1 --------------------------------------------------------------
		TodoList todoList = new TodoList("Lista de BEND");
		
		TodoListItem itemOne = new TodoListItem("Caminhar", todoList);
		TodoListItem itemTwo = new TodoListItem("Estudar", todoList);
		
		todoList.getItems().add(itemOne);
		todoList.getItems().add(itemTwo);
		
		todoListRepo.save(todoList);
		todoListItemRepo.save(itemOne);
		todoListItemRepo.save(itemTwo);
		
		// Exercício 2 --------------------------------------------------------------
		Library library = new Library("Biblioteca Tolkien");
		
		Book bookOne = new Book("O Hobbit", library);
		Book bookTwo = new Book("O Silmarillion", library);
		
		libraryRepo.save(library);
		bookRepo.save(bookOne);
		bookRepo.save(bookTwo);
		
		// Exercício 3 --------------------------------------------------------------
		Post newPost = new Post("Aprenda o Estoicismo já!");
		
		PostComment commentOne = new PostComment("Super necessário!", newPost);
		PostComment commentTwo = new PostComment("Caramba, Marco Aurélio deixou uma baita obra!", newPost);
		
		newPost.addComment(commentOne);
		newPost.addComment(commentTwo);
		
		newPost.removeComment(commentOne);
		
		postRepo.save(newPost);
		postCommentRepo.save(commentOne);
		postCommentRepo.save(commentTwo);
	}

}
