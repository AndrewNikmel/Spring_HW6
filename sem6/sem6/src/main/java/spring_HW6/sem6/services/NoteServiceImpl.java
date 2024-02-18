package spring_HW6.sem6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import spring_HW6.sem6.model.Note;
import spring_HW6.sem6.repository.NoteRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;

    @Override
    public Note createNote(Note note) {
        return repository.save(note);
    }

    @Override
    public List<Note> getAll() {
        return repository.findAll();
    }

    @Override
    public Note getNoteById(long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Note editNote(Note note) {
        Optional<Note> optionalNote = repository.findById(note.getId());
        Note newNote = null;
        if (optionalNote.isPresent()) {
            newNote = optionalNote.get();
            newNote.setTitle(note.getTitle());
            newNote.setContent(note.getContent());
        }
        assert newNote != null;
        return repository.save(newNote);
    }

    @Override
    public void delete(long id) {
        Note toDelete = getNoteById(id);
        repository.delete(toDelete);
    }
}
