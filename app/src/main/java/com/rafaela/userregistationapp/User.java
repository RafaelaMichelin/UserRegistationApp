package com.rafaela.userregistationapp;

//Importa anotações do Room necessários para mapear esta classe uma entidade no banco de dados
// -- comando no teclado: alt+enter para o gradle sincronizar e importar o room--
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    //Define o campo 'id' como chave primária e configura para ser gerado automaticamente

    @PrimaryKey(autoGenerate = true)
    //Criando campo id da tabela
    private int id;
    //Campos que representam as colunas para armazenar os dados do usuário
    private String name;
    private String cpf;
    private String email;
    private String phone;

    //Construtor de classe que será usado para criar novo objeto User
    public User(String name, String cpf, String email, String phone){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
    }

    //Métodos getter e setter para acessar e modificar os dados do objeto User

    public int getId()
    {
        return id;
    }

    //Retorna o ID do usuário(usado pelo Room para preencher automaticamente
    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email= email;
    }

    public String getCpf()
    {
        return cpf;
    }
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }



}
