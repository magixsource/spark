package cn.linpeng.service.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.linpeng.model.tables.User;
import cn.linpeng.service.UserService;

@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private DSLContext context;

	@Override
	public Object findByAccountAndPassword(String account, String password) {
		return context.selectFrom(User.USER)
				.where(User.USER.ACCOUNT.eq(account))
				.and(User.USER.PASSWORD.eq(password)).fetchOne();
	}

	@Override
	public Object findByAccount(String account) {
		return context.selectFrom(User.USER)
				.where(User.USER.ACCOUNT.eq(account)).fetchOne();
	}

	@Override
	public Object findById(Long id) {
		return context.selectFrom(User.USER)
				.where(User.USER.ID.eq(id.intValue())).fetchOne();
	}

}
