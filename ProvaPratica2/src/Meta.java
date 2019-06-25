import java.io.Serializable;

public class Meta extends ItemAgenda implements Comparable<ItemAgenda>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int prioridade;
	
	public Meta () {
		super();
		this.setPrioridade(0);
	}
	
	public Meta (int prioridade) {
		super();
		this.setPrioridade(prioridade);
	}
	
	public Meta (String titulo, String descricao, Periodo periodo, int prioridade) {
		super(titulo, descricao ,periodo);
		this.setPrioridade(prioridade);
	}
	
	public Meta (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim, int prioridade) {
		super(titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim);
		this.setPrioridade(prioridade);
	}
	
	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}


	@Override
	public int compareTo(ItemAgenda o) {
		// TODO Auto-generated method stub
		Meta meta = (Meta)o;
		if(this.prioridade > meta.getPrioridade()) return 1;
		else if (this.prioridade < meta.getPrioridade()) return -1;
		else return 0;
	}
	
	@Override
	public String toString() {
		String concat = new StringBuilder().append("Nível Prioridade: ").append(this.prioridade).append("\nMeta: ").append(this.getTitulo()).append("\nData Inicio: ").append(this.getPeriodo().dataInicio)
				.append("\nHorário Inicio: ").append(this.getPeriodo().horarioInicio).append("\nDescrição: ").append(this.getDescricao()).append("\n\nData Fim: ")
				.append(this.getPeriodo().dataFim).append("\nHorário Fim: ").append(this.getPeriodo().horarioFim).append("\n\n\n").toString();
		return concat;
	}

	

}

