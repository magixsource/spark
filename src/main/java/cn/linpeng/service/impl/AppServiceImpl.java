package cn.linpeng.service.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.linpeng.model.tables.App;
import cn.linpeng.service.AppService;

@Repository
public class AppServiceImpl implements AppService {
	@Autowired
	private DSLContext context;

	@Override
	public Object findByDomain(String domain) {
		return context.select().from(App.APP).where(App.APP.DOMAIN.eq(domain))
				.fetchOne();
	}

}
