package ru.temp.hibernate.dao;

import org.hibernate.Session;
import ru.temp.hibernate.model.User;
import ru.temp.hibernate.util.HibernateUtil;

import java.util.Date;

public class UserDao {

	public void createUser(String firstName, String lastName, Date birthDate) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setBirthDate(birthDate);
			session.persist(user);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
