import java.io.Serializable;
import java.util.Comparator;


/**Classe abstrata para os Itens da agenda.
* @author Arlon Scheidegger
* @version 1.0
*/
public abstract class ItemAgenda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo, descricao;
	private Periodo periodo;
	
	/**Contrutor padrão do ItemAgenda, onde as variáveis são setadas como String vazia e o periodo com valor default.
	* @author Arlon Scheidegger
	*/
	
	
	public ItemAgenda () {
		this.titulo = "";
		this.setDescricao("");
		this.periodo = new Periodo();
	}
	
	/**Contrutor completo com todas as informações necessárias para criação de um ItemAgenda.
	* @author Arlon Scheidegger
	* @param titulo String - Titulo do ItemAgenda.
	* @param descricao String - Descricao do ItemAgenda.
	* @param periodo Periodo - Periodo do ItemAgenda.
	*/
	
	public ItemAgenda (String titulo, String descricao, Periodo periodo) {
		this.titulo = titulo;
		this.setDescricao(descricao);
		this.periodo = periodo;
	}
	
	/**Contrutor completo com todas as informações necessárias, e as informações do período de forma detalhada.
	* @author Arlon Scheidegger
	* @param titulo String - Titulo do ItemAgenda.
	* @param descricao String - Descricao do ItemAgenda.
	* @param dataInicio Data - Data de inicio do Periodo.
	* @param horarioInicio Horario - Horario de inicio do Periodo.
	* @param dataInicio Data - Data de fim do Periodo.
	* @param dataInicio Data - Horário de fim do Periodo.
	* @return ItemAgenda
	*/
	
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


/**Classe para comparar e dois elementos de um objeto do tipo ItemAgenda
* @author Arlon Scheidegger
* @param itemAgenda1 ItemAgenda - Elemento do tipo ItemAgenda para comparação
* @param itemAgenda2 ItemAgenda - Elemento do tipo ItemAgenda para comparação
* @return int
* @version 1.0
*/

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
