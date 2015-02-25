package org.postits.dao;

import java.util.List;
import java.util.Map;

import org.postits.model.Category;
import org.postits.model.Note;

public interface CategoryDAO {

	public List<Note> getCategoryNote(String cat);

	public Category getCategoryFromName(String name);

	public Map<String, String> loadCategories();

}
