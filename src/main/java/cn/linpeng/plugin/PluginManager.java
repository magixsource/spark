package cn.linpeng.plugin;

/**
 * Scan plugins and load them
 * 
 * @author linpeng
 * @createAt 2015-12-3
 *
 */
public interface PluginManager {

	/**
	 * Load all plugins from spring context
	 */
	public void loadPlugins();

	/**
	 * remove all plugins from spring context
	 */
	public void removePlugins();

	/**
	 * load a plugin to spring context by plugin name in container
	 * 
	 * @param pluginName
	 */
	public void loadPlugin(String pluginName);

	/**
	 * remove a plugin from spring context by plugin nane in container
	 * 
	 * @param pluginName
	 */
	public void removePlugin(String pluginName);

}
