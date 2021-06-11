package controllers;

import dao.UserDAO;
import database.CreateConnection;
import models.User;

import views.SignUp;

import javax.swing.*;
import java.util.Arrays;

public class UserController {

    public static void insertUser(SignUp screen) {
        String nome = screen.userName.getText();
        String email = screen.userEmail.getText();
        String password = String.valueOf(screen.userPassword.getPassword());
        String gender = String.valueOf(screen.userGender.getSelectedItem());

        for (String field : Arrays.asList(nome, email, password)) {
            if(field.equals("")) {
                JOptionPane.showMessageDialog(screen, "Preencha todos os campos!", "Blank fields", JOptionPane.ERROR_MESSAGE);
                screen.userName.requestFocus();
                return;
            }
        }


        User user = new User(nome, email, password, gender);

        CreateConnection connection = new CreateConnection();
        UserDAO userDao = new UserDAO(connection.openConnection());
        boolean inserted = userDao.insertUser(user);
        connection.closeConnection();

        if(inserted) {
            JOptionPane.showMessageDialog(screen, "Usuário inserido com sucesso", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(screen, "Oops! Algo deu errado!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        screen.userName.setText("");
        screen.userEmail.setText("");
        screen.userPassword.setText("");
        screen.userGender.setSelectedIndex(0);

        screen.userName.requestFocus();
    }

}
