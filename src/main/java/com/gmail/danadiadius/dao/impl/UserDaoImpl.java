package com.gmail.danadiadius.dao.impl;

import java.util.Optional;
import com.gmail.danadiadius.dao.UserDao;
import com.gmail.danadiadius.exception.DataProcessingException;
import com.gmail.danadiadius.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                            "from User u join fetch u.roles where u.email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get user by email: "
                    + email, e);
        }
    }
}
