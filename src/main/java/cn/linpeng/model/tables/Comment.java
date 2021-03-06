/**
 * This class is generated by jOOQ
 */
package cn.linpeng.model.tables;


import cn.linpeng.model.Keys;
import cn.linpeng.model.Xcms;
import cn.linpeng.model.tables.records.CommentRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Comment extends TableImpl<CommentRecord> {

	private static final long serialVersionUID = 1035308332;

	/**
	 * The reference instance of <code>xcms.comment</code>
	 */
	public static final Comment COMMENT = new Comment();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<CommentRecord> getRecordType() {
		return CommentRecord.class;
	}

	/**
	 * The column <code>xcms.comment.id</code>.
	 */
	public final TableField<CommentRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>xcms.comment.post_id</code>.
	 */
	public final TableField<CommentRecord, Integer> POST_ID = createField("post_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>xcms.comment.content</code>.
	 */
	public final TableField<CommentRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>xcms.comment.author</code>.
	 */
	public final TableField<CommentRecord, Integer> AUTHOR = createField("author", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>xcms.comment.create_time</code>.
	 */
	public final TableField<CommentRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>xcms.comment</code> table reference
	 */
	public Comment() {
		this("comment", null);
	}

	/**
	 * Create an aliased <code>xcms.comment</code> table reference
	 */
	public Comment(String alias) {
		this(alias, COMMENT);
	}

	private Comment(String alias, Table<CommentRecord> aliased) {
		this(alias, aliased, null);
	}

	private Comment(String alias, Table<CommentRecord> aliased, Field<?>[] parameters) {
		super(alias, Xcms.XCMS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<CommentRecord, Integer> getIdentity() {
		return Keys.IDENTITY_COMMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<CommentRecord> getPrimaryKey() {
		return Keys.KEY_COMMENT_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<CommentRecord>> getKeys() {
		return Arrays.<UniqueKey<CommentRecord>>asList(Keys.KEY_COMMENT_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Comment as(String alias) {
		return new Comment(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Comment rename(String name) {
		return new Comment(name, null);
	}
}
