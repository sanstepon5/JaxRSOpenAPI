package fr.istic.taa.jaxrs.mappers;

import fr.istic.taa.jaxrs.domain.Student;
import fr.istic.taa.jaxrs.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;


@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "quizIds",
            expression = "java(student.getQuizList() == null ? null : student.getQuizList().stream().map(q -> q.getId()).collect(java.util.stream.Collectors.toList()))")
    StudentDTO toDto(Student student);

    @Mapping(target = "quizList", ignore = true)
    Student toEntity(StudentDTO dto);
}
