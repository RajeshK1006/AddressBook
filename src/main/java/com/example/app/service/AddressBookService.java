package com.example.app.service;

import com.example.app.dto.AddressBookDTO;
import com.example.app.model.AddressBook;
import com.example.app.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    private final AddressBookRepository repository;

    // Constructor injection (Spring auto-wires this)
    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public AddressBook createEntry(AddressBookDTO dto) {
        log.info("Creating new address book entry: {}", dto);
        AddressBook entry = new AddressBook(0, dto.getName(), dto.getAddress(), dto.getPhone());
        return repository.save(entry);
    }

    @Override
    public AddressBook getEntryById(int id) {
        log.info("Retrieving address book entry with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AddressBook> getAllEntries() {
        log.info("Fetching all address book entries");
        return repository.findAll();
    }

    @Override
    public AddressBook updateEntry(int id, AddressBookDTO dto) {
        log.info("Updating address book entry with ID: {}", id);
        Optional<AddressBook> optional = repository.findById(id);
        if (optional.isPresent()) {
            AddressBook existing = optional.get();
            existing.setName(dto.getName());
            existing.setAddress(dto.getAddress());
            existing.setPhone(dto.getPhone());
            return repository.save(existing);
        } else {
            log.warn("Attempted to update non-existent entry with ID: {}", id);
            return null;
        }
    }

    @Override
    public void deleteEntry(int id) {
        log.info("Deleting address book entry with ID: {}", id);
        repository.deleteById(id);
    }
}
