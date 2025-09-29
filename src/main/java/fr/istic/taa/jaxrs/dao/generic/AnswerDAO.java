package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Answer;


public class AnswerDAO extends AbstractJpaDao<Long, Answer>{
    public AnswerDAO() {
        super();
        setClazz(Answer.class);
    }
}
