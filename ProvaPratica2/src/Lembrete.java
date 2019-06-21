
public class Lembrete extends ItemAgenda {

	private int minAntec;
	
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
	
	public static Horario calculaHora (int minAntec, Horario horarioInicio) {
		Horario horario;
		int min = horarioInicio.getMin(), hora = horarioInicio.getHora();
		
		for(int i = 0; i <= minAntec; i++) {
			if(min >=0 && min < 60) {
				min--;
			}else {
				hora--;
				min = 59;
			}
		}
		
		horario = new Horario(hora, min);
		
		return horario;
	}
	
	public boolean aviso () {
		
		Data dataLembrete;
		Horario horario, horarioAntec;
		try {
			dataLembrete = new Data();
			horario = new Horario();
			horarioAntec = Lembrete.calculaHora(this.minAntec, this.getPeriodo().horarioInicio);
			if (this.getPeriodo().dataInicio.equals(dataLembrete)) {
				if((horario.compareTo(horarioAntec) == 1) && (horario.compareTo(this.getPeriodo().horarioInicio) == -1)){
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	@Override
	public String toString() {
		String concat = new StringBuilder().append("Lembrete: ").append(this.getTitulo()).append("\nData Inicio: ").append(this.getPeriodo().dataInicio)
				.append("\nHorário Inicio: ").append(this.getPeriodo().horarioInicio).append("\nDescrição: ").append(this.getDescricao()).append("\n\n\nAviso de Antecedência: ").append(this.minAntec).append(" minutos.\nData Fim: ")
				.append(this.getPeriodo().dataFim).append("\nHorário Fim: ").append(this.getPeriodo().horarioFim).toString();
		return concat;
	}

}
