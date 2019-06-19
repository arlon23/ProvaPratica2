import java.util.Calendar;
import java.util.Date;

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
			horarioAntec = Lembrete.calculaHora(this.minAntec, this.periodo.horarioInicio);
			System.out.println(horarioAntec);
			if (this.periodo.dataInicio.equals(dataLembrete)) {
				if((horario.compareTo(horarioAntec) == 1) && (horario.compareTo(this.periodo.horarioInicio) == -1)){
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
		String concat = new StringBuilder().append("Lembrete: ").append(this.titulo).append("\nData Inicio: ").append(this.periodo.dataInicio)
				.append("\nHorário Inicio: ").append(this.periodo.horarioInicio).append("\nDescrição: ").append(this.descricao).append("\n\n\nAviso de Antecedência: ").append(this.minAntec).append(" minutos.\nData Fim: ")
				.append(this.periodo.dataFim).append("\nHorário Fim: ").append(this.periodo.horarioFim).toString();
		return concat;
	}

}
