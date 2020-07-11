package com.app.librarymanagment.service;

import java.util.Map;

import com.app.librarymanagment.model.Credentials;

public interface LibraryManagmentService {
    public boolean isUserExist(Credentials credentials,Map<String,String> userCredentials);
}
