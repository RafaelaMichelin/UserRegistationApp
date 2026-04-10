package com.rafaela.userregistationapp;

//IMPORTAÇÃO DE COMPONENTES DE UI, INTENÇOES E BIBLIOTECA ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class ReportActivity extends AppCompatActivity {

    //CAMPO DE TEXTO ONDE OS DADOS DO BANCO SERÃO EXIBIDOS
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        //DEFINE O LAYOUT XML DESSA TELA DE RELATÓRIO
        setContentView(R.layout.activity_report);
        //MAPEAMENTO DO TEXTVIEW DO XML PARA O JAVA
        textViewReport = findViewById((R.id.textViewReport);
        //ENCONTRA O BOTÃO E DEFINE O CLIQUE PARA VOLTAR
        Button btnVoltar = findViewById(R.id.btnVoltar);
        //O BOTÃO DE RETORNO UTILIZANDO EXPRESSÃO LAMBDA
        btnVoltar.setOnClickListener(v-> voltarParaCadastro());

        /*
        CONEXÃO COM O BANCO DE DADOS
        1- Cria uma Instância do banco "user-database"
        2- .allowMainThreadQueries():  --> Serve para liberar operações de consulta feitas em threads da UI.
         Por padrão, ROOM proibe isso. O Correto seria fazer consultas em threads separadas
         */

        UserDatabase db = Room.databaseBuilder(getApplicationContext(), UserDatabase.class,"user-database").allowMainThreadQueries().build();

        //Obtém o objeto DAO(Data acessa object) que contém as queries SQL
        UserDao userDao = db.userDao();
        // Recupera todos os usuários salvos no BANCO DE DADOS e armazena em uma lista

        List<User> userList = userDao.getAllUsers();
        //StringBuilder: forma eficiente de construir uma String longa dentro de um laço de repetição
        StringBuilder report = new StringBuilder();

        //Loop "for-each" para percorrer cada objeto User dentro da lista
        for(User user: userList) {
            report.append("Nome: ").append(user.getName()).append("\n").append("CPF: ").append(user.getCpf()).append("\n\n");
        }
        //Exibe o relatório final montado na TextView da tela
        textViewReport.setText(report.toString());

    }

    //MÉTODO RESPONSÁVEL PELA NAVEGAÇÃO ENTRE AS TELAS DO APP
    public void voltarParaCadastro(){
        //INTENÇÃO PARA ABRIR A TELA DE CADASTRO
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); //FECHA A TELA DE RELATÓRIO PARA NÃO ACUMULAR NA PILHA DE TAREFAS

    }

}
