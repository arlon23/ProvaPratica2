import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	
	
	public static Agenda listarPorPeriodo(Data dataInicio, Data dataFim) {
		Agenda agendaPeriodo = Agenda.leArquivo("Agenda");
		
		for(int i=0; i < agendaPeriodo.agenda.size(); i++) {
			if(((agendaPeriodo.agenda.get(i).getPeriodo().dataInicio.compareTo(dataInicio) == -1) || (agendaPeriodo.agenda.get(i).getPeriodo().dataInicio.compareTo(dataInicio) == 0)) 
					&& ((agendaPeriodo.agenda.get(i).getPeriodo().dataFim.compareTo(dataFim) == 1) || (agendaPeriodo.agenda.get(i).getPeriodo().dataFim.compareTo(dataFim) == 0))) {
			agendaPeriodo.agenda.add(agendaPeriodo.agenda.get(i));
		}
		}		
		return agendaPeriodo;
	}
	
	public static Agenda ordenar(String nomeArquivo, int op) {
		Agenda agenda2 = Agenda.leArquivo(nomeArquivo+".obj");
		Agenda agendaOrdenada = new Agenda();
		Collections.sort(agenda2.agenda, new Prioridade());

		for (int i = 0; i < agenda2.agenda.size(); i++) {
			if (agenda2.agenda.get(i).getClass() == Meta.class && op == 3) {
				agendaOrdenada.agenda.add(agenda2.agenda.get(i));
			}
			else if (agenda2.agenda.get(i).getClass() == Lembrete.class && op == 4) {
				agendaOrdenada.agenda.add(agenda2.agenda.get(i));
			}
			else if (agenda2.agenda.get(i).getClass() == Evento.class && op == 5) {
				agendaOrdenada.agenda.add(agenda2.agenda.get(i));
			}
		}
		if(op == 3) Agenda.salvarArquivo(agendaOrdenada, "MetaOrdenada");
		else if(op == 4) Agenda.salvarArquivo(agendaOrdenada, "MetaOrdenada");
		else if(op == 5) Agenda.salvarArquivo(agendaOrdenada, "MetaOrdenada");
		return agendaOrdenada;
	}
	
	public static void salvarArquivo(Agenda agenda, String nomeArquivo) {
		ObjectOutputStream arquivo;
		try {
			arquivo = new ObjectOutputStream(new FileOutputStream(nomeArquivo+".obj"));
			arquivo.writeObject(agenda);
			arquivo.flush();
			arquivo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void atualizarAgenda() {
		Agenda agendaArquivo = Agenda.leArquivo("Agenda");
		
		for(int i = 0; i < this.agenda.size(); i++) {
			agendaArquivo.agenda.add(this.agenda.get(i));
		}
		
		Agenda.salvarArquivo(agendaArquivo, "Agenda");
		
	}
	
	@SuppressWarnings("resource")
	public static Agenda leArquivo(String nomeArquivo) {
		ObjectInputStream arquivo;
		try {
			arquivo = new ObjectInputStream(new FileInputStream(nomeArquivo));
			Agenda agenda;
			agenda = (Agenda) arquivo.readObject();
			arquivo.close();
			return agenda;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	public int getSize() {
		return this.agenda.size();
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
