package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.generic.*;
import fr.istic.taa.jaxrs.domain.*;
import fr.istic.taa.jaxrs.dto.QuizDTO;
import fr.istic.taa.jaxrs.mappers.QuizMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class QuizService {

    private final QuizDAO quizDAO = new QuizDAO();
    private final TeacherDAO teacherDAO = new TeacherDAO();
    private final StudentDAO studentDAO = new StudentDAO();
    private final QuestionDAO questionDAO = new QuestionDAO();
    private final QuizMapper mapper = QuizMapper.INSTANCE;

    public QuizDTO getById(Long id) {
        Quiz quiz = quizDAO.findOne(id);
        return mapper.toDto(quiz);
    }

    public List<QuizDTO> getAll() {
        return quizDAO.findAll().stream()
                .map(mapper::toDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public void create(QuizDTO dto) {
        Quiz quiz = mapper.toEntity(dto);

        if (dto.getTeacherId() != null)
            quiz.setTeacher(teacherDAO.findOne(dto.getTeacherId()));

        if (dto.getQuestionIds() != null)
            quiz.setQuestions(dto.getQuestionIds().stream()
                    .map(questionDAO::findOne)
                    .collect(Collectors.toList()));

        if (dto.getStudentIds() != null)
            quiz.setStudents(dto.getStudentIds().stream()
                    .map(studentDAO::findOne)
                    .collect(Collectors.toList()));

        quizDAO.save(quiz);
    }
}

