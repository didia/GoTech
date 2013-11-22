package domainePartie1;

public class StrategieMinchemin extends StrategieGestion {
	public StrategieMinchemin() {
		super();
	}

	public Urgence reqUrgenceAcctuelle() {
		return this.reqUrgencActuelle();
	}
	public String toString(){
		return Default.STRATEGIE_MIN;
	}
}
