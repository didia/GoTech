package domainePartie1;

public class StrategieAnciennete extends StrategieGestion {
	
	public StrategieAnciennete()
	{
		super();
	}
	public Urgence reqUrgenceAcctuelle()
	{
		return this.reqUrgencActuelle();
	}
}
