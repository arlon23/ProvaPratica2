
public class Meta extends ItemAgenda {

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
	
	@Override
	public String toString() {
		String concat = new StringBuilder().append("Meta: ").append(this.getTitulo()).append("\nData Inicio: ").append(this.getPeriodo().dataInicio)
				.append("\nHorário Inicio: ").append(this.getPeriodo().horarioInicio).append("\nDescrição: ").append(this.getDescricao()).append("\n\n\nData Fim: ")
				.append(this.getPeriodo().dataFim).append("\nHorário Fim: ").append(this.getPeriodo().horarioFim).toString();
		return concat;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

}
