package ai.north.thought.repositories;

import ai.north.thought.models.Note;
import ai.north.thought.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByUser(User user);
}
