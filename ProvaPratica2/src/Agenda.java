import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Agenda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ItemAgenda> agenda = new LinkedList<ItemAgenda>();

	public void inserirLista (Meta meta) {
		this.agenda.add(meta);
	}
	
	public void inserirLista (Lembrete lembrete) {
		this.agenda.add(lembrete);
	}
	
	public void inserirLista (Evento evento) {
		this.agenda.add(evento);
	}
	
	
	public static Agenda listarPorPeriodo(Agenda agenda, Data dataInicio, Data dataFim) {
		Agenda agendaPeriodo = new Agenda();
		
		for(int i=0; i < agenda.agenda.size(); i++) {
			if(((agenda.agenda.get(i).getPeriodo().dataInicio.compareTo(dataInicio) == -1) || (agenda.agenda.get(i).getPeriodo().dataInicio.compareTo(dataInicio) == 0)) 
					&& ((agenda.agenda.get(i).getPeriodo().dataFim.compareTo(dataFim) == 1) || (agenda.agenda.get(i).getPeriodo().dataFim.compareTo(dataFim) == 0))) {
			agendaPeriodo.agenda.add(agenda.agenda.get(i));
		}
		}		
		return agendaPeriodo;
	}
	
	public static Agenda ordenar(Agenda agenda, int op) {
		Agenda agenda2 = agenda;
		Agenda agendaOrdenada = new Agenda();
		Collections.sort(agenda2.agenda, new Prioridade());

		for (int i = 0; i < agenda.agenda.size(); i++) {
			if (agenda.agenda.get(i).getClass() == Meta.class && op == 3) {
				agendaOrdenada.agenda.add(agenda.agenda.get(i));
			}
			else if (agenda.agenda.get(i).getClass() == Lembrete.class && op == 4) {
				agendaOrdenada.agenda.add(agenda.agenda.get(i));
			}
			else if (agenda.agenda.get(i).getClass() == Evento.class && op == 5) {
				agendaOrdenada.agenda.add(agenda.agenda.get(i));
			}
		}
		return agendaOrdenada;
	}
	
	public String toString() {
		StringBuilder concat = new StringBuilder();
		
		
		for(int i=0; i < this.agenda.size(); i++) {
			concat.append(this.agenda.getClass()).append("\n");
			concat.append(this.agenda.get(i));
			
		}
		
		return concat.toString();
	}
	
	
	
}
