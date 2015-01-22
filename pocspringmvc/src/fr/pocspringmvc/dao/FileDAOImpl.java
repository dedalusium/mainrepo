package fr.pocspringmvc.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import fr.pocspringmvc.model.File;

public class FileDAOImpl implements FileDAO {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<File> getFile() {
		@SuppressWarnings("unchecked")
		List<File> result = (List<File>) sessionFactory.getCurrentSession()
				.createCriteria(File.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return result;
	}

	@Override
	public void createFile(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFile(File file) {
		// TODO Auto-generated method stub

	}

	@Override
	public File getFile(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
