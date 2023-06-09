package at.technikum.tourplannerbackend.service.impl;

import at.technikum.tourplannerbackend.model.Tour;
import at.technikum.tourplannerbackend.model.TourLog;
import at.technikum.tourplannerbackend.service.Service;
import at.technikum.tourplannerbackend.service.TourLogService;
import at.technikum.tourplannerbackend.utils.Difficulty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TourLogServiceImplTest {

    @Autowired
    private TourLogService tourLogService;

    @Autowired
    private Service<Tour> tourService;

    @Test
    public void testService(){
        // Arrange
        Tour controlTour = tourService.addNew(Tour.builder()
                .name("Wanderung")
                .build());

        TourLog tourLog = TourLog.builder()
                .comment("Wanderung")
                .rating(5)
                .difficulty(Difficulty.EASY)
                .TourId(controlTour.getId())
                .build();
        TourLog tourLog1 = TourLog.builder()
                .comment("Hatscher")
                .rating(8)
                .difficulty(Difficulty.EASY)
                .TourId(controlTour.getId())
                .build();

        // Act
        //tourLog.setTour(controlTour);
        //tourLog1.setTour(controlTour);
        tourLogService.addNew(tourLog);
        tourLogService.addNew(tourLog1);
        List<TourLog> tourLogs = tourLogService.findByTourId(controlTour.getId());

        // Assert
        assertNotNull(controlTour);
        assertNotNull(tourLogs);
        assertEquals(2, tourLogs.size());
    }

    @Test
    void findById_delete() {
        // Arrange
        Tour controlTour = tourService.addNew(Tour.builder()
                .name("Wanderung")
                .build());
        TourLog tourLog = TourLog.builder()
                .comment("Wanderung")
                .rating(5)
                .difficulty(Difficulty.EASY)
                .TourId(controlTour.getId())
                .build();
        TourLog added = tourLogService.addNew(tourLog);

        // Act
        TourLog find = tourLogService.findById(added.getId());
        tourLogService.delete(find);
        TourLog notFound = tourLogService.findById(find.getId());

        // Assert
        assertNotNull(find);
        assertEquals(tourLog.getComment(), find.getComment());
        assertNull(notFound);
    }
}