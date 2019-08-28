package org.hibernate.bugs;

import org.hibernate.Session;

public class CreateUserCommand {

    protected User user;

    public CreateUserCommand(User user) {
        this.user = user;
    }

    public User execute(Session session) {

        session.saveOrUpdate(user);

        return user;
    }

}
