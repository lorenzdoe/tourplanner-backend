package at.technikum.tourplannerbackend.controller;

import at.technikum.tourplannerbackend.model.Tour;
import at.technikum.tourplannerbackend.service.TourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
@CrossOrigin
@Slf4j
public class TourController extends Controller<Tour>{

    TourController(@Autowired TourService tourService) {
        super(tourService);
    }

}
