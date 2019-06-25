import java.io.Serializable;

public class Evento extends ItemAgenda implements Comparable<ItemAgenda>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	public int compareTo(ItemAgenda o) {
		// TODO Auto-generated method stub
		Evento evento = (Evento)o;
		return this.getLocal().compareToIgnoreCase(evento.getLocal());
	}
	
	@Override
	public String toString() {
		String concat = new StringBuilder().append("Evento: ").append(this.getTitulo()).append("\nData Inicio: ").append(this.getPeriodo().dataInicio)
				.append("\nHorário Inicio: ").append(this.getPeriodo().horarioInicio).append("\nDescrição: ").append(this.getDescricao()).append("\nAviso de Antecedência: ").append(this.local).append("\nData Fim: ")
				.append(this.getPeriodo().dataFim).append("\nHorário Fim: ").append(this.getPeriodo().horarioFim).append("\n\n\n").toString();
		return concat;
	}

	

	

	
	
}
