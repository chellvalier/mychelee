package com.freshfold.dao;

import com.freshfold.Pengguna;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PenggunaDAOImpl implements PenggunaDAO {

    private final SessionFactory sessionFactory;

    public PenggunaDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Pengguna pengguna) {
        sessionFactory.getCurrentSession().persist(pengguna);
    }

    @Override
    @Transactional(readOnly = true)
    public Pengguna findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(
                "FROM Pengguna WHERE username = :username",
                Pengguna.class)
                .setParameter("username", username)
                .uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public Pengguna login(String username, String password) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(
                "FROM Pengguna WHERE username = :username "
                + "AND password = :password",
                Pengguna.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();
    }
}
