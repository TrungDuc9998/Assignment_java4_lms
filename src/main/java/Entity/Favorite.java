package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the favorites database table.
 * 
 */
@Entity
@Table(name="favorites")
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int isLike;

	@Temporal(TemporalType.DATE)
	@Column(name="like_date")
	private Date likeDate;

//	@Column(name="user_id")
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;

	@ManyToOne
	@JoinColumn(name="video_id")
	private Video video;

	public Favorite() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsLike() {
		return this.isLike;
	}

	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}

	public Date getLikeDate() {
		return this.likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
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