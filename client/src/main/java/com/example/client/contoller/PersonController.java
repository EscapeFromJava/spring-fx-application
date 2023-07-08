package com.example.client.contoller;

import com.example.client.adapter.PersonClient;
import com.example.client.model.dto.PersonDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class PersonController {

    private final PersonClient personClient;
    private PersonDto selectedPerson;
    @FXML
    public TextField fieldName;
    @FXML
    public TextField fieldEmail;
    @FXML
    public Label labelResult;
    @FXML
    public TableView<PersonDto> tablePerson;
    @FXML
    public TableColumn<String, String> columnName;
    @FXML
    public TableColumn<String, String> columnEmail;

    private ObservableList<PersonDto> observableList = FXCollections.observableArrayList();

    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tablePerson.setItems(observableList);

        tablePerson.setRowFactory(tv -> {
            TableRow<PersonDto> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && !row.isEmpty()) {
                    selectedPerson = row.getItem();
                }
            });
            return row;
        });
    }

    public PersonController() {
        this.personClient = new PersonClient();
    }

    public void savePerson(ActionEvent actionEvent) {
        PersonDto personDto = PersonDto.builder()
                .name(fieldName.getText())
                .email(fieldEmail.getText())
                .build();

        String response = personClient.savePerson(personDto);
        labelResult.setText(response);
    }

    public void getAll(ActionEvent actionEvent) {
        tablePerson.getItems().clear();

        List<PersonDto> people = personClient.getAll();
        observableList.addAll(people);
    }

    public void removePerson(ActionEvent actionEvent) {
        personClient.removePerson(selectedPerson);
        observableList.remove(selectedPerson);
    }
}