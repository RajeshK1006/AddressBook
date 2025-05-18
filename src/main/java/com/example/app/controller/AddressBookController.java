package com.example.app.controller;


import com.example.app.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // GET all entries
    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("GET: Fetching all address book entries.");
    }

    // GET entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        return ResponseEntity.ok("GET: Fetching entry with ID: " + id);
    }

    // POST to create new entry
    @PostMapping
    public ResponseEntity<String> create(@RequestBody AddressBook entry) {
        return ResponseEntity.ok("POST: Creating new entry for " + entry.getName());
    }

    // PUT to update entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody AddressBook updatedEntry) {
        return ResponseEntity.ok("PUT: Updating entry with ID: " + id + " to " + updatedEntry.getName());
    }

    // DELETE entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok("DELETE: Deleting entry with ID: " + id);
    }
}

