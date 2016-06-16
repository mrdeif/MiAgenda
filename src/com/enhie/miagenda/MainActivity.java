package com.enhie.miagenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/*Proyecto MiAgenda
 * Esto proyecto crear� una ajenda r�pida para introducir contactos 
 * y listarlos en su versi�n 1.0
 */

//Actividad principal de entrada a la aplicaci�n
public class MainActivity extends Activity {

	//Atributos de clase
	//*********************************************************************************************
	//Base de datos
	DB_Agenda db;
	//*********************************************************************************************
	
	@Override
	//Evento onCreate. Entrada a nuesta aplicaci�n
	//************************************************************
	protected void onCreate(Bundle savedInstanceState) {
		//Varialbles
		//*********************************************************
		EditText _nombre=null;
		EditText _telefono=null;
		Button _intro=null;
		Button _list=null;
		
		Eventos eventos= new Eventos();
		//*********************************************************		
		
		super.onCreate(savedInstanceState);
		//Enlazo la actividad a su layout
		setContentView(R.layout.activity_main);
		//Capturo los controles de layout
		//*****************************************************
		_nombre= (EditText)findViewById(R.id.edtNombre);
		_telefono=(EditText)findViewById(R.id.edtTelefono);
		_intro=(Button)findViewById(R.id.btnIntro);
		_list =(Button)findViewById(R.id.btnList);
		//*****************************************************
		
		//Asigno id a los elementos
		//*****************************************************
		_nombre.setId(1);
		_telefono.setId(2);
		_intro.setId(3);
		_list.setId(4);
		//*****************************************************
		
		
		//Asigno los eventos
		//*****************************************************
		_nombre.setOnFocusChangeListener(eventos);
		_telefono.setOnFocusChangeListener(eventos);
		_intro.setOnClickListener(eventos);
		_list.setOnClickListener(eventos);
		//*****************************************************
	}


}
