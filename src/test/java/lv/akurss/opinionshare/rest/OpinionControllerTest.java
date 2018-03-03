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
public class OpinionControllerTest {
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void addAndGetOpinions() {
		
		TopicBean topicBean = new TopicBean();
		topicBean.title = "Test title";
		topicBean.url = "Test url";

		ResponseEntity<Long> response = restTemplate.postForEntity("/topic", topicBean, Long.class);
		
		Long id = response.getBody();
		
		OpinionBean opinionBean = new OpinionBean();
		opinionBean.title = "Test opinion title";
		
		ResponseEntity<Long> response2 = restTemplate.postForEntity("/opinion/" + id, opinionBean, Long.class);
		
		ResponseEntity<OpinionBean[]> response3 = restTemplate.getForEntity("/opinion/" + id, OpinionBean[].class);
		
		OpinionBean[] beans = response3.getBody();

		Assert.assertEquals(1, beans.length);

		OpinionBean bean = beans[0];
		
		Assert.assertNotNull(bean.id);
		Assert.assertEquals("Test opinion title", bean.title);
		Assert.assertEquals(new Integer(0), bean.rating);
		
		ResponseEntity<Integer> response4 = restTemplate.postForEntity(
				"/opinion/" + id + "/" + bean.id + "/increment", 
				null, 
				Integer.class);
		Assert.assertEquals(new Integer(1), response4.getBody());

		ResponseEntity<Integer> response5 = restTemplate.postForEntity(
				"/opinion/" + id + "/" + bean.id + "/decrement",
				null,
				Integer.class);
		Assert.assertEquals(new Integer(0), response5.getBody());
		
		
		
		
	}
	
}