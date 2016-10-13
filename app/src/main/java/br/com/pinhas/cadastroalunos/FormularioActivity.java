package br.com.pinhas.cadastroalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.pinhas.cadastroalunos.dao.AlunoDAO;
import br.com.pinhas.cadastroalunos.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private Button botaoSalvar;
    //atributo que representa a classe responsável por pegar as informações do formulário
    private FormularioHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //instanciando o helper para ser possível gravar as informações do formulário
        this.botaoSalvar = (Button) findViewById(R.id.salvar);
        this.helper = new FormularioHelper(this);

        this.botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = helper.getAlunoFromForm();

                if (helper.temNome()) {
                    AlunoDAO dao = new AlunoDAO(FormularioActivity.this);
                    dao.insere(aluno);
                    dao.close();
                    Toast.makeText(FormularioActivity.this, aluno.getNome() + " Salvo !!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    helper.showError();
                }
            }
        });
    }

    //criando um menu de opções, utilizando o Inflator
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override //criação de evento de clique no botão do menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Toast.makeText(this, "Botão clicado !!", Toast.LENGTH_SHORT).show();
                finish();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
