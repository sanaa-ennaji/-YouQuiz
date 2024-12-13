    package org.sanaa.setnence.citronix.youquiz.ServiceTest;

    import static org.junit.jupiter.api.Assertions.assertThrows;
    import static org.mockito.ArgumentMatchers.any;
    import static org.mockito.Mockito.*;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.sanaa.setnence.citronix.youquiz.model.dto.request.TrainerRequestDTO;
    import org.sanaa.setnence.citronix.youquiz.model.dto.response.TrainerResponseDTO;
    import org.sanaa.setnence.citronix.youquiz.model.entity.Trainer;
    import org.sanaa.setnence.citronix.youquiz.model.mapper.TrainerMapper;
    import org.sanaa.setnence.citronix.youquiz.repository.TrainerRepository;
    import org.sanaa.setnence.citronix.youquiz.service.impl.TrainerService;

    import java.time.LocalDate;

    import static org.assertj.core.api.Assertions.assertThat;

    import org.mockito.junit.jupiter.MockitoExtension;

    @ExtendWith(MockitoExtension.class)
    public class TrainerServiceTest {

        @Mock
        private TrainerRepository trainerRepository;

        @Mock
        private TrainerMapper trainerMapper;

        @InjectMocks
        private TrainerService trainerService;

        private TrainerRequestDTO trainerRequestDTO;
        private Trainer trainer;
        private TrainerResponseDTO trainerResponseDTO;

        @BeforeEach
        public void setUp() {
            trainerRequestDTO = new TrainerRequestDTO();
            trainerRequestDTO.setFirstName("John");
            trainerRequestDTO.setLastName("Doe");
            trainerRequestDTO.setBirthDate(LocalDate.of(1990, 5, 15));
            trainerRequestDTO.setAddress("123 Trainer Street");
            trainerRequestDTO.setSpecialty("Fitness");

            trainer = new Trainer();
            trainer.setFirstName("John");
            trainer.setLastName("Doe");
            trainer.setBirthDate(LocalDate.of(1990, 5, 15));
            trainer.setAddress("123 Trainer Street");
            trainer.setSpecialty("Fitness");

            trainerResponseDTO = new TrainerResponseDTO();
            trainerResponseDTO.setId(1L);
            trainerResponseDTO.setFirstName("John");
            trainerResponseDTO.setLastName("Doe");
            trainerResponseDTO.setBirthDate(LocalDate.of(1990, 5, 15));
            trainerResponseDTO.setAddress("123 Trainer Street");
            trainerResponseDTO.setSpecialty("Fitness");
        }

        @Test
        public void testCreateTrainerSuccessfully() {
            when(trainerMapper.toEntity(any(TrainerRequestDTO.class))).thenReturn(trainer);
            when(trainerRepository.save(any(Trainer.class))).thenReturn(trainer);
            when(trainerMapper.toResponseDTO(any(Trainer.class))).thenReturn(trainerResponseDTO);

            TrainerResponseDTO result = trainerService.create(trainerRequestDTO);

            assertThat(result)
                    .isNotNull()
                    .extracting(TrainerResponseDTO::getFirstName, TrainerResponseDTO::getSpecialty)
                    .containsExactly("John", "Fitness");

            verify(trainerMapper, times(1)).toEntity(any(TrainerRequestDTO.class));
            verify(trainerRepository, times(1)).save(any(Trainer.class));
            verify(trainerMapper, times(1)).toResponseDTO(any(Trainer.class));
            verifyNoMoreInteractions(trainerMapper, trainerRepository);
        }

        @Test
        public void testCreateTrainerThrowsExceptionOnSave() {
            when(trainerMapper.toEntity(any(TrainerRequestDTO.class))).thenReturn(trainer);
            when(trainerRepository.save(any(Trainer.class))).thenThrow(new RuntimeException("Database error"));

            RuntimeException exception = assertThrows(RuntimeException.class,
                    () -> trainerService.create(trainerRequestDTO));

            assertThat(exception).hasMessage("Database error");

            verify(trainerMapper, times(1)).toEntity(any(TrainerRequestDTO.class));
            verify(trainerRepository, times(1)).save(any(Trainer.class));
            verifyNoMoreInteractions(trainerMapper, trainerRepository);
        }
    }



