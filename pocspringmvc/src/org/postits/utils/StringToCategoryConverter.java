package org.postits.utils;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.postits.dao.CategoryDAO;
import org.postits.model.Category;
import org.springframework.core.convert.converter.Converter;

public class StringToCategoryConverter implements Converter<String, Category> {

	@Inject
	private CategoryDAO dao;

	@Override
	@Transactional
	public Category convert(String s) {
		return dao.getCategoryFromName(s);
	}

}
