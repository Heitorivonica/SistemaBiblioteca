package models;

import Enums.TipoUsuario;

public class Usuario {
    private String name;
    private String email;
    private TipoUsuario tipo;

    public Usuario(TipoUsuario tipo, String email, String name) {
        this.tipo = tipo;
        this.email = email;
        this.name = name;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void exibirDados(){
        System.out.println(name);
        System.out.println(email);
        System.out.println(tipo);
    }
}
