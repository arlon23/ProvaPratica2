
public class Lembrete extends ItemAgenda {

	int minAntec;
	
	public Lembrete () {
		super();
		this.minAntec = 10;
	}
	
	public Lembrete (String titulo, String descricao, Periodo periodo, int minAntec) {
		super(titulo, descricao, periodo);
		this.minAntec = minAntec;
	}
	
	public Lembrete (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim, int minAntec) {
		super(titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim);
		this.minAntec = minAntec;
	}
	
	@Override
	public String toString() {
		String concat = new StringBuilder().append("Lembrete: ").append(this.titulo).append("\nData Inicio: ").append(this.periodo.dataInicio)
				.append("\nHorário Inicio: ").append(this.periodo.horarioInicio).append("\nDescrição: ").append(this.descricao).append("\n\n\nAviso de Antecedência: ").append(this.minAntec).append(" minutos.\nData Fim: ")
				.append(this.periodo.dataFim).append("\nHorário Fim: ").append(this.periodo.horarioFim).toString();
		return concat;
	}

}
