package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="comment_date")
	private Date commentDate;

	private String commentContent;

	@ManyToOne
	@JoinColumn(name="user_id")
	User user;

	@ManyToOne
	@JoinColumn(name="video_id")
	private Video video;

	public Comment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public User getUserId() {
		return this.user;
	}

	public void setUserId(User user) {
		this.user = user;
	}

	public Video getVideoId() {
		return this.video;
	}

	public void setVideoId(Video video) {
		this.video = video;
	}

}