package com.app.search.infrastructure;

public class SearchDto {
    private Long id;
    private String name;

    // Constructor vacío
    public SearchDto() {
    }

    // Constructor con parámetros
    public SearchDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { // <--- Corregido aquí
        this.name = name;
    }

    // toString() method
    @Override
    public String toString() {
        return "SearchDto{" +
                "id=" + id +
                ", name='" + name + '\'' +'}';
            }
}