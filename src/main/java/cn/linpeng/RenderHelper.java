package cn.linpeng;

import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;

public class RenderHelper {
	static FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
	static {
		Configuration freeMarkerConfiguration = new Configuration();
		freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(
				App.class, "/views"));
		freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
	}

	public static Object render(Map<String, Object> attributes, String templateName) {
		return freeMarkerEngine.render(new ModelAndView(attributes,
				templateName));
	}

}
