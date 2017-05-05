package cn.linpeng.service;

public interface UserService {
	public Object findByAccountAndPassword(String account, String password);

	public Object findByAccount(String account);

	public Object findById(Long id);
}
