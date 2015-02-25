package org.postits.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.postits.model.Category;
import org.postits.model.Note;

public class CategoryDAOImpl implements CategoryDAO {

	private static final Logger LOGGER = LogManager
			.getLogger(CategoryDAOImpl.class);

	@Inject
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.postits.dao.CategoryDAO#getCategoryNote(org.postits.model.Category)
	 */
	@Override
	public List<Note> getCategoryNote(String cat) {
		List<Note> list = new ArrayList<Note>();
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Notes where Note.category.name=:name");
		q.setParameter("name", cat);
		@SuppressWarnings("unchecked")
		// permet de ne pas saturer la memoire
		Iterator<Note> iter = q.iterate();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.postits.dao.CategoryDAO#loadCategories()
	 */
	@Override
	public Map<String, String> loadCategories() {
		@SuppressWarnings("unchecked")
		List<Category> catList = sessionFactory.getCurrentSession()
				.createCriteria(Category.class).list();
		Map<String, String> map = catList.stream().collect(
				Collectors.toMap(Category::getName, Category::getName));
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.postits.dao.CategoryDAO#getCategoryFromName(java.lang.String)
	 */
	@Override
	public Category getCategoryFromName(String name) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Category as c where c.name=:name");
		q.setParameter("name", name);
		return (Category) q.uniqueResult();
	}

}
