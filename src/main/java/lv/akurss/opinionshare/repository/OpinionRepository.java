package lv.akurss.opinionshare.repository;

import lv.akurss.opinionshare.domain.Opinion;
import lv.akurss.opinionshare.domain.Topic;
import org.springframework.data.repository.CrudRepository;

public interface OpinionRepository extends CrudRepository<Opinion, Long> {
	
	Iterable<Opinion> findAllByTopic(Topic topic);	
}
