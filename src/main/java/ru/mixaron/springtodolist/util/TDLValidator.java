package ru.mixaron.springtodolist.util;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.mixaron.springtodolist.models.TDList;

@Component
public class TDLValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TDList tdList = (TDList) target;
        if (tdList.getContent() == null) {
            errors.rejectValue("content", "", "Контент не может быть пустым!");
        }
        if (tdList.getName() == null) {
            errors.rejectValue("content", "", "Заголовок не может быть пустым!");
        }
    }
}
