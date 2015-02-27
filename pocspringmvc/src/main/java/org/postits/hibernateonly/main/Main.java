package org.postits.hibernateonly.main;

import java.util.List;

import org.hibernate.Session;
import org.postits.hibernateonly.util.HibernateUtil;
import org.postits.model.Note;

public class Main {

	public static void main(String[] args) {
		// testReadAndWrite();
		secondCacheLevelTest();
		HibernateUtil.getSessionFactory().close();
	}

	private static void testReadAndWrite() {
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

	private static void secondCacheLevelTest() {
		Note note = new Note();
		note.setContent("note pour test de cache");
		note.setTitle("Test de cache");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(note);
		System.out.println("Creation de l objet en BDD");
		session.getTransaction().commit();
		System.out.println("Commit en BDD");
		note = (Note) session.load(Note.class, note.getId());
		System.out
				.println("Note: " + note.getTitle() + "/" + note.getContent());
		System.out.println("Vidage du cache de session (premier niveau)");
		session.clear();
		note = (Note) session.load(Note.class, note.getId());
		System.out
				.println("Note: " + note.getTitle() + "/" + note.getContent());
		System.out.println("Fermeture de la premiere session hibernate");
		session.close();

		System.out.println("Ouverture d'une seconde session hibernate");
		Session secondSession = HibernateUtil.getSessionFactory().openSession();
		secondSession.beginTransaction();
		note = (Note) secondSession.load(Note.class, note.getId());
		System.out
				.println("Note: " + note.getTitle() + "/" + note.getContent());
		System.out.println("Fermeture de la seconde session hibernate");
		secondSession.close();
	}

}
