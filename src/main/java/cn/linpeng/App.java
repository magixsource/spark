package cn.linpeng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spark.Request;
import cn.linpeng.plugin.DefaultPluginManager;
import cn.linpeng.plugin.Plugin;

@Configuration
@ComponentScan(basePackages = { "cn.linpeng", "com.linpeng" })
public class App {

	private static final Logger logger = Logger.getLogger(App.class
			.getCanonicalName());
	private String userName = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/xcms";
	private Connection conn = null;
	private DSLContext dslContext;

	@Bean
	public DSLContext context() {
		if (dslContext == null) {
			try {
				conn = DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dslContext = DSL.using(conn, SQLDialect.MYSQL);
		}
		return dslContext;
	}

	private static boolean shouldReturnHtml(Request request) {
		String accept = request.headers("Accept");
		return accept != null && accept.contains("text/html");
	}

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				App.class);
		DefaultPluginManager pm = ctx.getBean(DefaultPluginManager.class);
		String[] names = ctx.getBeanNamesForType(Plugin.class);
		pm.setPluginNames(names);
		pm.setCtx(ctx);
		pm.loadPlugins();

		ctx.registerShutdownHook();
	}
}
