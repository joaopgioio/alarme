package com.terremoto.alarme;

import java.io.File;
import java.rmi.RemoteException;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class ChatTest {
	
	@Test
	public void abrirConexao() {
		//Criar mocks
		Rede rede = mock(Rede.class);
	
		//Predefinir retorno
		when(rede.abrirConexao(anyString())).thenReturn(true);

		//Efetuar um estímulo
		new Chat("1.1.1.1", rede);

		//Verificar se os mocks foram acionados 
		verify(rede).abrirConexao(anyString());
	}

	@Test
	public void enviarArquivo() throws RemoteException {
		//Criar mocks
		Rede rede = mock(Rede.class);
	
		//Predefinir retorno
		when(rede.abrirConexao(anyString())).thenReturn(true);
		
		//Preparar ambiente
		Chat chat = new Chat("8.8.8.8", rede);
		reset(rede);

		//Efetuar um estímulo
		chat.enviarArquivo(new File("temp.txt"));

		//Verificar se os mocks foram acionados 
		verify(rede).enviar(any(Pacote.class));
	}

	@Test(expected=ExcecaoChat.class)
	public void arquivoCorrompido() throws RemoteException {
		//Criar mocks
		Rede rede = mock(Rede.class);
	
		//Predefinir retorno
		when(rede.abrirConexao(anyString())).thenReturn(true);

		//Preparar ambiente
		Chat chat = new Chat("8.8.8.8", rede);
		reset(rede);
		
		//Predefinir lançamento de exceção
		doThrow(new RemoteException()).when(rede).enviar(any(Pacote.class));

		//Efetuar um estímulo
		chat.enviarArquivo(new File("temp.txt"));
	}

}
