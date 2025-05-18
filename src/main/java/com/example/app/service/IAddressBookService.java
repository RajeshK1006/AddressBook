package com.example.app.service;



import com.example.app.dto.AddressBookDTO;
import com.example.app.model.AddressBook;

import java.util.List;

public interface IAddressBookService {
    AddressBook createEntry(AddressBookDTO dto);
    AddressBook getEntryById(int id);
    List<AddressBook> getAllEntries();
    AddressBook updateEntry(int id, AddressBookDTO dto);
    void deleteEntry(int id);
}
