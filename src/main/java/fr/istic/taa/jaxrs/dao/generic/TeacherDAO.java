package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Teacher;

public class TeacherDAO extends AbstractJpaDao<Long, Teacher> {
    public TeacherDAO() {
        super();
        setClazz(Teacher.class);
    }
}
