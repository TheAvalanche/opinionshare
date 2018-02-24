package lv.akurss.opinionshare.repository;

import lv.akurss.opinionshare.domain.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
}
