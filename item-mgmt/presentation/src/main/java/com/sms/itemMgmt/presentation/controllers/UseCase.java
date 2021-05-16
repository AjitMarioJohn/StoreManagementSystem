package com.sms.itemMgmt.presentation.controllers;

public interface UseCase {

    Output execute();

    public interface Output {
        Object getResult();
    }

}
