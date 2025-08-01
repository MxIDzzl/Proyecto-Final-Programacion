package objects;

public class Usuario {
    private int id;
    private String usuario;
    private String contraseña;

    public Usuario(int id, String usuario, String contraseña){
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getID(){
        return id;
    }

    public String getUsuario(){
        return usuario;
    }

    public String getContraseña(){
        return contraseña;
    }
}
