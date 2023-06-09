package at.technikum.tourplannerbackend.controller;

import at.technikum.tourplannerbackend.model.TourLog;
import at.technikum.tourplannerbackend.service.TourLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour-logs")
@CrossOrigin
@Slf4j
public class TourLogController extends Controller<TourLog> {

    private final TourLogService tourLogService;

    TourLogController(@Autowired TourLogService tourLogService) {
        super(tourLogService);
        this.tourLogService = tourLogService;
    }

    @GetMapping("/tourId={tourId}")
    public ResponseEntity<List<TourLog>> findByTourId(@PathVariable("tourId") Long id) {
        try {
            List<TourLog> tourLogs = this.tourLogService.findByTourId(id);
            return tourLogs != null ? ResponseEntity.ok(tourLogs) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
