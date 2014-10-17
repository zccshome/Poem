package com.zccshome.poem.bean.poem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author zccshome
 *
 */
@XmlType(propOrder={"UUID", "title", "author", "content"})
@XmlRootElement(name="abstractpoem")
@Entity
public class AbstractPoem {
	private String UUID;
	private String title;
	private String author;
	private String content;
	
	public AbstractPoem() {
		super();
	}

	public AbstractPoem(String title, String author, String content) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
	}

	public AbstractPoem(String uUID, String title, String author, String content) {
		super();
		UUID = uUID;
		this.title = title;
		this.author = author;
		this.content = content;
	}

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	@XmlElement(name="UUID")
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	@Column(name="poemTitle")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="poemAuthor")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name="poemContent")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
