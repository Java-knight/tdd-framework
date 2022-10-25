package tdd.model;


import jakarta.persistence.EntityManager;

import java.util.Optional;

/**
 * Student聚合: 给 Student对象提供了增删改查的方法, 这个方法可以做一些数据的聚合
 */
public class StudentRepository {

    private EntityManager manager;

    public StudentRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Student save(Student student) {
        manager.persist(student);
        return student;
    }

    public Optional<Student> findById(long id) {
        return Optional.ofNullable(manager.find(Student.class, id));
    }
}
