package br.com.pucc.cuida_pet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Sqlite extends SQLiteOpenHelper {
    //Creating DB object
    private final String createTablePet = "CREATE TABLE pet (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT NOT NULL, " +
            "linkFoto TEXT NOT NULL, " +
            "especie TEXT NOT NULL, " +
            "raca TEXT NOT NULL, " +
            "idade INTEGER NOT NULL, " +
            "cor TEXT NOT NULL, " +
            "peso REAL NOT NULL, " +
            "idUser INTEGER NOT NULL, " +
            "FOREIGN KEY(idUser) REFERENCES acesso(_id)" +
            ");";

    private final String createTableVacina = "CREATE TABLE vacina (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "pet_id INTEGER, " +
            "nome TEXT NOT NULL, " +
            "tipo TEXT NOT NULL, " +
            "data TEXT NOT NULL, " +
            "proximaDose TEXT, " +
            "FOREIGN KEY(pet_id) REFERENCES pet(_id)" +
            ");";

    private final String createTableExame = "CREATE TABLE exame (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "pet_id INTEGER, " +
            "nome TEXT NOT NULL, " +
            "resultado TEXT, " +
            "FOREIGN KEY(pet_id) REFERENCES pet(_id)" +
            ");";


    //Constructor
    public Sqlite(@Nullable Context context, int version) {
        super(context, "DB_test", null, version);
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=ON"); //FK Enable
    }
    //Global Variables
    String passwordData;
    String status = "1";
    /**
     * FAZER CADA AÇÃO ABAIXO
     * - CRIAR, EDITAR, DELETAR, LET EXAME
     * - CRIAR, EDITAR, DELETAR, LET VACINA
     * - CRIAR, EDITAR, DELETAR, LER PET
     * */

    /*-----MY APP METHODS-----*/
    //SIGNING UP
    public boolean Signin (String chave, String authentication){
        //Using SQLiteDatabase to initialize the "connection" with database
        //getWritableDatabase selects the database app and opens the connection
        SQLiteDatabase database = getWritableDatabase();

        //Pass the values to the "insert"
        ContentValues valores = new ContentValues();
        valores.put("_id", (byte[]) null); //Column name, variable name
        valores.put("chave", chave); //Column name, variable name
        valores.put("authentication", authentication); //Column name, variable name
        valores.put("status", "0"); //Column name, variable name

        //Calling insert() to be verified by IF
        if (database.insert("acesso",null, valores) != -1){
            database.close();
            return true;
        }else{
            database.close();
            return false;
        }
    }

    //SHOWING AUTHENTICATION
    public boolean isAutenticated (String chave){
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT authentication FROM acesso WHERE chave = ?", new String[]{ chave });

        if(cursor.moveToFirst()){
            //Recover password value
            passwordData = cursor.getString(0); //Column authentication from select
            getWritableDatabase().close();
            return true;
        }else{
            getWritableDatabase().close();
            return false;
        }
    }

    //SETTING STATUS TO "1"
    public boolean hasStatus(String chave){
        SQLiteDatabase database = getWritableDatabase(); //Connection
        ContentValues values = new ContentValues();
        //Indicates the column and the variable
        values.put("status", status);

        //Calling the Update and the Verifying
        if(database.update("acesso", values, "chave = ?", new String[]{ chave }) != 0){
            database.close();
            return true;
        }else{
            database.close();
            return false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Cria as tabelas
        db.execSQL(createTableExame);
        db.execSQL(createTableVacina);
        db.execSQL(createTablePet);
    }
    //Method that Upgrades my DB
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //LISTING ALL
    public List<String> listAll() {
        SQLiteDatabase db = getWritableDatabase(); //Open the connection
        //Creating the string vector
        List<String> completeList = new ArrayList<String>();

        //Using cursor to store select
        Cursor c = db.rawQuery("SELECT * FROM acesso;", new String[]{ });
        if(c.moveToFirst()){
            do{
                //Put the String in the ListView
                String content = "Key: " + c.getString(1)+ "\nAuthentication: " + c.getString(2) + "\nStatus: "+c.getString(3);
                //Add in the list
                completeList.add(content);
            }while (c.moveToNext());
        }
        db.close();
        //Return
        return completeList;
    }

    //LISTING AUTHENTICATED
    public List<String> listAuth() {
        SQLiteDatabase db = getWritableDatabase(); //Open the connection
        //Creating the string vector
        List<String> authList = new ArrayList<String>();

        //Using cursor to store select
        Cursor c = db.rawQuery("SELECT * FROM acesso WHERE status = '1';", new String[]{ });
        if(c.moveToFirst()){
            do{
                //Put the String in the ListView
                String content = "Key: " + c.getString(1)+ "\nAuthentication: " + c.getString(2) + "\nStatus: "+c.getString(3);
                //Add in the list
                authList.add(content);
            }while (c.moveToNext());
        }
        db.close();
        //Return
        return authList;
    }
}