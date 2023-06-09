package at.technikum.tourplannerbackend.persistence;

import at.technikum.tourplannerbackend.persistance.entities.TourLogEntity;
import at.technikum.tourplannerbackend.persistance.repositories.TourLogRepository;
import at.technikum.tourplannerbackend.utils.Difficulty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TourLogPersistanceTest {

    @Autowired
    private TourLogRepository tourLogRepository;

    @Test
    void testTourLogRepository() {
        // Arrange
        TourLogEntity tourLogEntity = TourLogEntity.builder()
                .comment("super")
                .difficulty(Difficulty.EASY)
                .build();

        // Act
        TourLogEntity control = tourLogRepository.save(tourLogEntity);
        TourLogEntity find = tourLogRepository.findById(control.getId()).get();

        // Assert
        assertEquals(tourLogEntity, control);
        assertEquals(control, find);

        // clean up
        tourLogRepository.delete(tourLogEntity);
    }

    @Test
    void testDeleteTourLog() {
        // Arrange
        TourLogEntity tourLogEntity = TourLogEntity.builder()
                .comment("super")
                .difficulty(Difficulty.EASY)
                .build();

        // Act
        tourLogEntity = tourLogRepository.save(tourLogEntity);
        tourLogRepository.delete(tourLogEntity);

        // Assert
        assertFalse(tourLogRepository.findById(tourLogEntity.getId()).isPresent());
    }
}
