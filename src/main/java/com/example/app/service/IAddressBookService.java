package com.example.app.service;


import com.example.app.dto.AddressBookDTO;

public interface IAddressBookService {
    String createEntry(AddressBookDTO dto);
    String getEntryById(int id);
    String getAllEntries();
    String updateEntry(int id, AddressBookDTO dto);
    String deleteEntry(int id);
}
