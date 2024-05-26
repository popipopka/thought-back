package ai.north.thought.controllers;

import ai.north.thought.dto.basic.NoteDTO;
import ai.north.thought.dto.create.NoteCreateDTO;
import ai.north.thought.dto.update.NoteUpdateDTO;
import ai.north.thought.exceptions.EntryNotFoundException;
import ai.north.thought.models.User;
import ai.north.thought.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@AuthenticationPrincipal User user,
                                              @RequestBody NoteCreateDTO noteCreateDTO,
                                              UriComponentsBuilder uriComponentsBuilder) {
        NoteDTO note = noteService.createNote(user, noteCreateDTO);

        return ResponseEntity.created(uriComponentsBuilder
                        .path("api/notes")
                        .build()
                        .toUri())
                .body(note);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNote(@PathVariable int id) throws EntryNotFoundException {
        NoteDTO note = noteService.getNote(id);

        return ResponseEntity.ok(note);
    }

    @GetMapping
    public ResponseEntity<List<NoteDTO>> getAllNote(@AuthenticationPrincipal User user) {
        List<NoteDTO> notes = noteService.getAllNote(user);

        return notes.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(notes);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateNote(@PathVariable int id,
                                           @RequestBody NoteUpdateDTO noteUpdateDTO) throws EntryNotFoundException {
        noteService.updateNote(id, noteUpdateDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable int id) {
        noteService.deleteNote(id);

        return ResponseEntity.ok().build();
    }
}
