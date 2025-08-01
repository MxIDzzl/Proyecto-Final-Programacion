package model;

public class LoginModel {
    private final String usuarioCorrecto = "Admin";
    private final String passwordCorrecto = "Admin123";

    public boolean validarUsuario(String usuario,String password){
        return usuario.equals(usuarioCorrecto) && password.equals(passwordCorrecto);
    }
}
