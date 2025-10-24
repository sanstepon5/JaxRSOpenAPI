package fr.istic.taa.jaxrs.mappers;

import fr.istic.taa.jaxrs.domain.Answer;
import fr.istic.taa.jaxrs.dto.AnswerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    @Mapping(target = "questionId", source = "question.id")
    AnswerDTO toDto(Answer answer);

    @Mapping(target = "question", ignore = true) // handled in service
    Answer toEntity(AnswerDTO dto);
}
