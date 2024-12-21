package org.sanaa.setnence.citronix.youquiz.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.sanaa.setnence.citronix.youquiz.model.dto.request.LevelRequestDTO;
import org.sanaa.setnence.citronix.youquiz.model.dto.response.LevelResponseDTO;
import org.sanaa.setnence.citronix.youquiz.model.entity.Level;
import org.sanaa.setnence.citronix.youquiz.model.mapper.LevelMapper;
import org.sanaa.setnence.citronix.youquiz.repository.LevelRepository;
import org.sanaa.setnence.citronix.youquiz.service.interfaces.LevelServiceI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService implements LevelServiceI {

    private final LevelRepository levelRepository;
    private final  LevelMapper  levelMapper;

    public LevelService(LevelRepository levelRepository, LevelMapper levelMapper) {
        this.levelRepository = levelRepository;
        this.levelMapper = levelMapper;
    }

    @Override
    public LevelResponseDTO create(LevelRequestDTO levelRequestDTO) {

        Level level = levelMapper.toEntity(levelRequestDTO);
        Level savedLevel = levelRepository.save(level);
        return  levelMapper.toResponseDTO(savedLevel);
    }

    @Override
    public LevelResponseDTO update(Long id, LevelRequestDTO levelRequestDTO) {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found with ID: " + id));
        levelMapper.updateEntityFromRequest(levelRequestDTO , level);
        Level updatedLevel = levelRepository.save(level);
        return levelMapper.toResponseDTO(updatedLevel);
    }

    @Override
    public Optional<LevelResponseDTO> findById(Long id) {
        return levelRepository.findById(id)
                .map(levelMapper::toResponseDTO);
    }

    @Override
    public List<LevelResponseDTO> findAll() {
        return levelRepository.findAll()
                .stream()
                .map(levelMapper::toResponseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if(!levelRepository.existsById(id)){
            throw new  EntityNotFoundException("Quiz not found with ID: " + id);
        }
        levelRepository.deleteById(id);
    }

    public Level findEntityById(Long id) {
        return levelRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("level not found with id "+ id));
    }
}
