package com.terremoto.alarme;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class AlarmeTest {
	
	
	@Test
	public void terremotoForte() {
		//Criar mocks
		Exercito exercito = mock(Exercito.class);
		
		//Preparar ambiente
		Alarme alarme = new Alarme();
		alarme.setExercito(exercito);
		
		//Efetuar um estímulo
		alarme.tremorDetectado(8, true);

		//Verificar se os mocks foram acionados 
		verify(exercito).suporteTragedia();
	}
	
	@Test
	public void maremotoForte() {
		//Criar mocks
		GuardaCosteira guardaCosteira = mock(GuardaCosteira.class);
		
		//Preparar ambiente
		Alarme alarme = new Alarme();
		alarme.setGuardaCosteira(guardaCosteira);
		
		//Efetuar um estímulo
		alarme.tremorDetectado(8, false);

		//Verificar se os mocks foram acionados 
		verify(guardaCosteira).alertaTsunami();
	}
	
	@Test
	public void queimada() {
		//Criar mocks
		CorpoBombeiros corpoBombeiros = mock(CorpoBombeiros.class);
		
		//Preparar ambiente
		Alarme alarme = new Alarme();
		alarme.setCorpoBombeiros(corpoBombeiros);
		
		//Efetuar um estímulo
		alarme.queimadaDetectada();

		//Verificar se os mocks foram acionados 
		verify(corpoBombeiros).alertaIncendio();
	}

}
