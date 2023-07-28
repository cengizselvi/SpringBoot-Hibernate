package com.crud.cruddemo.dao;

import com.crud.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements  StudentDAO{

    //entity manager tanýmlama
    private EntityManager entityManager;

    //injection kullanarak  entity manager inject etme

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //sorgu oluþturma
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "From Student order by lastName", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findbyLastName(String theLastName) {
        //sorgu oluþturma
        TypedQuery<Student> theQuery= entityManager.createQuery( // thedata=>Yer tutucu
                "From Student Where lastName=:thedata", Student.class);

        //sorgu parametresi ayarlama
        theQuery.setParameter("thedata",theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent=entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }
}
