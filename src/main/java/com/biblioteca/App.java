package com.biblioteca;

public class App {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Cooperativa");
        Menu.menu(biblioteca);
    }
}