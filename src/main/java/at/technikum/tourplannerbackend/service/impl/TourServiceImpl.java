package at.technikum.tourplannerbackend.service.impl;

import at.technikum.tourplannerbackend.model.Tour;
import at.technikum.tourplannerbackend.persistance.entities.TourEntity;
import at.technikum.tourplannerbackend.persistance.repositories.TourRepository;
import at.technikum.tourplannerbackend.service.TourService;
import at.technikum.tourplannerbackend.service.mapper.TourLogMapper;
import at.technikum.tourplannerbackend.service.mapper.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourMapper tourMapper;

    @Autowired
    private TourLogMapper tourLogMapper;

    @Override
    public List<Tour> getList() {
        return tourMapper.fromEntity(tourRepository.findAll());
    }

    @Override
    public Tour addNew(Tour tour) {
        if(tour == null){
            return null;
        }
        TourEntity tourEntity = tourMapper.toEntity(tour);
        return tourMapper.fromEntity(tourRepository.save(tourEntity));
    }

    @Override
    public Tour findById(Long id){

        TourEntity tourEntity = tourRepository.findById(id).orElse(null);

        return tourMapper.fromEntity(tourEntity);
    }

    @Override
    public void delete(Tour tour) {
        tourRepository.delete(tourMapper.toEntity(tour));
    }

    @Override
    public Tour update(Tour tour) {
        if (tour == null) {
            return null;
        }
        return tourMapper.fromEntity(tourRepository.save(tourMapper.toEntity(tour)));
    }

}
