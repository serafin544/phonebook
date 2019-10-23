package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = map;
    }

    public PhoneBook() {
        this(new HashMap<String, List<String>>());
    }

    public void add(String name, String phoneNumber) {
        if(phoneBook.containsKey(name)){
            phoneBook.get(name).add(phoneNumber);
        }else
            phoneBook.put(name, new ArrayList<>());
            add(name,phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
       phoneBook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phoneBook.containsKey(name);
    }

    public List<String> lookup(String name) {
       return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
            List<String> pb = new ArrayList<>();
            for(String name : getMap().keySet()){
                pb = lookup(name);
                if(pb.contains(phoneNumber))
                {
                    return name;
                }
            }
            return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phoneBook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phoneBook;
    }
}
