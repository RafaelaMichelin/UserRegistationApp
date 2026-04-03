package com.rafaela.userregistationapp;

//O Data Acess Object é o componente que serve para persistência de dados. Serve para definir as operações que podem ser feitas no banco de dados com relação a entidade User

//Importa as notações do Room necessárias para definir o DAO(Data Acess Object)

import androidx.room.Query;
import  androidx.room.Dao;
import androidx.room.Insert;

//Importa a clase List do java para retornar uma lista de usuários
import java.util.List;

@Dao
public interface UserDao {
    //Método para inserir um usuário na tabela do Banco de dados
    //A anotação @Insert informa à Room que este método deve ser usado para inserir dados

    @Insert
    void Insert(User user);

    //Método para buscar todos os usuários cadastrados no Banco de dados
    // A anotação @Query permite definir uma consulta SQL personalizadas
    @Query("SELECT * FROM user")
    //Salvar o que foi selecionado no Banco de dados em uma lista
    List<User>getAllUsers();
}
