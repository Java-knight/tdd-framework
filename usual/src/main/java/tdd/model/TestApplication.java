package tdd.model;

import jakarta.persistence.*;

/**
 * 测试一下Student聚合的方法是否正确
 */
public class TestApplication {

    public static void main(String[] args) {
        // (1) 创建一个 entity的管理工厂(起个名字叫做student)
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
        // (2) 使用工厂创建一个实例管理
        EntityManager studentManager = factory.createEntityManager();
        // (3) 开启一个事务(find操作不需要)
        studentManager.getTransaction().begin();
        // (4) 创建一个student聚合仓库(测试这个聚合仓库提供的增删改查方法)
        StudentRepository studentRepository = new StudentRepository(studentManager);
        // (5) 调用 entityManager 创建一个student对象
        Student knight = studentRepository.save(new Student("knight", "lidong", "knight.lidong@qq.com"));
        // (6) 提交事务
        studentManager.getTransaction().commit();

        System.out.println(knight.getId());
        // 测试 findById 方法
        studentRepository.findById(knight.getId());
    }
}
