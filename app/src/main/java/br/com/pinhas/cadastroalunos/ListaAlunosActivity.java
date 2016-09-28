package br.com.pinhas.cadastroalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView minhaLista;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        //preenchendo a lista com um vetor de Strings
        String[] alunos = {"Gabriel", "Felipe", "Edward"};
        this.minhaLista = (ListView) findViewById(R.id.lista_alunos);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);
        this.minhaLista.setAdapter(adapter);

        //tentando criar um evento de click em um item da lista
        this.minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaAlunosActivity.this, "posição selecionada" + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}
