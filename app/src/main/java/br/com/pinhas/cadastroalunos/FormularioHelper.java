package br.com.pinhas.cadastroalunos;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.pinhas.cadastroalunos.modelo.Aluno;

/**
 *
 * Created by Pinhas on 30/09/2016.
 */
//Helper que irá coletar todas as informações da tela de cadastro
public class FormularioHelper {

    private EditText nome;
    private EditText telefone;
    private EditText endereco;
    private EditText site;
    private RatingBar nota;
    private Aluno aluno;

    //capturando as informações dos campos do formulário
    public FormularioHelper(FormularioActivity activity) {
        this.aluno = new Aluno();

        this.nome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.telefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        this.endereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        this.site = (EditText) activity.findViewById(R.id.formulario_site);
        this.nota = (RatingBar) activity.findViewById(R.id.formulario_nota);

    }

    public Aluno getAlunoFromForm(){
        aluno.setNome(nome.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setSite(site.getText().toString());
        aluno.setNota(Double.valueOf(nota.getProgress()));

        return aluno;
    }

    //implementar o método de validação se o usuário a ser adicionado tem nome
    public boolean temNome(){
        return !nome.getText().toString().isEmpty();
    }

    public void showError(){
        nome.setError("Campo não pode ser vazio");
    }
}
