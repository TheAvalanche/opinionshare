package lv.akurss.opinionshare.rest;

import com.google.common.collect.Lists;
import lv.akurss.opinionshare.domain.Opinion;
import lv.akurss.opinionshare.domain.Topic;
import lv.akurss.opinionshare.repository.OpinionRepository;
import lv.akurss.opinionshare.repository.TopicRepository;
import lv.akurss.opinionshare.rest.converters.OpinionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/opinion")
public class OpinionController {
	
	@Autowired
	private OpinionRepository opinionRepository;
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private OpinionConverter converter;
	
	@RequestMapping(path = "/{topicId}", method = RequestMethod.POST)
	public Long add(@PathVariable("topicId") Long topicId, @RequestBody OpinionBean bean) {
		Topic topic = topicRepository.findOne(topicId);

		Opinion opinion = new Opinion();
		opinion.setTitle(bean.title);
		opinion.setTopic(topic);
		
		opinionRepository.save(opinion);
		return opinion.getId();
	}
	
	@RequestMapping(path = "/{topicId}", method = RequestMethod.GET)
	public List<OpinionBean> getAll(@PathVariable("topicId") Long topicId) {
		
		Topic topic =  topicRepository.findOne(topicId);
		
		Iterable<Opinion> opinions = opinionRepository.findAllByTopic(topic);
		
		return Lists.newArrayList(converter.convert(opinions));
		
	}
	
	@RequestMapping(path = "/{topicId}/{id}/increment", method = RequestMethod.POST)
	public Integer increment(@PathVariable("topicId") Long topicId, @PathVariable("id") Long id) {
		Topic topic = topicRepository.findOne(topicId);
		Optional<Opinion> opt = topic.getOpinions().stream()
													.filter(it -> it.getId().equals(id))
													.findFirst();
		opt.ifPresent(it -> {
			it.setRating(it.getRating() + 1);
			opinionRepository.save(it);
		});
		return opt.map(it -> it.getRating()).orElse(0);
	}

	@RequestMapping(path = "/{topicId}/{id}/decrement", method = RequestMethod.POST)
	public Integer decrement(@PathVariable("topicId") Long topicId, @PathVariable("id") Long id) {
		Topic topic = topicRepository.findOne(topicId);
		Optional<Opinion> opt = topic.getOpinions().stream()
				.filter(it -> it.getId().equals(id))
				.findFirst();
		opt.ifPresent(it -> {
			it.setRating(it.getRating() - 1);
			opinionRepository.save(it);
		});
		return opt.map(it -> it.getRating()).orElse(0);
	}
	
}
