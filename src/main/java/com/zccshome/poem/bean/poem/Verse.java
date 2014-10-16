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
@XmlType(propOrder={"verseId", "title", "subtitle", "author", "content1", "content2"})
@XmlRootElement(name="verse")
@Entity

public class Verse {
	private Integer verseId;
	private String title;
	private String subtitle;
	private String author;
	private String content1;
	private String content2;
	
	public Verse() {
		super();
	}

	public Verse(Integer verseId, String title, String subtitle, String author,
			String content1, String content2) {
		super();
		this.verseId = verseId;
		this.title = title;
		this.subtitle = subtitle;
		this.author = author;
		this.content1 = content1;
		this.content2 = content2;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "verseId")
	@XmlElement(name="verseId")
	public Integer getVerseId() {
		return verseId;
	}

	public void setVerseId(Integer verseId) {
		this.verseId = verseId;
	}

	@Column(name="title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="subtitle")
	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Column(name="author", nullable = false)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name="content1", nullable = false)
	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	@Column(name="content2")
	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	@Override
	public String toString() {
		return "Verse [verseId=" + verseId + ", title=" + title + ", subtitle="
				+ subtitle + ", author=" + author + ", content1=" + content1
				+ ", content2=" + content2 + "]";
	}
}
