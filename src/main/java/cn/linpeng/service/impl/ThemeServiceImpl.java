package cn.linpeng.service.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.linpeng.model.tables.App;
import cn.linpeng.model.tables.Theme;
import cn.linpeng.model.tables.records.ThemeRecord;
import cn.linpeng.service.ThemeService;

@Repository
public class ThemeServiceImpl implements ThemeService {
	@Autowired
	private DSLContext context;

	@Override
	public Object findById(Long id) {
		return context.select().from(Theme.THEME)
				.where(Theme.THEME.ID.eq(id.intValue())).fetchOne();
	}

	@Override
	public Object findByAppId(Long id) {
		return context.select().from(Theme.THEME).join(App.APP)
				.on(App.APP.THEME.eq(Theme.THEME.ID))
				.where(App.APP.ID.eq(id.intValue()))
				.fetchInto(ThemeRecord.class).get(0);
	}

	@Override
	public Object findByAppDomain(String domain) {
		return context.select().from(Theme.THEME).join(App.APP)
				.on(App.APP.THEME.eq(Theme.THEME.ID))
				.where(App.APP.DOMAIN.eq(domain))
				.fetchInto(ThemeRecord.class).get(0);
	}

}
