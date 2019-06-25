import java.io.Serializable;
import java.util.Comparator;

public abstract class ItemAgenda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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


class Prioridade implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda itemAgenda1, ItemAgenda itemAgenda2) {
		if(itemAgenda1.getClass() == Meta.class && itemAgenda2.getClass() == Meta.class) {
			Meta meta1 = (Meta) itemAgenda1, meta2 = (Meta) itemAgenda2;
			int prioridadeMeta1 = meta1.getPrioridade(), prioridadeMeta2 = meta2.getPrioridade();
			if (prioridadeMeta1 > prioridadeMeta2) {
				return 1;
			}
			else if (prioridadeMeta1 < prioridadeMeta2) {
				return -1;
			}
			else {
				return 0;
			}
		}
		
		else if(itemAgenda1.getClass() == Lembrete.class && itemAgenda2.getClass() == Lembrete.class) {
			Lembrete lembrete1 = (Lembrete) itemAgenda1, lembrete2 = (Lembrete) itemAgenda2;
			int minAntec1 = lembrete1.getMinAntec(), minAntec2 = lembrete2.getMinAntec();
			if (minAntec1 > minAntec2) {
				return 1;
			}
			else if (minAntec1 < minAntec2) {
				return -1;
			}
			else {
				return 0;
			}
		}
		
		else if(itemAgenda1.getClass() == Evento.class && itemAgenda2.getClass() == Evento.class) {
			Evento evento1 = (Evento) itemAgenda1;
			Evento evento2 = (Evento) itemAgenda2;
			return evento1.getLocal().compareToIgnoreCase(evento2.getLocal());
		
		}
		else return 0;
	}

}
