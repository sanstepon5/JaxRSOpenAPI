package fr.istic.taa.jaxrs.mappers;

import fr.istic.taa.jaxrs.domain.Quiz;
import fr.istic.taa.jaxrs.dto.QuizDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper
public interface QuizMapper {
    QuizMapper INSTANCE = Mappers.getMapper(QuizMapper.class);

    @Mapping(target = "teacherId", source = "teacher.id")
    @Mapping(target = "questionIds",
            expression = "java(quiz.getQuestions() == null ? null : quiz.getQuestions().stream().map(q -> q.getId()).collect(Collectors.toList()))")
    @Mapping(target = "studentIds",
            expression = "java(quiz.getStudents() == null ? null : quiz.getStudents().stream().map(s -> s.getId()).collect(Collectors.toList()))")
    QuizDTO toDto(Quiz quiz);

    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "questions", ignore = true)
    @Mapping(target = "students", ignore = true)
    Quiz toEntity(QuizDTO dto);
}
