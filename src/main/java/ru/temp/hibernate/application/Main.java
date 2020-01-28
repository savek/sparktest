package ru.temp.hibernate.application;

import ru.temp.hibernate.service.MustacheTestService;
import ru.temp.hibernate.service.SparkJavaHibernateExample;

import static spark.Spark.staticFiles;

public class Main {
	public static void main(final String[] args) throws Exception {
		staticFiles.location("/public");

		// Регистрация служб
		new SparkJavaHibernateExample().startService();
		new MustacheTestService().startService();
	}
}
