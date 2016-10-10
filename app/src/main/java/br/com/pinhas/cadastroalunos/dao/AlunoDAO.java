package br.com.pinhas.cadastroalunos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.pinhas.cadastroalunos.modelo.Aluno;

/**
 * Created by Pinhas on 05/10/2016.
 */

public class AlunoDAO extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE = "Cadastro_Burro";
    private static final String TABELA = "Aluno";

    public AlunoDAO(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String ddl = "CREATE TABLE " + TABELA
                + " (id INTEGER PRIMARY KEY, "
                + " nome TEXT NOT NULL,"
                + " telefone TEXT,"
                + " endereco TEXT,"
                + " site TEXT,"
                + " nota REAL);";

        database.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        database.execSQL(sql);
        onCreate(database);
    }

    public void insere(Aluno aluno){
        ContentValues values = new ContentValues();

        values.put("nome", aluno.getNome());
    }
}
