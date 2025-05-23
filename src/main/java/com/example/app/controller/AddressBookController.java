package com.example.app.controller;

import com.example.app.dto.AddressBookDTO;
import com.example.app.model.AddressBook;
import com.example.app.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService service;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAll() {
        log.info("GET /addressbook called");
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        log.info("GET /addressbook/{} called", id);
        AddressBook entry = service.getEntryById(id);
        return (entry != null) ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AddressBook> create(@RequestBody AddressBookDTO dto) {
        log.info("POST /addressbook called with DTO: {}", dto);
        return ResponseEntity.ok(service.createEntry(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        log.info("PUT /addressbook/{} called with DTO: {}", id, dto);
        AddressBook updated = service.updateEntry(id, dto);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        log.info("DELETE /addressbook/{} called", id);
        service.deleteEntry(id);
        return ResponseEntity.ok("Deleted entry with ID: " + id);
    }
}
