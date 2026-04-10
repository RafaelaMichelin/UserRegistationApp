package com.rafaela.userregistationapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/* Anotação @Database define que a classe representa o banco de dados Room
* Ela especifica as entidades(tabelas) que o banco irá conter e a versão do BD
*/
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
   //Singleton do Banco de dados
    private static UserDatabase instance;
    //Método abstrado que será implementado pela Room
    //Serve para acessar as operações do BD definidas na UserDao
    public abstract UserDao userDao();
    //Método que retorna a instância do BD
    //O uso do "synchronized" garante que apenas uma thread possa acessar este método por vez, evitando que duas instâncias do BD sejam criadas acidentalmente
    public static synchronized UserDatabase getInstance(Context context){
        // verificar se já nao existe uma instÃNCIA DE BANCO DE DADOS CRIADA
        if(instance == null){
            //criar instância do bd usando room
            //FallbackToDestructiveMigration - se houver mudança de versão e não houver migração, o BD será recriado do zero
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),  //Usa o contexto da aplicação para evitar vazamento de memória
                    UserDatabase.class,"user-database").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
    }
}
