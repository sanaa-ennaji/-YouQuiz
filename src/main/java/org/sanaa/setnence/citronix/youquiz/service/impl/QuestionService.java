package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.QuestionRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.QuestionResponseDTO;

import org.sanaa.setnence.citronix.youquiz.model.entity.Level;
import org.sanaa.setnence.citronix.youquiz.model.entity.Question;
import org.sanaa.setnence.citronix.youquiz.model.entity.Subject;
import org.sanaa.setnence.citronix.youquiz.model.mapper.QuestionMapper;
import org.sanaa.setnence.citronix.youquiz.repository.QuestionRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.QuestionServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements QuestionServiceI {
    private final QuestionRepository questionRepository ;
    private final QuestionMapper questionMapper;
    private final LevelService levelService;
    private final SubjectService subjectService;

    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper, LevelService levelService, SubjectService subjectService) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
        this.levelService = levelService;
        this.subjectService = subjectService;
    }


    @Override
    public QuestionResponseDTO create(QuestionRequestDTO questionRequestDTO) {
        Level level = levelService.findEntityById(questionRequestDTO.getLevelId());
        Subject subject = subjectService.findEntityById(questionRequestDTO.getSubjectId());

        Question question  = questionMapper.toEntity(questionRequestDTO);
        question.setLevel(level);
        question.setSubject(subject);
        Question savedQuestion = questionRepository.save(question);
        return  questionMapper.toResponseDTO(savedQuestion);
    }

    @Override
    public QuestionResponseDTO update(Long id, QuestionRequestDTO questionRequestDTO) {
        Question  question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("question not found with ID: " + id));
        questionMapper.updateEntityFromRequest(questionRequestDTO , question);
        Question updatedQuestion = questionRepository.save(question);
        return questionMapper.toResponseDTO(updatedQuestion);
    }

    @Override
    public Optional<QuestionResponseDTO> findById(Long id) {
        return questionRepository.findById(id)
                .map(questionMapper::toResponseDTO);
    }

    @Override
    public List<QuestionResponseDTO> findAll() {
        return questionRepository.findAll()
                .stream()
                .map(questionMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if(!questionRepository.existsById(id)){
            throw new  EntityNotFoundException("Question not found with ID: " + id);
        }
        questionRepository.deleteById(id);

    }
    public Question findEntityById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("question not found with id "+ id));
    }
}
