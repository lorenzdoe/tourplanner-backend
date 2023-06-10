package at.technikum.tourplannerbackend.controller;

import at.technikum.tourplannerbackend.model.Tour;
import at.technikum.tourplannerbackend.service.TourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tours")
@CrossOrigin
@Slf4j
public class TourController extends Controller<Tour>{

    TourController(@Autowired TourService tourService) {
        super(tourService);
    }

}
