
public abstract class ItemAgenda {
	String titulo, descricao;
	Periodo periodo;
	
	public ItemAgenda () {
		this.titulo = "";
		this.descricao = "";
		this.periodo = new Periodo();
	}
	
	public ItemAgenda (String titulo, String descricao, Periodo periodo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.periodo = periodo;
	}
	
	public ItemAgenda (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.periodo = new Periodo(dataInicio, horarioInicio, dataFim, horarioFim);
	}
	
	public abstract String toString ();
}
