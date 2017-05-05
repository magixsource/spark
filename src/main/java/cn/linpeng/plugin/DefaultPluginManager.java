package cn.linpeng.plugin;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * Default plugin manager in spark application
 * 
 * @author linpeng
 * @createAt 2015-12-3
 */
@Repository
public class DefaultPluginManager implements PluginManager {
	/** spring application context */
	private ApplicationContext ctx;
	/** plugin names */
	private String[] pluginNames;

	@Override
	public void loadPlugins() {
		if (null == ctx) {
			throw new IllegalArgumentException("Ctx canot be null.");
		}
		if (null == pluginNames) {
			return;
		}
		for (String pluginName : pluginNames) {
			Plugin plugin = (Plugin) ctx.getBean(pluginName);
			plugin.startup();
		}

	}

	@Override
	public void removePlugins() {
		if (null == ctx) {
			throw new IllegalArgumentException("Ctx canot be null.");
		}
		if (null == pluginNames) {
			return;
		}
		for (String pluginName : pluginNames) {
			Plugin plugin = (Plugin) ctx.getBean(pluginName);
			plugin.stop();
		}
	}

	@Override
	public void loadPlugin(String pluginName) {

	}

	@Override
	public void removePlugin(String pluginName) {

	}

	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	public String[] getPluginNames() {
		return pluginNames;
	}

	public void setPluginNames(String[] pluginNames) {
		this.pluginNames = pluginNames;
	}

}
