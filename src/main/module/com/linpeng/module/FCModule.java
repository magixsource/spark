package com.linpeng.module;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.linpeng.RenderHelper;
import cn.linpeng.plugin.Plugin;

/**
 * Football Club module
 * 
 * @author linpeng
 * @createAt 2015-12-3
 */
@Repository
public class FCModule implements Plugin {

	@Override
	public void startup() {
		setupRoutes();
	}

	@Override
	public void stop() {

	}

	private void setupRoutes() {
		get("/:domain/team", (req, res) -> {
			String domain = req.params("domain");
			if ("fc".equalsIgnoreCase(domain) == false) {
				throw new UnsupportedOperationException("Unsupported request "
						+ domain + "/team");
			}
			res.status(200);
			res.type("text/html");
			Map<String, Object> attributes = new HashMap<>();
			
			attributes.put("domain", domain);
			attributes.put("theme", req.attribute("filter_theme"));
			attributes.put("category", req.attribute("filter_category"));
			
			attributes.put("current_cat", req.uri());
			return RenderHelper.render(attributes, "/app/" + domain
					+ "/team.html");
		});
		
		get("/:domain/news", (req, res) -> {
			String domain = req.params("domain");
			if ("fc".equalsIgnoreCase(domain) == false) {
				throw new UnsupportedOperationException("Unsupported request "
						+ domain + "/news");
			}
			res.status(200);
			res.type("text/html");
			Map<String, Object> attributes = new HashMap<>();
			
			attributes.put("domain", domain);
			attributes.put("theme", req.attribute("filter_theme"));
			attributes.put("category", req.attribute("filter_category"));
			
			attributes.put("current_cat", req.uri());
			return RenderHelper.render(attributes, "/app/" + domain
					+ "/news.html");
		});
		
		get("/:domain/history", (req, res) -> {
			String domain = req.params("domain");
			if ("fc".equalsIgnoreCase(domain) == false) {
				throw new UnsupportedOperationException("Unsupported request "
						+ domain + "/history");
			}
			res.status(200);
			res.type("text/html");
			Map<String, Object> attributes = new HashMap<>();
			
			attributes.put("domain", domain);
			attributes.put("theme", req.attribute("filter_theme"));
			attributes.put("category", req.attribute("filter_category"));
			
			attributes.put("current_cat", req.uri());
			return RenderHelper.render(attributes, "/app/" + domain
					+ "/history.html");
		});
	}

}
