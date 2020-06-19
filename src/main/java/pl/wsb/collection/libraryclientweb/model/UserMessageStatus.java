package pl.wsb.collection.libraryclientweb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the user_message_status database table.
 * 
 */
@Entity
@Table(name="user_message_status", catalog = "collection_management")
public class UserMessageStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	//bi-directional many-to-one association to MessageStatus
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="status_id", nullable=false)
	private MessageStatus messageStatus;

	//bi-directional many-to-one association to Message
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="message_id", nullable=false)
	private Messages messages;

	//bi-directional many-to-one association to UserAccount
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	private UserAccount userAccount;

	public UserMessageStatus() {
	}


	public UserMessageStatus(Date created, Date modified, MessageStatus messageStatus, Messages message, UserAccount userAccount){
		this.created = created;
		this.modified = modified;
		this.messageStatus = messageStatus;
		this.messages = message;
		this.userAccount = userAccount;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public MessageStatus getMessageStatus() {
		return this.messageStatus;
	}

	public void setMessageStatus(MessageStatus messageStatus) {
		this.messageStatus = messageStatus;
	}

	public Messages getMessages() {
		return this.messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}