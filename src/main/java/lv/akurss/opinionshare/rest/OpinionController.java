package lv.akurss.opinionshare.rest;

import lv.akurss.opinionshare.domain.Opinion;
import lv.akurss.opinionshare.domain.Topic;
import lv.akurss.opinionshare.repository.OpinionRepository;
import lv.akurss.opinionshare.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/opinion")
public class OpinionController {
	
	@Autowired
	private OpinionRepository opinionRepository;
	@Autowired
	private TopicRepository topicRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody OpinionBean bean) {
		Topic topic = topicRepository.findOne(bean.topicId);

		Opinion opinion = new Opinion();
		opinion.setTitle(bean.title);
		opinion.setTopic(topic);
		
		opinionRepository.save(opinion);
	}
	
}
