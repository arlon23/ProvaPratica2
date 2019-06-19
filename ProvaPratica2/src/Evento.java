
public class Evento extends ItemAgenda{

	String local;
	
	public Evento () {
		super();
		this.local = "";
	}
	
	public Evento (String titulo, String descricao, Periodo periodo, String local) {
		super(titulo, descricao, periodo);
		this.local = local;
	}
	
	public Evento (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim, String local) {
		super(titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim);
		this.local = local;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
