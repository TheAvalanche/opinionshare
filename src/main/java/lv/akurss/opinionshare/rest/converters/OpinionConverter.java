package lv.akurss.opinionshare.rest.converters;

import lv.akurss.opinionshare.domain.Opinion;
import lv.akurss.opinionshare.rest.OpinionBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OpinionConverter {
	
	public Iterable<OpinionBean> convert(Iterable<Opinion> opinions) {
		List<OpinionBean> list = new ArrayList<>();
		opinions.forEach(it -> list.add(convert(it)));
		return list;
	}
	
	public OpinionBean convert(Opinion opinion) {
		OpinionBean bean = new OpinionBean();
		bean.title = opinion.getTitle();
		bean.rating = opinion.getRating();
		bean.id = opinion.getId();
		return bean;
	}

}
