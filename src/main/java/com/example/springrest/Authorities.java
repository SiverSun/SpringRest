package com.example.springrest;

public enum Authorities {
    READ, WRITE, DELETE;

    @Override
    public String toString() {
        return "Authorities{}";
    }
}