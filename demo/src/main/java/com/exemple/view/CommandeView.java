package com.exemple.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.exemple.service.ClientService;
import com.exemple.entity.Client;

public class CommandeView {

    @FXML
    private TextField telephoneField;

    private ClientService clientService;

    public CommandeView() {
        this.clientService = new ClientService();
    }

    @FXML
    private void handleSearch() {
        String telephone = telephoneField.getText();
        Client client = clientService.rechercherClientParTelephone(telephone);
        if (client != null) {
            // Affiche les informations du client
            System.out.println(client.getNom() + " " + client.getPrenom());
        } else {
            // Gère le cas où le client n'est pas trouvé
            System.out.println("Client non trouvé");
        }
    }
}
