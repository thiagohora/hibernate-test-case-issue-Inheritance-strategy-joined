package org.hibernate.bugs;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserRepo {

    private Session session;

    public UserRepo(Session session) {
        this.session = session;
    }

    public Customer findById(long id) {

        Query<Customer> query = session.createQuery("SELECT c FROM Customer c where c.id = ?1", Customer.class);
        query.setParameter(1, id);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void logUserCreation(Customer customer) {
        session.save(new UserLog(customer, "user created with success"));
    }
}
