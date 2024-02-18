package spring_HW6.sem6.services;

import spring_HW6.sem6.model.Note;

import java.util.List;

public interface NoteService {

    Note createNote(Note note);

    List<Note> getAll();

    Note getNoteById(long id);

    Note editNote(Note note);

    void delete(long id);
}
