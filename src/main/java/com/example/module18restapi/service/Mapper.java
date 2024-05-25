package com.example.module18restapi.service;

import com.example.module18restapi.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Mapper {

    public List<ResponseNoteDTO> convertEntityToDTOList(List<Note> notes){
        return notes.stream()
                .map(note -> convertEntityToDTO(note))
                .collect(Collectors.toList());
    }

    public ResponseNoteDTO convertEntityToDTO(Note note){
        ResponseNoteDTO responseNoteDTO = new ResponseNoteDTO();
        responseNoteDTO.setId(note.getId());
        responseNoteDTO.setTitle(note.getTitle());
        responseNoteDTO.setContent(note.getContent());
        return responseNoteDTO;
    }

    public Note convertDTOtoEntity(NoteDTO noteDTO){
        Note note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());
        return note;
    }

    public ResponseNoteDTO requestNoteToDTO(long id, RequestNote requestNote){
        ResponseNoteDTO responseNoteDTO = new ResponseNoteDTO();
        responseNoteDTO.setId(id);
        responseNoteDTO.setTitle(requestNote.getTitle());
        responseNoteDTO.setContent(requestNote.getContent());
        return responseNoteDTO;
    }

    public Note convertResponseNoteDTOToEntity(ResponseNoteDTO responseNoteDTO){
        Note note = new Note();
        note.setId(responseNoteDTO.getId());
        note.setTitle(responseNoteDTO.getTitle());
        note.setContent(responseNoteDTO.getContent());
        return note;
    }


}
