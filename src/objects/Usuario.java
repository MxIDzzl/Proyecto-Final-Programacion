package objects;

public class Usuario {
    private int id;
    private String usuario;
    private String contraseña;

    public Usuario (int id, String usuario, String contraseña){
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    public int getId(){
        return id;
    }

    public void setId (int id){
        this.id = id;
    }

    public String getusuario(){
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getcontraseña (){
        return contraseña;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

}


