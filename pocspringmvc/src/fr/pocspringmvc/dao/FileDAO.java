package fr.pocspringmvc.dao;

import java.util.List;

import fr.pocspringmvc.model.File;

public interface FileDAO {
	public void createFile(File file);

	public void updateFile(File file);

	public File getFile(int id);

	public List<File> getFile();

}
