package com.gestorlibros.model;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import es.usal.progiii.tools.Rutas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestorLibrosModel {

    ArrayList<Libro> libros;

    // Path to export and import data
    Path pathToXML = Rutas.pathToFileOnDesktop("libros.xml");
    Path pathToJSON = Rutas.pathToFileOnDesktop("libros.json");
    Path pathToCSV = Rutas.pathToFileOnDesktop("libros.csv");
    Path pathToBinary = Rutas.pathToFileOnDesktop("libros.bin");

    public GestorLibrosModel() {
        libros = new ArrayList<Libro>();
    }

    // CRUD OPERATIONS
    public void addLibro(Libro l) {
        libros.add(l);
    }

    public void removeLibro(Libro l) {
        libros.remove(l);
    }

    public void updateLibro(Libro l) {
        libros.set(libros.indexOf(l), l);
    }

    public ArrayList<Libro> getLibros() {
        // Devolvemos copia para no modificar el original desde la vista.
        return new ArrayList<Libro>(this.libros);
    }

    // Export and Import data ------------------------------------------
    public int exportBooksToCSV() {
        ArrayList<String> lineas = new ArrayList<>();
        for (Libro l: libros){
            //Convertir una instancia de libro a una línea de texto con formato "nombre separdor autor etc
            String LibroEnFormaString = l.asDelimitedString(",");
            lineas.add(LibroEnFormaString);
        }
        try{
            Files.write(pathToCSV, lineas, StandardCharsets.UTF_8);
        }catch (IOException e){
                return -1;
        }
        return lineas.size();
    }

    public int importBooksFromCSV() {
        try{
            List<String> lineas = Files.readAllLines(pathToCSV, StandardCharsets.UTF_8);
            
            int contadorlibros = 0;

            for (String linea: lineas){
                 //Convertir una instancia de libro a una línea de texto con formato "nombre separdor autor etc
                Libro l = Libro.fromDelimitedString(linea, ",");//Patron simple factor
                if(l!= null){
                    if(libros.contains(l)){
                        System.out.println("El libro ya existia en el modelo");
                    }
                    contadorlibros++;
                    libros.add(l);
                }
            }
            return contadorlibros;
        }catch (IOException e){
            return -1;
        }
        
    }

    public int exportBooksToJSON() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    public int importBooksFromJSON() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    public int importBooksFromXML() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");  
    }

    public int exportBooksToXML() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    // Serialization and Deserialization ------------------------------------------
    public int saveStateOfTheApp(){
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    public int loadStateOfTheApp(){
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }



}
