package br.com.pinhas.cadastroalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView minhaLista;
    private ArrayAdapter<String> adapter;
    private Button botao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        //preenchendo a lista com um vetor de Strings
        String[] alunos = {"Gabriel", "Felipe", "Edward"};
        this.minhaLista = (ListView) findViewById(R.id.lista_alunos);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);
        this.minhaLista.setAdapter(adapter);

        //criando um evento de click em um item da lista
        this.minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaAlunosActivity.this, "posição selecionada: " + position, Toast.LENGTH_LONG).show();
            }
        });

        //criando um evento de click longo em um item da lista
        this.minhaLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = (String) parent.getItemAtPosition(position);
                Toast.makeText(ListaAlunosActivity.this, "nome: " + nome, Toast.LENGTH_LONG).show();
                return false;
            }
        });

        //criando um listener para o botão adicionar
        botao = (Button) findViewById(R.id.lista_alunos_floating_button);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListaAlunosActivity.this, "Floating button clicado", Toast.LENGTH_LONG).show();
            }
        });
    }
}
