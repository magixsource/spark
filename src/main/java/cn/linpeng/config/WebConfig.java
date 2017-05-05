package cn.linpeng.config;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spark.Request;
import spark.Response;
import spark.Route;
import cn.linpeng.RenderHelper;
import cn.linpeng.model.tables.records.PostRecord;
import cn.linpeng.model.tables.records.ThemeRecord;
import cn.linpeng.model.tables.records.UserRecord;
import cn.linpeng.service.AppService;
import cn.linpeng.service.CategoryService;
import cn.linpeng.service.PostService;
import cn.linpeng.service.ThemeService;
import cn.linpeng.service.UserService;

@Repository
public class WebConfig {
	private static final String USER_SESSION_ID = "SPARK_LOGIN_USER";

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	@Autowired
	private ThemeService themeService;

	@Autowired
	private AppService appService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * 构造器，静态资源设置，设置/public目录为静态目录
	 */
	public WebConfig() {
		staticFileLocation("/public/");
		setupRoutes();
	}

	/**
	 * 应用访问拦截，为应用上下文设值，如应用主题，应用栏目等
	 */
	private void setupRoutes() {
		before("/:domain/*",
				(req, res) -> {
					if (req.splat().length > 0) {
						// push category
						String domain = req.params("domain");
						Object app = appService.findByDomain(domain);
						if (app == null) {
							return;
						}

						ThemeRecord theme = (ThemeRecord) themeService
								.findByAppDomain(domain);
						List<Object> list = categoryService
								.findByDomain(domain);
						req.attribute("filter_theme", theme.getName());
						req.attribute("filter_category", list);
					}
				});

		// /**
		// * Filter
		// */
		// before("/:domain/posts", (req, res) -> {
		// if (getAuthenticatedUser(req) == null) {
		// res.redirect("/login");
		// halt();
		// }
		// });

		/**
		 * 登录请求，转到login.html登录界面
		 */
		get("/login", (req, res) -> {
			res.status(200);
			res.type("text/html");
			Map<String, Object> attributes = new HashMap<>();
			return RenderHelper.render(attributes, "login.html");
		});

		/**
		 * 登录认证请求，POST,判断用户名密码
		 */
		post("/login",
				(req, res) -> {
					String username = req.queryParams("username");
					String password = req.queryParams("password");

					UserRecord user = (UserRecord) userService
							.findByAccountAndPassword(username, password);

					addAuthenticatedUser(req, user);

					Map<String, Object> attributes = new HashMap<>();
					attributes.put("user", user);
					return RenderHelper.render(attributes, "index.html");
				});

		/**
		 * 登出,GET,登录成功跳转到登录页面
		 */
		get("/logout", (req, res) -> {
			removeAuthenticatedUser(req);
			res.redirect("/login");
			halt();
			return null;
		});

		// get("/:domain", (req, res) -> {
		// String domain = req.params("domain");
		// res.redirect("/"+domain+"/index");
		// halt();
		// return null;
		// });

		/**
		 * 应用首页，响应内容有：应用文章集合，应用实体，主题，栏目集合，当前栏目等
		 */
		get("/:domain/index", (req, res) -> {
			res.status(200);
			res.type("text/html");
			Map<String, Object> attributes = new HashMap<>();

			String domain = req.params("domain");

			List<Object> posts = postService.findAll(domain);
			attributes.put("posts", posts);
			attributes.put("domain", domain);
			attributes.put("theme", req.attribute("filter_theme"));
			attributes.put("category", req.attribute("filter_category"));
			attributes.put("current_cat", req.uri());
			return RenderHelper.render(attributes, "/app/" + domain
					+ "/post/index.html");
		});

		/**
		 * 应用文章单页请求
		 */
		get("/:domain/post/:postid",
				(req, res) -> {
					res.status(200);
					res.type("text/html");
					Map<String, Object> attributes = new HashMap<>();

					String domain = req.params("domain");

					String postid = req.params("postid");
					PostRecord post = (PostRecord) postService.findById(Long
							.valueOf(postid));
					attributes.put("domain", domain);
					attributes.put("post", post);
					attributes.put("theme", req.attribute("filter_theme"));
					attributes.put("category", req.attribute("filter_category"));
					attributes.put("current_cat", req.uri());
					return RenderHelper.render(attributes, "/app/" + domain
							+ "/post/post.html");
				});

		/**
		 * 平台是否存活响应体
		 */
		get("/alive", new Route() {
			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return "ok";
			}
		});
	}

	private void addAuthenticatedUser(Request request, UserRecord u) {
		request.session().attribute(USER_SESSION_ID, u);
	}

	private void removeAuthenticatedUser(Request request) {
		request.session().removeAttribute(USER_SESSION_ID);
	}

	private UserRecord getAuthenticatedUser(Request request) {
		return request.session().attribute(USER_SESSION_ID);
	}
}
