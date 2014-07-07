package com.zccshome.spring_mvc_test.bean.poem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.zccshome.spring_mvc_test.hibernate.common.BaseModelObject;

@Entity
public class Poem {
	private Integer poemId;
	private String bookNum;
	private String poemNum;
	private String title;
	private String author;
	private String content;

	
	@Id
	@GeneratedValue
	public Integer getPoemId() {
		return poemId;
	}

	public void setPoemId(Integer poemId) {
		this.poemId = poemId;
	}
	
	@Column(name="poemBookNum", length = 3, nullable = false)
	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	@Column(name="poemPoemNum", length = 3, nullable = false)
	public String getPoemNum() {
		return poemNum;
	}

	public void setPoemNum(String poemNum) {
		this.poemNum = poemNum;
	}

	@Column(name="poemTitle")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="poemAuthor", length = 10, nullable = false)
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

	@Override
	public String toString() {
		return "Poem [bookNum=" + bookNum + ", poemNum="
				+ poemNum + ", title=" + title + ", author=" + author
				+ ", content=" + content + "]";
	}
}
