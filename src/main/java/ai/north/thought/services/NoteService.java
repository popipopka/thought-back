package ai.north.thought.services;

import ai.north.thought.dto.basic.NoteDTO;
import ai.north.thought.dto.create.NoteCreateDTO;
import ai.north.thought.dto.update.NoteUpdateDTO;
import ai.north.thought.exceptions.EntryNotFoundException;
import ai.north.thought.models.User;

import java.util.List;

public interface NoteService {
    NoteDTO createNote(User user, NoteCreateDTO noteCreateDTO);

    NoteDTO getNote(int noteId) throws EntryNotFoundException;

    List<NoteDTO> getAllNote(User user);

    void updateNote(int noteId, NoteUpdateDTO noteUpdateDTO) throws EntryNotFoundException;

    void deleteNote(int noteId);
}
