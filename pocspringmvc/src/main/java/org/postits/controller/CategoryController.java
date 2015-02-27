package org.postits.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.postits.dao.CategoryDAO;
import org.postits.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = { "/category" })
public class CategoryController {

	@Inject
	private CategoryDAO categoryDAO;

	@Transactional
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ModelAndView readAllNote(@PathVariable String cat) {
		List<Note> noteList = categoryDAO.getCategoryNote(cat);
		return new ModelAndView("notes", "noteList", noteList);
	}
}
