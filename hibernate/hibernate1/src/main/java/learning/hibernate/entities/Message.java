package learning.hibernate.entities;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@org.hibernate.annotations.Entity(dynamicInsert=true/*insert only not null*/,dynamicUpdate=true /*update only changed*/)
@Table(name="messages")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="text")
	private String text;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	//@JoinTable(name="messages",joinColumns=@JoinColumn(name="nextMessageId",nullable=true),inverseJoinColumns=@JoinColumn(name="id"))
	// the join table is specific but it seem that i can not make it nullable - IT;S NOT NULL BY DEFAULT
	private Message nextMessage;
	
	
	@Transient
	private String dontPersist;
	
	@Basic(optional=false) /*enforce not null at java level*/
	@Column(nullable=false)/*only creates the NOT NUL CONSTRAINT*/
	private String notNullEnforcedAt;
	
	public Message(){}
	
	public Message(String text){
		this.text = text;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Message getNextMessage() {
		return nextMessage;
	}
	public void setNextMessage(Message nextMessage) {
		this.nextMessage = nextMessage;
	}	
}
