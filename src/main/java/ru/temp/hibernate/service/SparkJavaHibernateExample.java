package ru.temp.hibernate.service;

import static spark.Spark.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.temp.hibernate.model.Task;
import javax.persistence.EntityManager;
import javax.servlet.MultipartConfigElement;
import java.util.List;

public class SparkJavaHibernateExample implements SparkService {

	public void startService() {

		final SessionFactory sf = new Configuration().configure().buildSessionFactory();

		post("/api/task", (req, res) -> {

			EntityManager session = sf.createEntityManager();
			try {
				req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));


				Integer id = Integer.parseInt(req.queryParams("id"));
				String name = req.queryParams("name");

				Task task = new Task();
				task.setName(name);

				session.getTransaction().begin();
				session.persist(task);
				session.getTransaction().commit();

				res.redirect("/list");
				return "";
			} catch (Exception e) {
				return "Error: " + e.getMessage();
			} finally {
				if (session.isOpen()) {
					session.close();
				}
			}
		});

		get("/list", (req, res) -> {
			EntityManager session = sf.createEntityManager();
			try {
				List<Task> tasks = session.createQuery(" from Task ").getResultList();

				StringBuilder builder = new StringBuilder();

				builder.append("<style>\n" +
						"table {\n" +
						"    border-collapse: collapse;\n" +
						"    width: 50%;\n" +
						"}" +
						"td, th {\n" +
						"    border: 1px solid #dddddd;\n" +
						"    text-align: left;\n" +
						"    padding: 8px;\n" +
						"}\n" +
						"</style>");

				builder.append("<table><tr><th>Task Id</th><th>Task Name</th></tr>\n");
				for (Task task : tasks) {
					builder.append("<tr><td>" + task.getId() + "</td><td>" + task.getName() + "</td></tr>\n");
				}
				builder.append("</table>\n");

				return builder.toString();
			} catch (Exception e) {
				return "Error: " + e.getMessage();
			} finally {
				if (session.isOpen()) {
					session.close();
				}
			}

		});
	}
}
