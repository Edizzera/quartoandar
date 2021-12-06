package com.example.quartoandar.entities.enums;

public enum TipoUsuario {
    LOCADOR (1,"LOCADOR"),
    LOCATARIO(2,"LOCATARIO");

    private final int code;
    private  String nome;

    private TipoUsuario(int code,String nome) {
        this.nome = nome;
        this.code = code;
    }

    public String getNomeStatus() {
        return nome;
    }
    public int getCode(){
        return code;
    }

    //retornando o valor do enum
    public static TipoUsuario valueOf(int code){
        for(TipoUsuario value : TipoUsuario.values()){
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
