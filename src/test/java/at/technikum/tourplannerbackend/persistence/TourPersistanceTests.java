package at.technikum.tourplannerbackend.persistence;

import at.technikum.tourplannerbackend.persistance.entities.TourEntity;
import at.technikum.tourplannerbackend.persistance.entities.TourLogEntity;
import at.technikum.tourplannerbackend.persistance.repositories.TourLogRepository;
import at.technikum.tourplannerbackend.persistance.repositories.TourRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TourPersistanceTests {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourLogRepository tourLogRepository;

    @Test
    public void saveTourTest(){
        // Arrange
        TourEntity tourEntity = TourEntity.builder().build();

        // Act
        tourEntity = tourRepository.save(tourEntity);

        // AssertTrue
        assertTrue(tourRepository.findById(tourEntity.getId()).isPresent());

        // clean up
        tourRepository.delete(tourEntity);
    }

    @Test
    public void deleteTourTest(){
        // Arrange
        TourEntity tour = TourEntity.builder()
                .name("TourTest")
                .build();
        tour = tourRepository.save(tour);

        // Act
        tourRepository.delete(tour);

        // Assert
        assertFalse(tourRepository.findById(tour.getId()).isPresent());
    }

    @Test
    public void saveTourContainingTourLogs_deleteTour_shouldDeleteTourLogs() {
        // Arrange
        TourEntity tourEntity = TourEntity.builder()
                .name("TourTest")
                .build();
        List<TourLogEntity> logEntities = new ArrayList<>();
        logEntities.add(TourLogEntity.builder().comment("mega").tour(tourEntity).build());
        logEntities.add(TourLogEntity.builder().comment("hui").tour(tourEntity).build());
        logEntities.add(TourLogEntity.builder().comment("morgen").tour(tourEntity).build());
        tourEntity.setTourLogs(logEntities);

        // Act
        TourEntity control = tourRepository.save(tourEntity);
        List<TourLogEntity> tourLogs = tourLogRepository.findByTourId(tourEntity.getId());

        // Assert
        assertEquals(tourEntity,control);
        assertEquals(logEntities.toString(),tourLogs.toString()); // compare strings because pointer are different
        System.out.println(control.getTourLogs());

        // clean up
        tourRepository.delete(tourEntity);

        // Assert
        assertFalse(tourRepository.findById(tourEntity.getId()).isPresent());
        assertTrue(tourLogRepository.findByTourId(tourEntity.getId()).isEmpty());
    }
}
