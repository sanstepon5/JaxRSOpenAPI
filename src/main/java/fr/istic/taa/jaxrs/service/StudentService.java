package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.generic.StudentDAO;
import fr.istic.taa.jaxrs.dao.generic.QuizDAO;
import fr.istic.taa.jaxrs.domain.Student;
import fr.istic.taa.jaxrs.dto.StudentDTO;
import fr.istic.taa.jaxrs.mappers.StudentMapper;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();
    private final QuizDAO quizDAO = new QuizDAO();
    private final StudentMapper mapper = StudentMapper.INSTANCE;

    public StudentDTO getById(Long id) {
        Student s = studentDAO.findOne(id);
        return mapper.toDto(s);
    }

    public List<StudentDTO> getAll() {
        return studentDAO.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void create(StudentDTO dto) {
        Student s = mapper.toEntity(dto);

        if (dto.getQuizIds() != null)
            s.setQuiz(dto.getQuizIds().stream()
                    .map(quizDAO::findOne)
                    .collect(Collectors.toList()));

        studentDAO.save(s);
    }
}
