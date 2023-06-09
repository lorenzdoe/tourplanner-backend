package at.technikum.tourplannerbackend.persistance.repositories;

import at.technikum.tourplannerbackend.persistance.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {

}
