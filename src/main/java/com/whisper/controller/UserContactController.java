package com.whisper.controller;

import com.whisper.service.UserContactService;
import com.whisper.service.dto.UserContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-contact")
@CrossOrigin(origins = "*")
public class UserContactController {

    private UserContactService userContactService;

    @Autowired
    public UserContactController(UserContactService userContactService) {
        this.userContactService = userContactService;
    }

    @PostMapping("/add-contact")
    @ResponseBody
    public ResponseEntity<?> addContact(@RequestBody UserContactDto userContactDto) {
        return new ResponseEntity<>(userContactService.addContact(userContactDto), HttpStatus.CREATED);
    }

    @PostMapping("/delete-contact")
    @ResponseBody
    public ResponseEntity<?> deleteContact(@RequestBody UserContactDto userContactDto) {
        return new ResponseEntity<>(userContactService.deleteContact(userContactDto.getIdContact().getIdUser()), HttpStatus.OK);
    }

    @GetMapping("/get-contacts/{idUser}")
    public ResponseEntity<?> getContacts(@PathVariable String idUser) {
        return new ResponseEntity<>(userContactService.getContactsByUserId(idUser), HttpStatus.OK);
    }
}
