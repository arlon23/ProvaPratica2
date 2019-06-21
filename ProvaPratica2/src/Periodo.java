
public class Periodo  {
	
	Data dataInicio, dataFim;
	Horario horarioInicio, horarioFim;
	
	public Periodo () {
		dataInicio = new Data();
		try {
			dataFim = dataInicio.incrementa(7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		horarioInicio = new Horario();
		horarioFim = new Horario();		
	}
	
	public Periodo (Data dataInicio, Horario horarioInicio, Data dataFim, Horario horarioFim) {
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}
	
	
	public String toString () {
		String concat = new StringBuilder().append("Data Inicio: ").append(this.dataInicio)
				.append("\nHorário Inicio: ").append(this.horarioInicio).append("\n\nData Fim: ")
				.append(this.dataFim).append("\nHorário Fim: ").append(this.horarioFim).toString();
		return concat;
	}
}
