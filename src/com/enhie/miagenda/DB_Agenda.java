package com.enhie.miagenda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/*Clase DBAgenda
 * Esta clase será la encargada de crear, conectar y gestionar nuestra BD
 */

public class DB_Agenda extends SQLiteOpenHelper 
{
	//Atributos de clase
	//******************************************************************************************
	//instrucción para crear la bd
	String SQLITECreate = "CREATE TABLE Contactos (nombre TEXT PRIMARY KEY, telefono TEXT)";
	//******************************************************************************************
	
	//Constructor
	//******************************************************************************************
	public DB_Agenda(Context context,String name, CursorFactory factory, int version)
	{
		super (context,name,factory,version);
	}
	
	//******************************************************************************************

	//Métodos
	//******************************************************************************************
	
	//Evento onCreate: se desencadena al crearse la BD
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		
	}
	
	//Evento onUpgrade: se desencana cuando se actualiza la versión
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 
		
	}
	
	
	//******************************************************************************************
	
	//Funciones
	//******************************************************************************************

	//Función de insertar: inserta los datos dados en la BD
	//nombre: nombre a insertar
	//telefono: telefono a insertar
	public int Insertar(String nombre,String telefono)
	{
		//Variables
		//*******************************************************************************
		//Cadena de escritura
		String escribe = "INSERT INTO Contactos Values ('"+nombre+"','"+telefono+"')";
		//Variable de control que me dirá si el nombre es único o no
		boolean unico=true;
		//*******************************************************************************
		//Creo un objeto SQLiteDatabase para escribir en la bd y lo inicializo
		SQLiteDatabase escritura = this.getWritableDatabase();
		//Creo otro para consulta y lo inicializo
		SQLiteDatabase lectura=this.getReadableDatabase();
		
		
		//Creo un bloque de control de excepciones
		try
		{
			//Introduzco los datos
			escritura.execSQL(escribe);
		}
		catch (Exception e)
		{
			//Si hay una excepción la captuo
			e.getStackTrace();
			//digo que el contacto ya existe
			unico=false;
			//Retorno 1 para decir que hay error
			return 1;
		}
	
		//Retorno 0 para decir que no hay error
		return 0;
	}
	
	//Función Existe: Comprueba la existencia de un dato en la BD
	// nombre: Dato a comprobar
	public int Existe(String nombre)
	{
		//Variables
		//********************************************************************************************
		SQLiteDatabase consulta= this.getReadableDatabase();
		String[] campos= new String[]{"nombre","telefono"};
		String[] argumentos = new String[]{nombre};
		
		Cursor res = consulta.query("Campos", campos, "nombre = ?", argumentos, null, null, null);
		//********************************************************************************************
		return res.getCount();
	}
	//******************************************************************************************
}