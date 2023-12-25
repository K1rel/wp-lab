package mk.ukim.mk.lab.web.controller;

import lombok.RequiredArgsConstructor;
import mk.ukim.mk.lab.model.Review;
import mk.ukim.mk.lab.repository.ReviewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @GetMapping
    public List<Review> listReviews() {
        return reviewRepository.findByTimestampBetween(LocalDateTime.now().minusDays(5), LocalDateTime.now().plusDays(6));
    }
}
