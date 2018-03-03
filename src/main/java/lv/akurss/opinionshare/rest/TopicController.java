package lv.akurss.opinionshare.rest;

import com.google.common.collect.Lists;
import lv.akurss.opinionshare.domain.Topic;
import lv.akurss.opinionshare.repository.TopicRepository;
import lv.akurss.opinionshare.rest.converters.TopicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private TopicConverter converter;

	@RequestMapping(method = RequestMethod.POST)
	public Long add(@RequestBody TopicBean bean) {
		Topic topic = new Topic();
		topic.setTitle(bean.title);
		topic.setUrl(bean.url);
		
		topicRepository.save(topic);
		return topic.getId();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TopicBean> getAll() {
		Iterable<Topic> topics = topicRepository.findAll();
		return Lists.newArrayList(converter.convert(topics));
	}

}
