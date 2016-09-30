package br.com.pinhas.cadastroalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText nome;
    private Button botaoSalvar;
    //atributo que representa a classe responsável por pegar as informações do formulário
    private FormularioHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //instanciando o helper para ser possível gravar as informações do formulário
        this.helper = new FormularioHelper(this);
        //informando o nome cadastrado
        this.nome = (EditText) findViewById(R.id.formulario_nome);
        this.botaoSalvar = (Button) findViewById(R.id.salvar);

        this.botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormularioActivity.this, nome.getText().toString() + " Salvo", Toast.LENGTH_SHORT).show();
                finish();
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
