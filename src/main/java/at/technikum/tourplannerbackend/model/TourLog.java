package at.technikum.tourplannerbackend.model;

import at.technikum.tourplannerbackend.utils.Difficulty;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TourLog {
    private Long id;
    private Date dateTime;
    private String comment;
    private Difficulty difficulty;
    private Integer timeInMinutes;
    private Integer rating;
    private Long TourId;
    @Override
    public String toString() {
        return "TourLog{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", comment='" + comment + '\'' +
                ", difficulty=" + difficulty +
                ", totalTime=" + timeInMinutes +
                ", rating=" + rating +
                ", tourId=" + TourId +
                '}';
    }
}
