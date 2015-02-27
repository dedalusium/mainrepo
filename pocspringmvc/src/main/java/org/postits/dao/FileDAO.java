package org.postits.dao;

import java.util.List;

import org.postits.model.File;

public interface FileDAO {
	public void createFile(File file);

	public void updateFile(File file);

	public File getFile(int id);

	public List<File> getFile();

}
