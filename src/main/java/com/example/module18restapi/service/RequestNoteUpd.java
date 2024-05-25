package com.example.module18restapi.service;

import lombok.Data;

@Data
public class RequestNoteUpd {
    private long id;
    private String title;
    private String content;
}
