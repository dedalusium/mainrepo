package org.postits.hibernateonly.main;

import java.util.List;

import org.hibernate.Session;
import org.postits.hibernateonly.util.HibernateUtil;
import org.postits.model.Note;

public class Main {

	public static void main(String[] args) {
		Main mgr = new Main();

		List<Note> notes = mgr.listNotes();
		for (Note note : notes) {
			System.out.println("Note: " + note.getTitle() + " Time: "
					+ note.getCreationDate());
		}

		if (notes.isEmpty()) {

			Note note = new Note();
			note.setTitle("My Note");

			mgr.createAndStoreEvent(note);

			note.setTitle("My Note 2");

			// 1 new => 2 insert en DB

			mgr.createAndStoreEvent(note);

		}

		HibernateUtil.getSessionFactory().close();
	}

	private void createAndStoreEvent(Note note) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// note est transient
		session.beginTransaction();
		session.save(note);
		// note est persistent
		session.getTransaction().commit();
		// note est detached si la session est detruite (pas forcement le cas
		// dans spring)
	}

	private List<Note> listNotes() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Note> result = session.createQuery("from Note").list();
		session.getTransaction().commit();

		return result;
	}

}
