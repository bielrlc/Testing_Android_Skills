package br.com.pinhas.cadastroalunos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.pinhas.cadastroalunos.dao.AlunoDAO;
import br.com.pinhas.cadastroalunos.modelo.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView minhaLista;
    private Button botao;
    private List<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        //criando um evento de click em um item da lista
        this.minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaAlunosActivity.this, "posição selecionada: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        //criando um evento de click longo em um item da lista
        this.minhaLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = (String) parent.getItemAtPosition(position);
                Toast.makeText(ListaAlunosActivity.this, "nome: " + nome, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //criando um listener para o botão adicionar ir para formulario de cadastro
        this.botao = (Button) findViewById(R.id.lista_alunos_floating_button);
        this.botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getListaAlunos();
    }

    private void getListaAlunos(){
        //retornando a lista de Alunos cadastrados no banco de dados
        AlunoDAO dao = new AlunoDAO(this);
        alunos = dao.getLista();
        dao.close();

        //populando a lista com os Alunos cadastrados no banco de dados
        minhaLista = (ListView) findViewById(R.id.lista_alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno> (this, android.R.layout.simple_list_item_1, alunos);
        minhaLista.setAdapter(adapter);
    }
}
