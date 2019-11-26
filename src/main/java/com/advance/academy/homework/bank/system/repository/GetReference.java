package com.advance.academy.homework.bank.system.repository;


public interface GetReference {
    public <T> T getReference(Class<T> tClass, Integer id);
}
