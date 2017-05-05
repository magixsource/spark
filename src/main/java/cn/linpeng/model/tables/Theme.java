/**
 * This class is generated by jOOQ
 */
package cn.linpeng.model.tables;


import cn.linpeng.model.Keys;
import cn.linpeng.model.Xcms;
import cn.linpeng.model.tables.records.ThemeRecord;

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
public class Theme extends TableImpl<ThemeRecord> {

	private static final long serialVersionUID = -491609809;

	/**
	 * The reference instance of <code>xcms.theme</code>
	 */
	public static final Theme THEME = new Theme();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ThemeRecord> getRecordType() {
		return ThemeRecord.class;
	}

	/**
	 * The column <code>xcms.theme.id</code>.
	 */
	public final TableField<ThemeRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>xcms.theme.name</code>.
	 */
	public final TableField<ThemeRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * Create a <code>xcms.theme</code> table reference
	 */
	public Theme() {
		this("theme", null);
	}

	/**
	 * Create an aliased <code>xcms.theme</code> table reference
	 */
	public Theme(String alias) {
		this(alias, THEME);
	}

	private Theme(String alias, Table<ThemeRecord> aliased) {
		this(alias, aliased, null);
	}

	private Theme(String alias, Table<ThemeRecord> aliased, Field<?>[] parameters) {
		super(alias, Xcms.XCMS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ThemeRecord, Integer> getIdentity() {
		return Keys.IDENTITY_THEME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ThemeRecord> getPrimaryKey() {
		return Keys.KEY_THEME_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ThemeRecord>> getKeys() {
		return Arrays.<UniqueKey<ThemeRecord>>asList(Keys.KEY_THEME_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Theme as(String alias) {
		return new Theme(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Theme rename(String name) {
		return new Theme(name, null);
	}
}