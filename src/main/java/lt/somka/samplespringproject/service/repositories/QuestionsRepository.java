package lt.somka.samplespringproject.service.repositories;

import lt.somka.samplespringproject.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Question, Integer> {
}
