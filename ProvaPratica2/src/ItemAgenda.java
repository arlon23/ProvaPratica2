

public abstract class ItemAgenda {
	private String titulo, descricao;
	private Periodo periodo;
	
	public ItemAgenda () {
		this.titulo = "";
		this.setDescricao("");
		this.periodo = new Periodo();
	}
	
	public ItemAgenda (String titulo, String descricao, Periodo periodo) {
		this.titulo = titulo;
		this.setDescricao(descricao);
		this.periodo = periodo;
	}
	
	public ItemAgenda (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim) {
		this.titulo = titulo;
		this.setDescricao(descricao);
		this.periodo = new Periodo(dataInicio, horarioInicio, dataFim, horarioFim);
	}
	
	public abstract String toString ();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}
