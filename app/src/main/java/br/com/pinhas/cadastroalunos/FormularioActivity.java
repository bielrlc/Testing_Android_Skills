package br.com.pinhas.cadastroalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText nome;
    private Button botaoSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

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
}
