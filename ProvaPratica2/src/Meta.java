
public class Meta extends ItemAgenda {

	int prioridade;
	
	public Meta () {
		super();
		this.prioridade = 0;
	}
	
	public Meta (int prioridade) {
		super();
		this.prioridade = prioridade;
	}
	
	public Meta (String titulo, String descricao, Periodo periodo, int prioridade) {
		super(titulo, descricao ,periodo);
		this.prioridade = prioridade;
	}
	
	public Meta (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim, int prioridade) {
		super(titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim);
		this.prioridade = prioridade;
	}
	
	@Override
	public String toString() {
		String concat = new StringBuilder().append("Meta: ").append(this.titulo).append("\nData Inicio: ").append(this.periodo.dataInicio)
				.append("\nHorário Inicio: ").append(this.periodo.horarioInicio).append("\nDescrição: ").append(this.descricao).append("\n\n\nData Fim: ")
				.append(this.periodo.dataFim).append("\nHorário Fim: ").append(this.periodo.horarioFim).toString();
		return concat;
	}

}
