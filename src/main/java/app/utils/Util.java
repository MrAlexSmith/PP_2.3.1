package app.utils;

import app.models.User;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/pp_2.3.1";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "root";
    private static final String MYSQL_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String MYSQL_SHOW_SQL = "true";
    private static final String MYSQL_CURRENT_SESSION_CONTEXT_CLASS = "thread";
    private static final String MYSQL_HBM2DDL_AUTO = "create-drop";

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws HibernateException {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, MYSQL_DRIVER);
            properties.put(Environment.URL, MYSQL_URL);
            properties.put(Environment.USER, MYSQL_USERNAME);
            properties.put(Environment.PASS, MYSQL_PASSWORD);
            properties.put(Environment.DIALECT, MYSQL_DIALECT);
            properties.put(Environment.SHOW_SQL, MYSQL_SHOW_SQL);
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, MYSQL_CURRENT_SESSION_CONTEXT_CLASS);
            properties.put(Environment.HBM2DDL_AUTO, MYSQL_HBM2DDL_AUTO);

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration
                    .getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
