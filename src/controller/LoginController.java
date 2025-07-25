package controller;

public class LoginController {
    private final String usuarioCorrecto = "Admin";
    private final String passwordCorrecto = "admin123";

    public boolean validarUsuario(String usuario,String password){
        return usuario.equals(usuarioCorrecto) && password.equals(passwordCorrecto);

    //        if(usuario.equals(usuarioCorrecto) && password.equals(passwordCorrecto)) {
    //            return true;
    //        } else {
    //            return false;
    //        }


    }
}
