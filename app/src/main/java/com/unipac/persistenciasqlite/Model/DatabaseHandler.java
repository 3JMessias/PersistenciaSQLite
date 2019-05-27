package com.unipac.persistenciasqlite.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    //Definindo o nome do banco
    private static final String DATABASE_NAME = "controlecontatos.db";

    //Definindo Versão do banco
    private  static final int DATABASE_VERSION = 1;



    //Definindo o nome da tabela de contatos
    private static final String TABLE_CONTATO = "contatos";

    //Definindo nome das colunas de contatos a serem criadas
    private static final String KEY_ID = "id";
    public static final String KEY_NOME = "nome";
    public static final String KEY_TELEFONE = "telefone";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Criação das tabelas

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE" + TABLE_CONTATO +"("
                + KEY_ID + "INEGER PRIMARY KEY," + KEY_NOME+ "TEXT,"
                + KEY_TELEFONE + "TEXT" + ")";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    //Update do banco
    //Atualizando as tabelas
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        //Deletar a tabela se ela existir
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTATO);

        //Recria a tabela após deletar
        onCreate(db);
    }

    /**
     * Todas operações de CRUD ().
     */

//    //Adicionando novo contato
//    void addContato(Contato contato){
//        SQLiteDatabase db = this.getWritableDatabase(); //Abre o banco para leitura e gravação
//
//        ContentValues values = new ContentValues(); //Cria objeto para criar as querys
//        values.put(KEY_NOME, contato.getNome());
//        values.put(KEY_TELEFONE,contato.getTelefone());
//
//        //Inserir dados
//        db.insert((TABLE_CONTATO, null, values));
//        db.close();//fecha conexão dos dados
//    }
//
//    //Pegando um simples contato
//    Contato getContato(int id){
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_CONTATO, new String[]){
//            KEY_ID, KEY_NOME, KEY_TELEFONE}, KEY_ID+ "=?",
//            new String[]{String.valueOf(id)}, null,null,null);
//
//        if(cursor != null)
//            cursor.moveToFirst();
//
//
//        Contato contato= new Contato((Integer.parseInt(cursor.getString(0))),
//                cursor.getString(1), cursor.getString(2));
//
//        return contato;
//    }
//    //Retornando todos os contatos
//    public List<Contato> getAllContatos(){
//        List<Contato> contatoList = new ArrayList<Contato>();
//
//        //Query para pegar todos os contatos
//        String selectQuery = "SELECT * FROM "+ TABLE_CONTATO;
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                Contato contato = new Contato();
//                contato.setId(Integer.parseInt(cursor.getString(0)));
//                contato.setNome(cursor.getString(1));
//                contato.setTelefone(cursor.getString(2));
//                contatoList.add(contato);
//            } while (cursor.moveToNext());
//        }
//        return contatoList;
//    }
//
//    //Atualizando contatos
//    public int updateContato(Contato contato){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NOME, contato.getNome());
//        values.put(KEY_TELEFONE, contato.getTelefone());
//
//        return db.update(TABLE_CONTATO, values, KEY_ID + "=?",
//                new String[]{String.valueOf(contato.getId())});
//    }
//
//    //Deletando Contatos
//    public void deleteContato(Contato contato){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTATO, KEY_ID +"=?",
//                new String[]{String.valueOf(contato.getId())});
//
//        db.close();
//    }
//
//    // pega soma total de registros
//    public int getContatosCount() {
//        String countQuery = "SELECT * FROM " + TABLE_CONTATO;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//        return cursor.getCount();
//    }



}
