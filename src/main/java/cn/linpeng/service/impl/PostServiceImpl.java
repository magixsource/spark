package cn.linpeng.service.impl;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.linpeng.model.tables.App;
import cn.linpeng.model.tables.Post;
import cn.linpeng.model.tables.records.PostRecord;
import cn.linpeng.service.PostService;
import cn.linpeng.service.UserService;

@Repository
public class PostServiceImpl implements PostService {

	@Autowired
	private UserService userService;

	@Autowired
	private DSLContext context;

	@Override
	public Object findById(Long id) {
		return context.select().from(Post.POST)
				.where(Post.POST.ID.eq(id.intValue())).fetchOne();
	}

	@Override
	public List<Object> findAll(String domain) {
		return context.select().from(Post.POST).join(App.APP)
				.on(App.APP.ID.eq(Post.POST.APP_ID))
				.where(App.APP.DOMAIN.eq(domain)).fetchInto(PostRecord.class);
	}

}
