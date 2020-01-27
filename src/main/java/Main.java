import org.hibernate.Session;
import ru.temp.hibernate.model.Task;
import ru.temp.hibernate.model.User;
import ru.temp.hibernate.service.SparkJavaHibernateExample;
import ru.temp.hibernate.util.HibernateUtil;

import java.util.Date;

public class Main {
	public static void main(final String[] args) throws Exception {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
//			User user = new User();
//			user.setFirstName("Вася");
//			user.setLastName("Пупкин");
//			user.setBirthDate(new Date());
//			session.persist(user);

			session.getTransaction().commit();
		} finally {
			session.close();
		}

		SparkJavaHibernateExample.startService();
	}
}