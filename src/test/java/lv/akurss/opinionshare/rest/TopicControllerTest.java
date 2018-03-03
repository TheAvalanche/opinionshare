package lv.akurss.opinionshare.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void addAndGetTopics() {

		TopicBean topicBean = new TopicBean();
		topicBean.title = "Test title";
		topicBean.url = "Test url";

		ResponseEntity<Long> response = restTemplate.postForEntity("/topic", topicBean, Long.class);
		
		ResponseEntity<TopicBean[]> response2 = restTemplate.getForEntity("/topic", TopicBean[].class);

		TopicBean[] beans = response2.getBody();

		Assert.assertEquals(1, beans.length);
		
		TopicBean bean = beans[0];
		
		Assert.assertNotNull(bean.id);
		Assert.assertEquals("Test title", bean.title);
		Assert.assertEquals("Test url", bean.url);
		
		
		
		
		
	}

}