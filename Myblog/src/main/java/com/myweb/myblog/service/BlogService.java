package com.myweb.myblog.service;

import java.util.List;

import com.myweb.myblog.model.Blog;
public interface BlogService {
	public void addBlog(Blog b);
	public List<Blog> listBlogs();
	public Blog getBlogById(int blogId);
	public void removeBlog(int blogId);
}
