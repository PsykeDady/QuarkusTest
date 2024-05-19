package co.psyke.repositories;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.LinkedList;
import java.util.List;

import co.psyke.models.UserEntity;


@ApplicationScoped
public class UserRepository {

    @Inject
    private EntityManager entityManager; 
    
    @Transactional
    public void addUser(UserEntity u) {
        entityManager.persist(u);
    }

    public List<UserEntity> listAll(){
        Query q= entityManager.createQuery("SELECT u FROM UserEntity u"); 
        List<UserEntity> u = new LinkedList<>(); 
        try {
            List<?> tmpL =q.getResultList();
            tmpL.forEach(v-> {if(v instanceof UserEntity) u.add((UserEntity)v);});
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return u;
    }

    public UserEntity getUser (String username) {
        return entityManager.find(UserEntity.class, username);
    }

    @Transactional
    public void updateUser (UserEntity userEntity) {
        entityManager.merge(userEntity);
    }

    @Transactional
    public void deleteUser (UserEntity userEntity) {
        entityManager.remove(entityManager.contains(userEntity)? userEntity : entityManager.merge(userEntity));
    }
}
