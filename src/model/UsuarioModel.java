package model;

import objects.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private List<Usuario> usuarios;
    private int contadorID;

    public UsuarioModel(){
        usuarios = new ArrayList<>();
        contadorID = 1;
    }

    public void agregarUsuario(String nombre, String contraseña){
        Usuario nuevoUsuario = new Usuario(contadorID++,nombre,contraseña);
        usuarios.add(nuevoUsuario);
    }

    public void eliminarUsuario (int id){
        usuarios.removeIf(user -> user.getId() == id);
    }

    public void actualizarUsuario(int id,String usuario, String contraseña){
        for (Usuario U: usuarios){
            if (U.getId()== id){
                U.setUsuario(usuario);
                U.setContraseña(contraseña);
            }
        }
    }


    public List<Usuario> getUsuarios (){

        return usuarios;
    }


}
