package com.example.module18restapi.service;

import com.example.module18restapi.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class Controller {
    @Autowired
    private Mapper mapper;
    @Autowired
    private NoteServiceImpl noteService;


    @GetMapping("/list")
    public ResponseEntity<List<ResponseNoteDTO>> getAllNotes(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.convertEntityToDTOList(noteService.getAllNotes()));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseNoteDTO> createNote(@RequestBody RequestNote requestNote){
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setTitle(requestNote.getTitle());
        noteDTO.setContent(requestNote.getContent());
        Note note = mapper.convertDTOtoEntity(noteDTO);
        noteService.createNote(note);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.convertEntityToDTO(note));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") long id){
        noteService.deleteNote(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Note is deleted");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseNoteDTO> updateNote(
                                            @PathVariable("id") long id,
                                            @RequestBody RequestNote requestNote){
        ResponseNoteDTO noteDTO = mapper.requestNoteToDTO(id, requestNote);
        Note note = mapper.convertResponseNoteDTOToEntity(noteDTO);
        noteService.updateNote(note);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.convertEntityToDTO(note));
    }

}
