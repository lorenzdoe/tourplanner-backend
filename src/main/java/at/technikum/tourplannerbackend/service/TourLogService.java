package at.technikum.tourplannerbackend.service;

import at.technikum.tourplannerbackend.model.TourLog;

import java.util.List;

public interface TourLogService extends Service<TourLog> {

    List<TourLog> findByTourId(Long tourId);

}
