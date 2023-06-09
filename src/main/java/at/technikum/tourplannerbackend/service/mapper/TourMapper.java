package at.technikum.tourplannerbackend.service.mapper;

import at.technikum.tourplannerbackend.model.Tour;
import at.technikum.tourplannerbackend.persistance.entities.TourEntity;
import at.technikum.tourplannerbackend.persistance.repositories.TourLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TourMapper extends AbstractMapper<TourEntity, Tour> {

    @Autowired
    private TourLogRepository tourLogRepository;

    @Override
    public Tour fromEntity(TourEntity entity) {
        if (entity == null) {
            return null;
        }
        Tour tour = Tour.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .from(entity.getFrom())
                .to(entity.getTo())
                .transportType(entity.getTransportType())
                .distance(entity.getDistance())
                .estimatedTime(entity.getEstimatedTime())
                .routeInformation(entity.getRouteInformation())
                .imagePath(entity.getImagePath())
                .build();

        return tour;
    }

    @Override
    public TourEntity toEntity(Tour tour) {
        if (tour == null) {
            return null;
        }
        TourEntity tourEntity = TourEntity.builder()
                .id(tour.getId())
                .name(tour.getName())
                .description(tour.getDescription())
                .from(tour.getFrom())
                .to(tour.getTo())
                .transportType(tour.getTransportType())
                .distance(tour.getDistance())
                .estimatedTime(tour.getEstimatedTime())
                .routeInformation(tour.getRouteInformation())
                .tourLogs(tourLogRepository.findByTourId(tour.getId()))
                .imagePath(tour.getImagePath())
                .build();

        return tourEntity;
    }
}