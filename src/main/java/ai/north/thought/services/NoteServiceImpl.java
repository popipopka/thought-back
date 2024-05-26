package ai.north.thought.services;

import ai.north.thought.dto.basic.NoteDTO;
import ai.north.thought.dto.create.NoteCreateDTO;
import ai.north.thought.dto.update.NoteUpdateDTO;
import ai.north.thought.exceptions.EntryNotFoundException;
import ai.north.thought.mappers.NoteMapper;
import ai.north.thought.models.Note;
import ai.north.thought.models.User;
import ai.north.thought.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    private final MessageSource messageSource;

    private final NoteMapper noteMapper;

    @Override
    public NoteDTO createNote(User user, NoteCreateDTO noteCreateDTO) {
        Note note = noteMapper.toEntity(noteCreateDTO);
        note.setUser(user);

        note = noteRepository.save(note);

        return noteMapper.toDTO(note);
    }

    @Override
    public NoteDTO getNote(int noteId) throws EntryNotFoundException {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new EntryNotFoundException(messageSource
                        .getMessage("error.notfound.note", new Object[0], Locale.getDefault())));

        return noteMapper.toDTO(note);
    }

    @Override
    public List<NoteDTO> getAllNote(User user) {
        return noteRepository.findAllByUser(user)
                .stream()
                .map(noteMapper::toDTO)
                .toList();
    }

    @Override
    public void updateNote(int noteId, NoteUpdateDTO noteUpdateDTO) throws EntryNotFoundException {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new EntryNotFoundException(messageSource
                        .getMessage("error.notfound.note", new Object[0], Locale.getDefault())));

        noteMapper.updateEntity(note, noteUpdateDTO);

        noteRepository.save(note);
    }

    @Override
    public void deleteNote(int noteId) {
        noteRepository.deleteById(noteId);
    }
}
