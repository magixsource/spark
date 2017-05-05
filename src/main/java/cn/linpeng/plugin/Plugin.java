package cn.linpeng.plugin;

/**
 * Plugin means could be remove\add by JVM
 * 
 * @author linpeng
 *
 */
public interface Plugin {

	/**
	 * Plugin startup,Can init environment here
	 */
	public void startup();

	/**
	 * Plugin stop,can't use plugin anymore,do some clear work
	 */
	public void stop();
}
