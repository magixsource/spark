package cn.linpeng.service;

public interface ThemeService {
	public Object findById(Long id);
	
	public Object findByAppId(Long id);
	
	public Object findByAppDomain(String domain);
	
}
