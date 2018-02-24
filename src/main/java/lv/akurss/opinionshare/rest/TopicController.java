package lv.akurss.opinionshare.rest;

import lv.akurss.opinionshare.domain.Topic;
import lv.akurss.opinionshare.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	private TopicRepository topicRepository;

	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody TopicBean bean) {
		Topic topic = new Topic();
		topic.setTitle(bean.title);
		topic.setUrl(bean.url);
		
		topicRepository.save(topic);
	}

}
