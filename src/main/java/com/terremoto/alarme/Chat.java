package com.terremoto.alarme;

import java.io.File;
import java.rmi.RemoteException;

public class Chat {

	private Rede rede;

	public Chat(String ip, Rede rede) {
		this.rede = rede;
		
		if (!rede.abrirConexao("1.1.1.1")) {
			throw new ExcecaoChat();
		}
	}

	public void enviarArquivo(File temp) throws RemoteException {
		Pacote pacote = new Pacote();
		
		try {
			rede.enviar(pacote);
		} catch (RemoteException e) {
			throw new ExcecaoChat();
		}
	}

}
