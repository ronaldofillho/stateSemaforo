import java.lang.Thread;

public class Semaforo {
	
	private String numTombamento = null;

	private EstadoSemaforo estado = new Vermelho(this);
	
	public Semaforo(String numTombamento) {
        this.numTombamento = numTombamento;
	}
	
	public String getNumTombamento() {
		return numTombamento;
	}

	public void setNumTombamento(String numTombamento) {
		this.numTombamento = numTombamento;
	}

	public void setEstadoAtual(EstadoSemaforo estado){
		this.estado = estado;
	}
	
	public EstadoSemaforo getEstadoAtual() {
		return this.estado;
	}
	
	
	public void exibir() {
		System.out.println(" Vermelho  ( " + (this.estado instanceof Vermelho?" X ":" ") + " )");
		System.out.println(" Amarelo   ( " + (this.estado instanceof Amarelo?" X ":" ") + " )");
		System.out.println(" Verde     ( " + (this.estado instanceof Verde?" X ":" ") + " )");
	}
	
	public void efetuarTransicao() {
	    this.estado.proximoEstado();
	}
	
	public void showVisorRegressivo() {
		for (int i = this.estado.iniciarTimer(); i >0 ; i--) {
			System.out.println(i + " segundo(s)");
			try {
				// 1000 milisegundos equivale a 1 segundo
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void start() {
		this.start(10);
	}

	public void start(int time_in_seconds) {
		while(time_in_seconds > 0) {
			System.out.println("Tempo restante da simulacao: " + time_in_seconds + " segundos");
			exibir();
			time_in_seconds -= this.estado.iniciarTimer();
			showVisorRegressivo();
			efetuarTransicao();
			System.out.println();
		}
		
	}
	
	public String toString() {
		String s = "";
		s += "Numero Tombamento: " + numTombamento + "\n";
		return s;
	}
	

}