package org.sanaa.setnence.citronix.youquiz.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericServiceI<Entity, RequestDTO, ResponseDTO> {
    ResponseDTO create(RequestDTO requestDTO);
    ResponseDTO update(Long id , RequestDTO requestDTO);
    Optional<ResponseDTO> findById (Long id);
    List<ResponseDTO> findAll ();
    void delete (Long id);

}
