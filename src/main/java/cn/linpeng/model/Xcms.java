/**
 * This class is generated by jOOQ
 */
package cn.linpeng.model;


import cn.linpeng.model.tables.App;
import cn.linpeng.model.tables.Category;
import cn.linpeng.model.tables.Comment;
import cn.linpeng.model.tables.Post;
import cn.linpeng.model.tables.Tag;
import cn.linpeng.model.tables.Theme;
import cn.linpeng.model.tables.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Xcms extends SchemaImpl {

	private static final long serialVersionUID = 177902967;

	/**
	 * The reference instance of <code>xcms</code>
	 */
	public static final Xcms XCMS = new Xcms();

	/**
	 * No further instances allowed
	 */
	private Xcms() {
		super("xcms");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			App.APP,
			Category.CATEGORY,
			Comment.COMMENT,
			Post.POST,
			Tag.TAG,
			Theme.THEME,
			User.USER);
	}
}