package lt.somka.samplespringproject.service.repositories;

import lt.somka.samplespringproject.domain.QuestionValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionValueRepository extends JpaRepository<QuestionValue, Integer> {
}
