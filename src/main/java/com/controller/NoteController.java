package com.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.repository.NoteDAO;
import com.dto.NoteDTO;
import com.dto.NotesCountDTO;
import com.mapper.NoteMapper;
import com.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
	
	@Autowired
	NoteDAO dao;	
	
	@Autowired
    private NoteService noteService;

	@Autowired
	NoteMapper noteMapper;
	
    @GetMapping("/findNotesByDate")
    public List<NoteDTO> getNotesByDate(@RequestParam String code,									    		
									    		@RequestParam Integer day,
									            @RequestParam Integer month,
									            @RequestParam Integer year) {
    		return noteService.findNotesByDate(code,day,month, year);
    }

    @GetMapping("/countNotesByMonth")
    public NotesCountDTO getNotesByMonth(@RequestParam Integer month, @RequestParam String code) {  		
    		return noteService.countNotesByMonth(month, code);
    }

    // GET: Retrieve a note by ID
//    @GetMapping
//    public ResponseEntity<NoteDTO> getNoteById(@RequestParam Integer id) {
//        Optional<NoteDTO> noteDTO = noteService.getNoteById(id);
//        return noteDTO.map(ResponseEntity::ok)
//                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@RequestBody NoteDTO noteDTO) {
        NoteDTO savedNoteDTO = noteService.addNote(noteDTO);
        System.out.println("Saved Note: " + savedNoteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNoteDTO);
    }

    // PUT: Update an existing note
    @PutMapping
    public ResponseEntity<NoteDTO> updateNote(@RequestParam Integer id, @RequestBody NoteDTO noteDTO) {
        NoteDTO updatedNoteDTO = noteService.updateNoteDTO(id, noteDTO);
        if (updatedNoteDTO != null) {
            return ResponseEntity.ok(updatedNoteDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    // DELETE: Delete a note by ID      
    @DeleteMapping
    public ResponseEntity<Void> deleteNoteById(@RequestParam Integer id) {
        Optional<NoteDTO> noteDTO = noteService.getNoteById(id); 
        if (noteDTO.isPresent()) {
            noteService.deleteNoteById(id);
            System.out.println("Delete success!");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
