package fr.istic.taa.jaxrs.mappers;

import fr.istic.taa.jaxrs.domain.Question;
import fr.istic.taa.jaxrs.dto.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "quizId", source = "quiz.id")
    @Mapping(target = "answerIds",
            expression = "java(question.getAnswers() == null ? null : question.getAnswers().stream().map(a -> a.getId()).collect(java.util.stream.Collectors.toList()))")
    // Have to use import name because otherwise it doesn't want to import Collectors
    QuestionDTO toDto(Question question);

    @Mapping(target = "quiz", ignore = true)
    @Mapping(target = "answers", ignore = true)
    Question toEntity(QuestionDTO dto);
}
