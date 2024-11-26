package com.example.creditapp.storage;

import com.example.creditapp.model.Credit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private static final String FILE_NAME = "credits.txt";

    public void saveCredits(List<Credit> credits) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(credits);
        }
    }

    public List<Credit> loadCredits() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Credit>) ois.readObject();
        }
    }
}
