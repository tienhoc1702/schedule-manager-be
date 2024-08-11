package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.NoteDAO;
import com.dto.NoteDTO;
import com.dto.NotesCountDTO;
import com.entity.Note;
import com.mapper.NoteMapper;

@Service
public class NoteService {
	@Autowired
	NoteDAO dao;	
	
	@Autowired
	NoteMapper noteMapper;
	
	public List<NoteDTO> findNotesByDate(String code,Integer day, Integer month, Integer year) {
        List<Note> NoteList = dao.findNotesByDate(code, day, month, year);
        return NoteList.stream()
                        .map(NoteMapper.INSTANCE::toDTO)
                        .collect(Collectors.toList());
    }
	
	 public NotesCountDTO countNotesByMonth(Integer month, String code) {
		 return  dao.findNotesByMonthAndStudentCode(month,code);
	         
	    }

	public NoteDTO addNote(NoteDTO noteDTO) {
        Note note = noteMapper.toEntity(noteDTO);
        Note savedNote = dao.save(note);
        return noteMapper.toDTO(savedNote);
    }

	 public Optional<NoteDTO> getNoteById(Integer id) {
	        return dao.findById(id).map(noteMapper::toDTO);
	    }

    public NoteDTO updateNoteDTO(Integer id, NoteDTO noteDTO) {
        Optional<Note> existingNoteOptional = dao.findById(id);
        if (existingNoteOptional.isPresent()) {
            Note existingNote = existingNoteOptional.get();

            // Cập nhật các thuộc tính của existingNote từ noteDTO
            existingNote.setContent(noteDTO.getContent());
            Date sqlDate = new Date(noteDTO.getDate().getTime());
            existingNote.setDate(sqlDate);
            existingNote.setTimeNote(noteDTO.getTimeNote());
            existingNote.setLocation(noteDTO.getLocation());

            Note updatedNote = dao.save(existingNote);
            return noteMapper.toDTO(updatedNote);
        }
        return null;
    }
    
    public void deleteNoteById(Integer id) {
        dao.deleteById(id);
    }
}
