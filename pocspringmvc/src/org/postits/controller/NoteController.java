package org.postits.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.postits.dao.CategoryDAO;
import org.postits.dao.NoteDAO;
import org.postits.model.Note;
import org.postits.model.presentation.NoteForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

	@Inject
	private NoteDAO noteDAO;

	@Inject
	private CategoryDAO categoryDAO;

	@Transactional
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView readAllNote() {
		List<Note> noteList = noteDAO.readAllNotes();
		return new ModelAndView("notes", "noteList", noteList);
	}

	@Transactional
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView readNote(@PathVariable long id) {
		ModelAndView m = new ModelAndView();
		m.addObject(noteDAO.readNote(id));
		m.setViewName("note");
		return m;
	}

	@Transactional
	@RequestMapping(value = { "/create" }, method = { RequestMethod.GET })
	public ModelAndView getFormCreationNote(
			@ModelAttribute("newNote") NoteForm noteForm) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("newNote", noteForm);
		mav.addObject("categoryList", categoryDAO.loadCategories());
		mav.setViewName("formNote");
		return mav;
	}

	@Transactional
	@RequestMapping(value = { "/create" }, method = { RequestMethod.POST })
	public ModelAndView saveNote(@ModelAttribute("newNote") NoteForm noteForm) {
		Note note = new Note();
		BeanUtils.copyProperties(noteForm, note);
		note.setCategory(categoryDAO.getCategoryFromName(noteForm.getCategory()));
		noteDAO.createNote(note);
		return new ModelAndView("note", "note", note);
	}

	@Transactional
	@RequestMapping(value = { "/update/{id}" }, method = { RequestMethod.GET })
	public ModelAndView getFormUpdateNote(@PathVariable long id) {
		Note note = noteDAO.readNote(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("newNote", note);
		mav.addObject("categoryList", categoryDAO.loadCategories());
		mav.setViewName("formNote");
		return mav;
	}

	@Transactional
	@RequestMapping(value = { "/update/{id}" }, method = { RequestMethod.POST })
	public ModelAndView updateNote(@PathVariable long id,
			@ModelAttribute("newNote") NoteForm noteForm) {
		Note note = new Note();
		BeanUtils.copyProperties(noteForm, note);
		note.setId(id);
		note.setCategory(categoryDAO.getCategoryFromName(noteForm.getCategory()));
		noteDAO.updateNote(note);
		return new ModelAndView("note", "note", note);
	}

	@Transactional
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteNote(@PathVariable long id) {
		noteDAO.deleteNote(id);
		return new ModelAndView("deleteNote", "message", "Note n°" + id
				+ " deleted!");
	}

}
