package at.technikum.tourplannerbackend.persistance;

import at.technikum.tourplannerbackend.persistance.repositories.TourLogRepository;
import at.technikum.tourplannerbackend.persistance.repositories.TourRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements InitializingBean {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourLogRepository tourLogRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Database");
    }
}
