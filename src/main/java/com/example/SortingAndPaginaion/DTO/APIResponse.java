package com.example.SortingAndPaginaion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class APIResponse<T> {
    private int count;
    private T data;

    public APIResponse(int count, T data) {
        this.count = count;
        this.data = data;
    }

    // Getters and setters

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

