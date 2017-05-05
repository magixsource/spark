package cn.linpeng.service;

import java.util.List;

public interface PostService {

	public Object findById(Long id);

	public List<Object> findAll(String account);
}
