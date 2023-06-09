package at.technikum.tourplannerbackend.persistance.entities;

import at.technikum.tourplannerbackend.utils.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TourLogEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private Date dateTime;
        private String comment;
        private Difficulty difficulty;
        // time in minutes
        private Integer totalTime;
        private Integer rating;
        @ManyToOne
        @JoinColumn(name = "tour_id")
        private TourEntity tour;

        @Override
        public String toString() {
                return "TourLogEntity{" +
                        "id=" + id +
                        ", dateTime=" + dateTime +
                        ", comment='" + comment + '\'' +
                        ", difficulty=" + difficulty +
                        ", totalTime=" + totalTime +
                        ", rating=" + rating +
                        ", tour=" + (tour != null ? tour.getName() : "null") +
                        '}';
        }
}
