package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.generic.TeacherDAO;
import fr.istic.taa.jaxrs.dao.generic.QuizDAO;
import fr.istic.taa.jaxrs.domain.Teacher;
import fr.istic.taa.jaxrs.dto.TeacherDTO;
import fr.istic.taa.jaxrs.mappers.TeacherMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherService {

    private final TeacherDAO teacherDAO = new TeacherDAO();
    private final QuizDAO quizDAO = new QuizDAO();
    private final TeacherMapper mapper = TeacherMapper.INSTANCE;

    public TeacherDTO getById(Long id) {
        Teacher t = teacherDAO.findOne(id);
        return mapper.toDto(t);
    }

    public List<TeacherDTO> getAll() {
        return teacherDAO.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void create(TeacherDTO dto) {
        Teacher t = mapper.toEntity(dto);

        if (dto.getQuizIds() != null)
            t.setQuiz(dto.getQuizIds().stream()
                    .map(quizDAO::findOne)
                    .collect(Collectors.toList()));

        teacherDAO.save(t);
    }
}

