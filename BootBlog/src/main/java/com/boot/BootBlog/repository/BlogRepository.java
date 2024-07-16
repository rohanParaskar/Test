package com.boot.BootBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.boot.BootBlog.enity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
	public List<Blog> findByTitle(String title);
	public List<Blog> findByAuthor(String author);
}
