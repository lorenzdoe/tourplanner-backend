package at.technikum.tourplannerbackend.service.mapper;

import at.technikum.tourplannerbackend.model.Tour;
import at.technikum.tourplannerbackend.model.TourLog;
import at.technikum.tourplannerbackend.persistance.entities.TourEntity;
import at.technikum.tourplannerbackend.persistance.entities.TourLogEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TourMapperTest {

    @Autowired
    private TourMapper tourMapper;

    @Test
    void fromEntity() {
        // Arrange
        List<TourLogEntity> tourLogEntities = new ArrayList<>();
        TourEntity tourEntity = TourEntity.builder().id(1L).name("test").build();
        tourLogEntities.add(TourLogEntity.builder().id(1L).comment("super").tour(tourEntity).build());
        tourLogEntities.add(TourLogEntity.builder().id(2L).comment("faad").tour(tourEntity).build());
        tourEntity.setTourLogs(tourLogEntities);

        // Act
        Tour tour = tourMapper.fromEntity(tourEntity);

        // Assert
        assertEquals(tourEntity.getId(), tour.getId());
        assertEquals(tourEntity.getName(), tour.getName());

    }

    @Test
    void toEntity() {
        // Arrange
        List<TourLog> tourLogs = new ArrayList<>();
        Tour tour = Tour.builder().id(1L).name("test").build();

        // Act
        TourEntity tourEntity = tourMapper.toEntity(tour);

        // Assert
        assertEquals(tour.getId(), tourEntity.getId());
        assertEquals(tour.getName(), tourEntity.getName());
        //System.out.println(tourEntity.getTourLogs());
    }
}