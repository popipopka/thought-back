package ai.north.thought.services;

import ai.north.thought.dto.basic.NoteDTO;
import ai.north.thought.dto.create.NoteCreateDTO;
import ai.north.thought.dto.update.NoteUpdateDTO;
import ai.north.thought.exceptions.EntryNotFoundException;
import ai.north.thought.models.User;

import java.util.List;

/**
 * Сервис для сущности {@link ai.north.thought.models.Note}
 */
public interface NoteService {
    /**
     * Создание заметки для пользователя
     * @param user пользователь
     * @param noteCreateDTO данные для создания
     * @return созданная заметка
     */
    NoteDTO createNote(User user, NoteCreateDTO noteCreateDTO);

    /**
     * Получения заметки
     * @param noteId id заметки
     * @return найденная заметка
     * @throws EntryNotFoundException заметка не найдена
     */
    NoteDTO getNote(int noteId) throws EntryNotFoundException;

    /**
     * Получения всех заметок пользователя
     * @param user пользователь
     * @return найденные заметки
     */
    List<NoteDTO> getAllNote(User user);

    /**
     * Обновление заметки
     * @param noteId id заметки
     * @param noteUpdateDTO данные для обновления
     * @throws EntryNotFoundException заметка не найдена
     */
    void updateNote(int noteId, NoteUpdateDTO noteUpdateDTO) throws EntryNotFoundException;

    /**
     * Удаление заметки
     * @param noteId id заметки
     */
    void deleteNote(int noteId);
}
