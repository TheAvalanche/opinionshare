package lv.akurss.opinionshare.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "seq_gen", sequenceName = "topics_seq")
@Entity
@Table(name="topics")
public class Topic {
	
	@Id
	@GeneratedValue(generator="seq_gen", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "created", nullable = false)
	private LocalDateTime created = LocalDateTime.now();
	
	@Column(name = "updated", nullable = false)
	private LocalDateTime updated = LocalDateTime.now();
	
	@Version
	@Column(name = "version", nullable = false)
	private Long version;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "url", length = 2048)
	private String url;
	
	@OneToMany(mappedBy = "topic", 
			fetch = FetchType.LAZY, 
			orphanRemoval = true,
			cascade = CascadeType.ALL)
	private List<Opinion> opinions = new ArrayList<>();

	public Topic() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}
}
