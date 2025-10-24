package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.generic.QuestionDAO;
import fr.istic.taa.jaxrs.dao.generic.QuizDAO;
import fr.istic.taa.jaxrs.domain.Question;
import fr.istic.taa.jaxrs.domain.Quiz;
import fr.istic.taa.jaxrs.dto.QuestionDTO;
import fr.istic.taa.jaxrs.mappers.QuestionMapper;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionService {

    private final QuestionDAO questionDAO = new QuestionDAO();
    private final QuizDAO quizDAO = new QuizDAO();
    private final QuestionMapper mapper = QuestionMapper.INSTANCE;

    public QuestionDTO getById(Long id) {
        Question q = questionDAO.findOne(id);
        return mapper.toDto(q);
    }

    public List<QuestionDTO> getAll() {
        return questionDAO.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void create(QuestionDTO dto) {
        Question q = mapper.toEntity(dto);

        if (dto.getQuizId() != null) {
            Quiz quiz = quizDAO.findOne(dto.getQuizId());
            q.setQuiz(quiz);
        }

        questionDAO.save(q);
    }
}
