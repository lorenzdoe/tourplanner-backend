package at.technikum.tourplannerbackend.service.impl;

import at.technikum.tourplannerbackend.model.Tour;
import at.technikum.tourplannerbackend.service.TourService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/*
    * Tests service against database
    * requires database to be running
 */
@SpringBootTest
class TourServiceImplTest {

    @Autowired
    private TourService tourService;


    @Test
    public void testService(){
        // Arrange
        Tour tour = Tour.builder()
                .name("Wanderung")
                .description("langer Hatscher")
                .from("Scheibs")
                .to("Nebraska")
                .distance(33.)
                .estimatedTime(33.)
                .transportType("foot")
                .routeInformation("link")
                .build();

        // Act
        Tour control = tourService.addNew(tour);

        // Assert
        assertNotNull(control);
    }

    @Test
    public void testUpdate(){
        // Arrange
        Tour tour = Tour.builder()
                .name("Wanderung")
                .description("langer Hatscher")
                .from("Scheibs")
                .to("Nebraska")
                .distance(33.)
                .estimatedTime(33.)
                .transportType("foot")
                .routeInformation("link")
                .build();

        // Act
        Tour control = tourService.addNew(tour);
        control.setName("Changed");
        Tour updated = tourService.update(control);

        // Assert
        assertEquals("Changed", updated.getName());
        assertEquals(control.getId(), updated.getId());
    }

    @Test
    public void testDelete() {
        // Arrange
        	Tour tour = Tour.builder()
                    .name("Wanderung")
                    .description("langer Hatscher")
                    .from("Scheibs")
                    .to("Nebraska")
                    .distance(33.)
                    .estimatedTime(33.)
                    .transportType("foot")
                    .routeInformation("link")
                    .build();

        	// Act
        	Tour control = tourService.addNew(tour);
        	tourService.delete(control);
        	Tour notFound = tourService.findById(control.getId());

        	// Assert
        assertNull(notFound);
    }
}