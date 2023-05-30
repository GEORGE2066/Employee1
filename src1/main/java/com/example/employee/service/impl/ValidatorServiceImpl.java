package com.example.employee.service.impl;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public void checkInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}