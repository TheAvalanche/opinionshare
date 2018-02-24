package lv.akurss.opinionshare.repository;

import lv.akurss.opinionshare.domain.Opinion;
import org.springframework.data.repository.CrudRepository;

public interface OpinionRepository extends CrudRepository<Opinion, Long> {
}
