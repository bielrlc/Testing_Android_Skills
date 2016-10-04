package br.com.pinhas.cadastroalunos;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import br.com.pinhas.cadastroalunos.modelo.Aluno;

/**
 * Created by Pinhas on 30/09/2016.
 */
public class FormularioHelper {

    private EditText nome;
    private EditText telefone;
    private EditText endereco;
    private EditText site;
    private RatingBar nota;
    private Button salvar;

    //capturando as informações dos campos do formulário
    public FormularioHelper(FormularioActivity activity) {
        this.nome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.telefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        this.endereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        this.site = (EditText) activity.findViewById(R.id.formulario_site);
        this.nota = (RatingBar) activity.findViewById(R.id.formulario_nota);

        Aluno aluno;
        aluno = new Aluno();

        String value = null;
        value = this.nome.toString();
        aluno.setNome(value);

        value = this.telefone.toString();
        aluno.setTelefone(value);

        value = this.endereco.toString();
        aluno.setEndereco(value);

        value = this.site.toString();
        aluno.setSite(value);

        value = this.nota.toString();
        aluno.setNota(Double.valueOf(value));


    }
}
