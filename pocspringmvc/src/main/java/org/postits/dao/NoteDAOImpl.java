package org.postits.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.postits.model.Note;

public class NoteDAOImpl implements NoteDAO {

	private static final Logger LOGGER = LogManager
			.getLogger(NoteDAOImpl.class);

	@Inject
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createNote(Note note) {
		sessionFactory.getCurrentSession().save(note);
	}

	@Override
	public void updateNote(Note note) {
		sessionFactory.getCurrentSession().merge(note); // hibernate verifie
		// que l enregistrement existe
		// sessionFactory.getCurrentSession().update(note); // hibernate ne
		// verifie
		// pas que l
		// enregistrement
		// existe
	}

	@Override
	public Note readNote(long id) {

		// renvoie un proxy sur l'objet
		// le select sera execute qu a l utilisation de l objet plus tard
		// uniquement s il est absent du cache
		// lance une exeption en cas de ligne inexistante en bdd

		// Note note = (Note)
		// sessionFactory.getCurrentSession().load(Note.class,
		// id);

		// force le select en BDD, renvoi null si la ligne est introuvable
		// obligatoire avec spring mvc, si non une erreur surviendra dans la
		// view
		// le proxy n etant pas le vrai objet
		Note note = (Note) sessionFactory.getCurrentSession().get(Note.class,
				id);
		return note;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> readAllNotes() {
		return sessionFactory.getCurrentSession().createQuery("from Note")
				.setCacheable(true).list();
	}

	@Override
	public void deleteNote(long id) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"delete from Note where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		// le traitement ci dessous est moins performant
		// Note note = this.readNote(id);
		// sessionFactory.getCurrentSession().delete(note);
	}

}
