package ru.temp.hibernate.service;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * Тестовый класс с шаблоном mustache
 * */
public class MustacheTestService implements SparkService {
	public void startService() {
		get("/hellow", (request, response) -> {
			Map<String, Object> model = new HashMap<>();

			model.put("title", "Mustache test");
			model.put("createdOn", new Date().toString());
			model.put("text", "Какой-то текст");

			return new MustacheTemplateEngine().render(
					new ModelAndView(model, "hellow.mustache")
			);
		});

	}
}
