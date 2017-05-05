package cn.linpeng.service.impl;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.linpeng.model.tables.App;
import cn.linpeng.model.tables.Category;
import cn.linpeng.model.tables.records.CategoryRecord;
import cn.linpeng.service.CategoryService;

@Repository
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private DSLContext context;

	@Override
	public List<Object> findByDomain(String domain) {
		return context.select().from(Category.CATEGORY).join(App.APP)
				.on(App.APP.ID.eq(Category.CATEGORY.APP_ID))
				.where(App.APP.DOMAIN.eq(domain))
				.fetchInto(CategoryRecord.class);
	}

}
