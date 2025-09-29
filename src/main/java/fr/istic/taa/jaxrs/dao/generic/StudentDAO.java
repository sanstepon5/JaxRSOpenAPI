package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Student;

public class StudentDAO extends AbstractJpaDao<Long, Student>{
    public StudentDAO() {
        super();
        setClazz(Student.class);
    }
}
