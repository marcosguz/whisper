package com.whisper.controller;

import com.whisper.model.Message;
import com.whisper.service.MessageService;
import com.whisper.service.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
@CrossOrigin(origins = "*")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

//    @PostMapping("/sender-message")
//    @ResponseBody
    @MessageMapping("/sender-message")
    @SendTo("/topic/messages")
    public ResponseEntity<?> senderMessage(@RequestBody MessageDto messageDto) {
        return new ResponseEntity<>(messageService.sender(messageDto), HttpStatus.CREATED);
    }

    @PostMapping("/edit-message")
    @ResponseBody
    public ResponseEntity<?> editMessage(@RequestBody MessageDto messageDto) {
        return new ResponseEntity<>(messageService.editMessage(messageDto), HttpStatus.OK);
    }

    @GetMapping("/get-messages/{idUser}")
    public ResponseEntity<?> getMessages(@PathVariable String idUser) {
        return new ResponseEntity<>(messageService.messageList(idUser), HttpStatus.OK);
    }
}
