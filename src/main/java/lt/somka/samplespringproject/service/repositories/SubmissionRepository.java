package lt.somka.samplespringproject.service.repositories;

import lt.somka.samplespringproject.domain.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
}
