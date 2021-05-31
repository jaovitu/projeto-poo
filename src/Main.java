public class Main {
    public static void main(String[] args) {
        SignUp signUpScreen = new SignUp("SingUp", 480, 720, true);

        signUpScreen.btnSingUp.addActionListener(e -> {
            System.out.println(signUpScreen.userName.getText());
            System.out.println(signUpScreen.userEmail.getText());
            System.out.println(signUpScreen.userPassword.getPassword());
            System.out.println(signUpScreen.userGender.getSelectedItem());
        });
    }
}
