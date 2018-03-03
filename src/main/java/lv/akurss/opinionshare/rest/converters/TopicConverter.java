package lv.akurss.opinionshare.rest.converters;

import lv.akurss.opinionshare.domain.Topic;
import lv.akurss.opinionshare.rest.TopicBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TopicConverter {

	public Iterable<TopicBean> convert(Iterable<Topic> topics) {
		List<TopicBean> list = new ArrayList<>();
		topics.forEach(it -> list.add(convert(it)));
		return list;
	}
	
	public TopicBean convert(Topic topic) {
		TopicBean bean = new TopicBean();	
		bean.title = topic.getTitle();
		bean.url = topic.getUrl();
		bean.id = topic.getId();
		return bean;
	}
	
}
