package app.dao;

import app.models.User;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.unwrap(Session.class).createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.unwrap(Session.class).merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.unwrap(Session.class).get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Query<?> query = entityManager.unwrap(Session.class).createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}