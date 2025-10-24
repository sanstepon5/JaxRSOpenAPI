package fr.istic.taa.jaxrs.mappers;

import fr.istic.taa.jaxrs.domain.Teacher;
import fr.istic.taa.jaxrs.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "quizIds",
            expression = "java(teacher.getQuizList() == null ? null : teacher.getQuizList().stream().map(q -> q.getId()).collect(Collectors.toList()))")
    TeacherDTO toDto(Teacher teacher);

    @Mapping(target = "quizzList", ignore = true)
    Teacher toEntity(TeacherDTO dto);
}
