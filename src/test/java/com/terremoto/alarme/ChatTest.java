package com.terremoto.alarme;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD
public class ChatTest {


	public Rede mockRede(boolean sucessoConexao) {
		Rede rede = mock(Rede.class);

		// Predefinir retorno
		when(rede.abrirConexao(anyString())).thenReturn(sucessoConexao);
		
		return rede;
		
=======

public class ChatTest {
	
	private Rede mockRede(boolean sucessoConexao) {
		//Criar mocks
		Rede rede = mock(Rede.class);
	
		//Predefinir retorno
		when(rede.abrirConexao(anyString())).thenReturn(sucessoConexao);
		
		return rede;
>>>>>>> b8a7f18dd574c143956636a84c609f40e16daff2
	}

	@Test
	public void abrirConexao() {
<<<<<<< HEAD

		// Efetuar um estímulo
		Rede rede = mockRede(true);
		new Chat("1.1.1.1", rede);

		// Verificar se os mocks foram acionados
		verify(rede).abrirConexao("1.1.1.1");
	}

	@Test(expected = ExcecaoChat.class)
	public void erroAoAbrirConexao() {
		Rede rede = mockRede(false);
		// Efetuar um estímulo
		new Chat("1.1.1.1", rede);

//		// Verificar se os mocks foram acionados
//		verify(rede).abrirConexao("1.1.1.1");
=======
		Rede rede = mockRede(true);
		
		//Efetuar um estímulo
		new Chat("1.1.1.1", rede);

		//Verificar se os mocks foram acionados 
		verify(rede).abrirConexao("1.1.1.1");
	}

	@Test(expected=ExcecaoChat.class)
	public void erroAoAbrirConexao() {
		Rede rede = mockRede(false);
		
		//Efetuar um estímulo
		new Chat("1.1.1.1", rede);

		//Verificar se os mocks foram acionados 
		verify(rede).abrirConexao("1.1.1.1");
>>>>>>> b8a7f18dd574c143956636a84c609f40e16daff2
	}

	@Test
	public void enviarArquivo() throws RemoteException {
		Rede rede = mockRede(true);
<<<<<<< HEAD

		// Preparar ambiente
		Chat chat = new Chat("8.8.8.8", rede);
		reset(rede);
=======
		
		//Preparar ambiente
		Chat chat = criarChat(rede);
>>>>>>> b8a7f18dd574c143956636a84c609f40e16daff2

		// Efetuar um estímulo
		chat.enviarArquivo(new File("temp.txt"));

		// Verificar se os mocks foram acionados
		verify(rede).enviar(any(Pacote.class));
	}

	@Test(expected = ExcecaoChat.class)
	public void arquivoCorrompido() throws RemoteException {
		Rede rede = mockRede(true);

<<<<<<< HEAD
		// Preparar ambiente
		Chat chat = new Chat("8.8.8.8", rede);
		reset(rede);

		// Predefinir lançamento de exceção
=======
		Chat chat = criarChat(rede);
		
		//Predefinir lançamento de exceção
>>>>>>> b8a7f18dd574c143956636a84c609f40e16daff2
		doThrow(new RemoteException()).when(rede).enviar(any(Pacote.class));

		// Efetuar um estímulo
		chat.enviarArquivo(new File("temp.txt"));
	}

	private Chat criarChat(Rede rede) {
		Chat chat = new Chat("8.8.8.8", rede);
		reset(rede);
		return chat;
	}


}
