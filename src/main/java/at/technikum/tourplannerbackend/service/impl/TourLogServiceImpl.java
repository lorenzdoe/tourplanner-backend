package at.technikum.tourplannerbackend.service.impl;

import at.technikum.tourplannerbackend.model.TourLog;
import at.technikum.tourplannerbackend.persistance.entities.TourLogEntity;
import at.technikum.tourplannerbackend.persistance.repositories.TourLogRepository;
import at.technikum.tourplannerbackend.service.TourLogService;
import at.technikum.tourplannerbackend.service.mapper.TourLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class TourLogServiceImpl implements TourLogService {

    @Autowired
    private TourLogRepository tourLogRepository;

    @Autowired
    private TourLogMapper tourLogMapper;

    @Override
    public List<TourLog> getList() {
        return tourLogMapper.fromEntity(tourLogRepository.findAll());
    }

    @Override
    public TourLog addNew(TourLog tourLog) {
        if(tourLog == null){
            return null;
        }
        return tourLogMapper.fromEntity(tourLogRepository.save(tourLogMapper.toEntity(tourLog)));
    }

    @Override
    public TourLog findById(Long id) {

        TourLogEntity tourLogEntity = tourLogRepository.findById(id).orElse(null);

        return tourLogMapper.fromEntity(tourLogEntity);
    }

    @Override
    public void delete(TourLog tourLog) {
        if(tourLog == null){
            return;
        }
        tourLogRepository.delete(tourLogMapper.toEntity(tourLog));
    }

    @Override
    public TourLog update(TourLog tourLog) {
        if(tourLog == null){
            return null;
        }
        return tourLogMapper.fromEntity(tourLogRepository.save(tourLogMapper.toEntity(tourLog)));
    }

    @Override
    public List<TourLog> findByTourId(Long id) {
        return tourLogMapper.fromEntity(tourLogRepository.findByTourId(id));
    }

}
