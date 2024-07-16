package com.boot.BootBlog.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.BootBlog.enity.Blog;
import com.boot.BootBlog.service.BlogService;

@RestController
public class BlogController {
	@Autowired
	BlogService service;

	@PostMapping("/create")
	public ResponseEntity<String> saveBlog(@RequestBody Blog b) {
		b.setAddedDate(LocalDateTime.now());
		b.setUpdatedDate(LocalDateTime.now());
		service.saveBlog(b);
		return ResponseEntity.ok("Blog added");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateBlog(@PathVariable int id, @RequestBody Blog b) {
		service.updateBlog(b, id);
		return ResponseEntity.ok("Blog updated");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBlog(@PathVariable int id) {
		service.deleteBlog(id);
		return ResponseEntity.ok("Blog deleted");
	}

	@GetMapping("/getblog/{id}")
	public ResponseEntity<Blog> getBlog(@PathVariable int id) {
		Blog blog = service.getBlog(id);
		return ResponseEntity.ok().body(blog);
	}

	@GetMapping("/getall")
	public List<Blog> getAllBlogs(
			@RequestParam(value = "pagenumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pagesize", defaultValue = "10", required = false) int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return service.getAllBlogs(pageNumber, pageSize);
	}

}
//	@GetMapping("/getall/{author}")   	//custom search query
//	public ResponseEntity<List<Blog>> getAllBlogs(@PathVariable String author) {
////		List<Blog> allBlogs=service.getBytitle(title);
//		List<Blog> allBlogs=service.getByAuthor(author);
//		
//		return ResponseEntity.ok().body(allBlogs);
//	}
