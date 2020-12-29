package org.fundacionjala.trello.ui.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {
    private String pathFile;
    private FileReader reader;

    public ReaderFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public FileReader getReader() throws FileNotFoundException {
        reader = new FileReader(pathFile);
        return reader;
    }
    public void print() throws IOException {
        reader = new FileReader(pathFile);
        int valor = reader.read();
        while(valor!=-1){
            System.out.print((char)valor);
            valor = reader.read();
        }
        reader.close();
    }
}
