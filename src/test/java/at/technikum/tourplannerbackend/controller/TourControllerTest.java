package at.technikum.tourplannerbackend.controller;

import at.technikum.tourplannerbackend.model.Tour;
import at.technikum.tourplannerbackend.service.TourService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TourControllerTest {

    @Mock
    private TourService tourService;

    private TourController tourController;

    @BeforeEach
    void setUp() {
        tourController = new TourController(tourService);
    }

    @Test
    void addNew_shouldReturnCreatedTour() {
        // Arrange
        Tour tourToAdd = new Tour();
        Tour addedTour = new Tour();
        when(tourService.addNew(tourToAdd)).thenReturn(addedTour);

        // Act
        ResponseEntity<Tour> response = tourController.addNew(tourToAdd);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(addedTour, response.getBody());
        verify(tourService, times(1)).addNew(tourToAdd);
    }

    @Test
    void getList_shouldReturnListOfTours() {
        // Arrange
        List<Tour> tourList = new ArrayList<>();
        when(tourService.getList()).thenReturn(tourList);

        // Act
        ResponseEntity<List<Tour>> response = tourController.getList();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(tourList, response.getBody());
        verify(tourService, times(1)).getList();
    }

    @Test
    void delete_shouldReturnOK() {
        // Arrange
        Tour toDelete = Tour.builder().id(1L).name("Test").build();
        doNothing().when(tourService).delete(toDelete);
        when(tourService.findById(toDelete.getId())).thenReturn(toDelete);

        // Act
        ResponseEntity<Void> response = tourController.delete(toDelete.getId());

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(tourService, times(1)).delete(toDelete);
    }

    @Test
    void findById_existingId() {
        // Arrange
        Long id = 1L;
        Tour tour = Tour.builder().id(id).build();
        when(tourService.findById(id)).thenReturn(tour);

        // Act
        ResponseEntity<Tour> response = tourController.findById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(tour, response.getBody());
        verify(tourService, times(1)).findById(id);
    }

    @Test
    void findById_nonExistingId() {
        // Arrange
        Long id = 1L;
        when(tourService.findById(id)).thenReturn(null);

        // Act
        ResponseEntity<Tour> response = tourController.findById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(tourService, times(1)).findById(id);
    }

}
