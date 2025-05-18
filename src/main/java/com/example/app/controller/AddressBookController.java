package com.example.app.controller;

import com.example.app.dto.AddressBookDTO;
import com.example.app.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // GET all entries
    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("GET: Returning all address book entries (static response)");
    }

    // GET entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        return ResponseEntity.ok("GET: Returning entry with ID = " + id + " (static response)");
    }

    // POST to create new entry using DTO
    @PostMapping
    public ResponseEntity<String> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok("POST: Received entry for " + dto.getName() +
                " living at " + dto.getAddress() +
                " with phone " + dto.getPhone() + " (static response)");
    }

    // PUT to update entry by ID using DTO
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok("PUT: Updated entry with ID = " + id +
                " to Name: " + dto.getName() +
                ", Address: " + dto.getAddress() +
                ", Phone: " + dto.getPhone() + " (static response)");
    }

    // DELETE entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok("DELETE: Entry with ID = " + id + " deleted (static response)");
    }
}

