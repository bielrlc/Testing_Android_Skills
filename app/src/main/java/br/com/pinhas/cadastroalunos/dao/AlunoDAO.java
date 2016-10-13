package br.com.pinhas.cadastroalunos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.pinhas.cadastroalunos.modelo.Aluno;

/**
 * Created by Pinhas on 05/10/2016.
 */

public class AlunoDAO extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE = "Burro_System";
    private static final String TABELA = "Alunos";

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

    //insere no banco de Dados um novo Aluno, conforme passado às informações deste através da classe Aluno
    public void insere(Aluno aluno){
        ContentValues values = new ContentValues();

        values.put("nome", aluno.getNome());
        values.put("telefone", aluno.getTelefone());
        values.put("endereco", aluno.getEndereco());
        values.put("site", aluno.getSite());
        values.put("nota", aluno.getNota());

        getWritableDatabase().insert(TABELA, null, values);
    }

    //retorna a lista de Alunos cadastrados no banco de dados
    public List<Aluno> getLista(){

        List<Aluno> alunos = new ArrayList<Aluno>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABELA + ";", null);

        while (cursor.moveToNext()){
            Aluno aluno = new Aluno();

            aluno.setId(cursor.getLong(cursor.getColumnIndex("id")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("site")));
            aluno.setNota(cursor.getDouble(cursor.getColumnIndex("nota")));

            alunos.add(aluno);
        }
        cursor.close();
        return alunos;
    }
}
