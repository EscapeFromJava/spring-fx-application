package com.example.client;

import com.example.client.adapter.PersonClient;
import com.example.client.dto.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class HelloController {

    private final PersonClient personClient;
    @FXML
    public TextField fieldName;
    @FXML
    public TextField fieldEmail;
    @FXML
    public Label labelResult;

    public HelloController() {
        this.personClient = new PersonClient();
    }

    public void savePerson(ActionEvent actionEvent) {

        Person person = Person.builder()
                .name(fieldName.getText())
                .email(fieldEmail.getText())
                .build();

        String response = personClient.savePerson(person);
        labelResult.setText(response);

    }

    public void getAll(ActionEvent actionEvent) {

        List<Person> people = personClient.getAll();
        labelResult.setText(people.toString());

    }
}