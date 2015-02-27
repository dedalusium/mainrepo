package org.postits.model.presentation;

import java.util.Date;

import javax.persistence.PreUpdate;

public class NoteForm {
	/** The id. */
	private long id;

	/** The title. */
	private String title;

	/** The content. */
	private String content;

	/** The category. */
	private String category;

	/** The creation date. */
	private final Date creationDate;

	/** The last modification. */
	private Date lastModification;

	public NoteForm() {
		creationDate = new Date();
		lastModification = new Date();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content
	 *            the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Gets the last modification.
	 *
	 * @return the last modification
	 */
	public Date getLastModification() {
		return lastModification;
	}

	@PreUpdate
	public void setLastModification() {
		this.lastModification = new Date();
	}
}
