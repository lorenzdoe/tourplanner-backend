package at.technikum.tourplannerbackend.controller;

import at.technikum.tourplannerbackend.model.TourLog;
import at.technikum.tourplannerbackend.service.TourLogService;
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
class TourLogControllerTest {

    @Mock
    private TourLogService tourLogService;

    private TourLogController tourLogController;

    @BeforeEach
    void setUp() {
        tourLogController = new TourLogController(tourLogService);
    }

    @Test
    void addNew_shouldReturnCreatedTourLog() {
        // Arrange
        TourLog tourLogToAdd = new TourLog();
        TourLog addedTourLog = new TourLog();
        when(tourLogService.addNew(tourLogToAdd)).thenReturn(addedTourLog);

        // Act
        ResponseEntity<TourLog> response = tourLogController.addNew(tourLogToAdd);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(addedTourLog, response.getBody());
        verify(tourLogService, times(1)).addNew(tourLogToAdd);
    }

    @Test
    void getList_shouldReturnListOfTourLogs() {
        // Arrange
        List<TourLog> tourLogList = new ArrayList<>();
        when(tourLogService.getList()).thenReturn(tourLogList);

        // Act
        ResponseEntity<List<TourLog>> response = tourLogController.getList();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(tourLogList, response.getBody());
        verify(tourLogService, times(1)).getList();
    }

    @Test
    void findByTourId_existingTourId() {
        // Arrange
        Long tourId = 1L;
        List<TourLog> tourLogs = new ArrayList<>();
        when(tourLogService.findByTourId(tourId)).thenReturn(tourLogs);

        // Act
        ResponseEntity<List<TourLog>> response = tourLogController.findByTourId(tourId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(tourLogs, response.getBody());
        verify(tourLogService, times(1)).findByTourId(tourId);
    }

    @Test
    void findByTourId_nonExistingTourId() {
        // Arrange
        Long tourId = 1L;
        when(tourLogService.findByTourId(tourId)).thenReturn(null);

        // Act
        ResponseEntity<List<TourLog>> response = tourLogController.findByTourId(tourId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(tourLogService, times(1)).findByTourId(tourId);
    }
}
