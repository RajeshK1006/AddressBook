package com.example.app.service;

import com.example.app.dto.AddressBookDTO;
import com.example.app.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    private final List<AddressBook> addressList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public AddressBook createEntry(AddressBookDTO dto) {
        log.info("Creating new address book entry: {}", dto);
        AddressBook entry = new AddressBook(idCounter++, dto.getName(), dto.getAddress(), dto.getPhone());
        addressList.add(entry);
        return entry;
    }

    @Override
    public AddressBook getEntryById(int id) {
        log.info("Retrieving address book entry with ID: {}", id);
        return addressList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<AddressBook> getAllEntries() {
        log.info("Fetching all address book entries");
        return addressList;
    }

    @Override
    public AddressBook updateEntry(int id, AddressBookDTO dto) {
        log.info("Updating address book entry with ID: {}", id);
        AddressBook existing = getEntryById(id);
        if (existing != null) {
            existing.setName(dto.getName());
            existing.setAddress(dto.getAddress());
            existing.setPhone(dto.getPhone());
        } else {
            log.warn("Attempted to update non-existent entry with ID: {}", id);
        }
        return existing;
    }

    @Override
    public void deleteEntry(int id) {
        log.info("Deleting address book entry with ID: {}", id);
        addressList.removeIf(e -> e.getId() == id);
    }
}
