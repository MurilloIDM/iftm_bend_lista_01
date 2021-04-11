package com.midm.main.exe01;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListItemRepository extends JpaRepository<TodoListItem, Integer> {}
