package HibernateLocalSessionUtil;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory
            = configureSessionFactory();
    private static ServiceRegistry serviceRegistry;

    /**
     * Создание фабрики
     * @return {@link SessionFactory}
     * @throws HibernateException
     */
    private static SessionFactory configureSessionFactory()
            throws HibernateException {

        // Настройки hibernate
        Configuration configuration = new Configuration()
                .setProperty( "hibernate.connection.driver_class",
                        "com.mysql.jdbc.Driver" )
                .setProperty( "hibernate.connection.url",
                        "jdbc:mysql://localhost:3306/springtest?characterEncoding=utf-8" )
                .setProperty( "hibernate.connection.username", "root")
                .setProperty( "hibernate.connection.password", "root" )
                .setProperty( "hibernate.connection.pool_size", "1" )
                .setProperty( "hibernate.connection.autocommit", "false" )
                .setProperty( "hibernate.cache.provider_class",
                        "org.hibernate.cache.NoCacheProvider" )
                .setProperty( "hibernate.cache.use_second_level_cache",
                        "false" )
                .setProperty( "hibernate.cache.use_query_cache", "false" )
                .setProperty( "hibernate.dialect",
                        "org.hibernate.dialect.MySQLDialect" )
                .setProperty( "hibernate.show_sql","true" )
                .setProperty( "hibernate.current_session_context_class",
                        "thread" )
                .addPackage( "springtestapp" )
                .addAnnotatedClass(springtestapp.model.Contact.class)
                .addAnnotatedClass(springtestapp.model.ContactTelDetail.class)
                .addAnnotatedClass(springtestapp.model.Hobby.class)
                ;
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Получить фабрику сессий
     * @return {@link SessionFactory}
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}