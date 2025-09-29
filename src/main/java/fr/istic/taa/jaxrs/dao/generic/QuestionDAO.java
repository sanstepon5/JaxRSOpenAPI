package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Question;


public class QuestionDAO extends AbstractJpaDao<Long, Question>{
    public QuestionDAO() {
        super();
        setClazz(Question.class);
    }
}
