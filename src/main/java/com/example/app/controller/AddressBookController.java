package com.example.app.controller;


import com.example.app.dto.AddressBookDTO;
import com.example.app.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService service;

    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getEntryById(id));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.createEntry(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.updateEntry(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteEntry(id));
    }
}
