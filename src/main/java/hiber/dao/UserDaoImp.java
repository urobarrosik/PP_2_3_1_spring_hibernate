package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public void dropUsersTable() {
        entityManager.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = getUserById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void addUserIfNotExist(User user) {
        String result;

        try {
            User existingUser = entityManager.createQuery("SELECT u FROM User u WHERE u.firstName = :firstName", User.class)
                    .setParameter("firstName", user.getFirstName())
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (existingUser != null) {
                result = "Пользователь с таким именем уже существует.";
            } else {
                entityManager.persist(user);
                result = "Пользователь успешно добавлен.";
            }
        } catch (PersistenceException e) {
            result = "Ошибка при добавлении пользователя: " + e.getMessage();
        }
        System.out.println(result);
    }
}

