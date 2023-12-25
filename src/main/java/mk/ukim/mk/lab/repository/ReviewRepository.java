package mk.ukim.mk.lab.repository;

import mk.ukim.mk.lab.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {


    List<Review> findByTimestampBetween(LocalDateTime minusDays, LocalDateTime plusDays);
}
