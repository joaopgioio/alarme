package com.terremoto.alarme;

public class Alarme {

	private Exercito exercito;
	private GuardaCosteira guardaCosteira;
	private CorpoBombeiros corpoBombeiros;

	public void tremorDetectado(int magnitude, boolean terrestre) {
		
		if (terrestre) {
			exercito.suporteTragedia();
		} else {
			guardaCosteira.alertaTsunami();
		}
	}
	
	public void queimadaDetectada() {
		corpoBombeiros.alertaIncendio();
	}

	public void setExercito(Exercito exercito) {
		this.exercito = exercito;
	}

	public void setGuardaCosteira(GuardaCosteira guardaCosteira) {
		this.guardaCosteira = guardaCosteira;
	}

	public void setCorpoBombeiros(CorpoBombeiros corpoBombeiros) {
		this.corpoBombeiros = corpoBombeiros;
	}

}
