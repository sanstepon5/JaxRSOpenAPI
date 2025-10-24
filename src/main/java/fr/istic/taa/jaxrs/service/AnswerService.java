package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.generic.AnswerDAO;
import fr.istic.taa.jaxrs.dao.generic.QuestionDAO;
import fr.istic.taa.jaxrs.domain.Answer;
import fr.istic.taa.jaxrs.domain.Question;
import fr.istic.taa.jaxrs.dto.AnswerDTO;
import fr.istic.taa.jaxrs.mappers.AnswerMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AnswerService {

    private final AnswerDAO answerDAO = new AnswerDAO();
    private final QuestionDAO questionDAO = new QuestionDAO();
    private final AnswerMapper mapper = AnswerMapper.INSTANCE;

    public AnswerDTO getById(Long id) {
        Answer answer = answerDAO.findOne(id);
        return mapper.toDto(answer);
    }

    public List<AnswerDTO> getAll() {
        return answerDAO.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void create(AnswerDTO dto) {
        Answer answer = mapper.toEntity(dto);

        if (dto.getQuestionId() != null) {
            Question q = questionDAO.findOne(dto.getQuestionId());
            answer.setQuestion(q);
        }

        answerDAO.save(answer);
    }
}

