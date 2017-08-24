package lt.somka.samplespringproject.service.repositories;

import lt.somka.samplespringproject.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<Answer, Integer> {
}
