package com.enhie.miagenda;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

//En esta clase implementaré los eventos de los diferentes controles
public class Eventos implements OnClickListener,OnFocusChangeListener {

	
	public void Eventos(){
		
	}
	
	//Eventos
	//*********************************************************************************************************
	@Override
	//Evento de cambio de foco
	public void onFocusChange(View v, boolean hasFocus) {
		int idElemento=v.getId();
		//Si el idElemento es 1 o 2 son EditText. 
		if (idElemento<=2)
		{
			TextoPredefinido((EditText)v,hasFocus);
		}
		/*
		switch (idElemento)
		{
			case 1:
				break;
			case 2:
				break;
		}
		*/
	}
	
	
	@Override
	//Evento Click
	public void onClick(View v) {
		int idElemento=v.getId();
		switch (idElemento)
		{
			case 3:
				break;
			case 4:
				break;
		}
		
	}
	//********************************************************************************************************
	
	//Métodos
	//********************************************************************************************************
	
	/*Método TextoPredefinido
	 * 	texto : Elemento que contiene el texto
	 * 	entra : me indica si toma el foco o lo deja
	 * 	Descripción: Este método establecerá el texto por defecto del elemento contenido en su tag si al perder el foco no contiene
	 * ningún texto.
	 */
	private void TextoPredefinido (EditText texto,boolean entra)
	{
		//Variables
		//**************************************************************
		//capturo el texto del elemento
		String actual=texto.getText().toString();
		//capturo el texto por defecto
		String defecto=texto.getTag().toString();
		//**************************************************************
		
		//Solo actuaré según el elemento pierda el foco o lo tome
		if (!entra)
		{

			//Compruebo que el texto sea vacio
			if (texto.getText().length()==0)
			{
				//Reestablezco su valor por defecto contenido en la propiedad tag
				texto.setText(defecto);
			}
		}
		else
		{
			//Compruebo si el texto es el por defecto
			if (actual.equals(defecto))
			{
				//Borro el texto
				texto.setText("");
			}
		}
	}
	
	//********************************************************************************************************
}
