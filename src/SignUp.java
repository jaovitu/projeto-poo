import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SignUp extends Screen {

    JTextField userName = new JTextField(20);
    JTextField userEmail = new JTextField(20);
    JPasswordField userPassword = new JPasswordField(20);
    JComboBox userGender = new JComboBox();
    JButton btnSingUp = new JButton("Cadastrar");

    public SignUp(String title, int height, int width, boolean isDefaultVisible) {
        super(title, height, width, isDefaultVisible);

        this.generalConfigs();
        this.headerConfig();
        this.formConfig();
    }

    @Override
    protected void generalConfigs() {
        super.generalConfigs();

        this.setLayout(new GridLayout(6, 1));
    }

    private void headerConfig() {
        JLabel lblHeader = new JLabel("CADASTRO DE USUÁRIO");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel headerContainer = new JPanel(new FlowLayout());
        headerContainer.add(lblHeader);

        this.add(headerContainer);
    }

    private void formConfig() {
        Font formLabelFont = new Font("Arial", Font.BOLD, 16);

        JPanel userNameContainer = new JPanel(new FlowLayout());
        JLabel lblUserName = new JLabel("Nome: ");
        lblUserName.setFont(formLabelFont);
        userNameContainer.add(lblUserName);
        userNameContainer.add(userName);

        JPanel userEmailContainer = new JPanel(new FlowLayout());
        JLabel lblUserEmail = new JLabel("Email: ");
        lblUserEmail.setFont(formLabelFont);
        userEmailContainer.add(lblUserEmail);
        userEmailContainer.add(userEmail);

        JPanel userPasswordContainer = new JPanel(new FlowLayout());
        JLabel lblUserPassword = new JLabel("Senha: ");
        lblUserPassword.setFont(formLabelFont);
        userPasswordContainer.add(lblUserPassword);
        userPasswordContainer.add(userPassword);

        JPanel userGenderContainer = new JPanel(new FlowLayout());
        JLabel lblUserGender = new JLabel("Sexo: ");
        lblUserGender.setFont(formLabelFont);
        for (String s : Arrays.asList("Feminino", "Masculino", "Outro")) {
            userGender.addItem(s);
        }
        userGenderContainer.add(lblUserGender);
        userGenderContainer.add(userGender);

        JPanel buttonSubmitContainer = new JPanel(new FlowLayout());
        buttonSubmitContainer.add(btnSingUp);


        this.add(userNameContainer);
        this.add(userEmailContainer);
        this.add(userPasswordContainer);
        this.add(userGenderContainer);
        this.add(buttonSubmitContainer);
    }
}
