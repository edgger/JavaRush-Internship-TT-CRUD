package guru.optimal.crud;

import guru.optimal.crud.config.SpringConfig;
import guru.optimal.crud.config.WebConfig;
import guru.optimal.crud.entity.Book;
import guru.optimal.crud.service.TestBean;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final StandardServiceRegistry registry;

    static {
        //0!
        registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            /*//!1
            Configuration configuration = new Configuration();
            configuration.configure();
            //!2
            ourSessionFactory = configuration.buildSessionFactory();*/
            //1!
            ourSessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
            System.out.println("Problem creating session factory");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        //context.scan("guru.optimal.crud");
        context.refresh();

        //3
        final Session session = getSession();
        try {
            /*Transaction transaction = session.beginTransaction();
            Book book = (Book) context.getBean("getBook");
            book.setAuthor("Zed");
            book.setTitle("Zed is Dead");
            book.setIsbn("123sds");
            session.save(book);
            transaction.commit();*/

            /*System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }*/
        } finally {
            session.close();
        }
        ourSessionFactory.close();

        TestBean getTestBean = (TestBean) context.getBean("getTestBean");//TestBean.class);
        System.out.println(getTestBean.getName()+ " is here!");
        context.close();
    }
}