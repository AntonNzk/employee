import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

    private static SessionFactory factory;

    public static void main(String[] args) {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Employee emp0 = new Employee("John", "Doe", 1000);
        Employee emp1 = new Employee("Richard", "Roe", 2000);
        Employee emp2 = new Employee("Joe", "Bloggs", 3000);
        Employee emp3= new Employee("Another", "Everyman", 4000);

        try {

            session.beginTransaction();

            session.save(emp0);
            session.save(emp1);
            session.save(emp2);
            session.save(emp3);

            session.getTransaction().commit();

        } finally  {

            factory.close();
        }



    }
}