package org.postits.dao;

import java.util.List;

import org.postits.model.Note;

public interface NoteDAO {

	public void createNote(Note note);

	public void updateNote(Note note);

	public Note readNote(long id);

	public void deleteNote(long id);

	public List<Note> readAllNotes();

}
