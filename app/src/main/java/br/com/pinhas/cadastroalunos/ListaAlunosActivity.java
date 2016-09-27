package br.com.pinhas.cadastroalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView lista_alunos;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        //preenchendo a lista com um vetor de Strings
        String[] alunos = {"Gabriel, Felipe, Edward"};
        this.lista_alunos = (ListView) findViewById(R.id.lista_alunos);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);

    }
}
