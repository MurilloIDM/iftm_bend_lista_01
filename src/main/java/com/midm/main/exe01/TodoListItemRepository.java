package com.midm.main.exe01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListItemRepository extends JpaRepository<TodoListItem, Integer> {}
