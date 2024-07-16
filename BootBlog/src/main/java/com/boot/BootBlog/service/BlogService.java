package com.boot.BootBlog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.BootBlog.enity.Blog;
import com.boot.BootBlog.repository.BlogRepository;

@Service
public class BlogService {
	@Autowired
	BlogRepository repo;

	public void saveBlog(Blog b) {
		repo.save(b);
	}
	public Blog updateBlog(Blog b, int id) {
		Blog bb = repo.findById(id).get();
		bb.setTitle(b.getTitle());
		bb.setAuthor(b.getAuthor());
		bb.setDescription(b.getDescription());
		bb.setUpdatedDate(LocalDateTime.now());
		Blog updatedBlog = repo.save(bb);
		return updatedBlog;
	}
	public void deleteBlog(int id) {
		repo.deleteById(id);
	}
	public Blog getBlog(int id) {
		return repo.findById(id).get();
	}
	public List<Blog> getBytitle(String title) {
		return repo.findByTitle(title);
	}
	public List<Blog> getByAuthor(String author) {
		return repo.findByAuthor(author);
	}
	public List<Blog> getAllBlogs(int pagenumber, int pagesize) {
		Pageable p = PageRequest.of(pagenumber, pagesize);
		Page<Blog> pageOfBlog = repo.findAll(p);
		return pageOfBlog.getContent();
	}

	
	
}
