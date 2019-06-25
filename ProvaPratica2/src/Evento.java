import java.io.Serializable;

/**Classe filha da classe ItemAgenda, onde está contido o local e os métodos.
* @author Arlon Scheidegger
* @version 1.0
*/

public class Evento extends ItemAgenda implements Comparable<ItemAgenda>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String local;
	
	/**Construtor default do objeto tipo Evento, onde é utilizado o contrutor default no ItemAgenda
	* e o local do evento é inicializado com vazio.
	* @author Arlon Scheidegger
	*/
	
	public Evento () {
		super();
		this.local = "";
	}
	
	/**Construtor completo do evento com a entrada do Periodo instanciado
	* @author Arlon Scheidegger
	* @param titulo String - Nome do título da meta.
	* @param descricao String - Descrição da meta.
	* @param periodo Periodo - Periodo da meta.
	* @param local String - Local do evento.
	*/
	
	
	public Evento (String titulo, String descricao, Periodo periodo, String local) {
		super(titulo, descricao, periodo);
		this.local = local;
	}
	
	/**Construtor completo da meta com a entrada do Periodo sem ser instanciado
	* @author Arlon Scheidegger
	* @param titulo String - Nome do título da meta.
	* @param descricao String - Descrição da meta.
	* @param dataInicio Data - Data de início do período.
	* @param horarioInicio Horario - Horario de início do período.
	* @param dataFim Data - Data de fim do período.
	* @param horarioFim Horario - Horario de fim do período.
	* @param local String - Local do evento.
	*/
	
	public Evento (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim, String local) {
		super(titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim);
		this.local = local;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	/**Método para comparar dois Eventos se são iguais, menor ou maior.
	* @author Arlon Scheidegger
	* @param o ItemAgenda - Variável do tipo ItemAgenda onde será feito um casting para Evento e fazer a verificação.
	* @return boolean
	*/
	
	@Override
	public int compareTo(ItemAgenda o) {
		// TODO Auto-generated method stub
		Evento evento = (Evento)o;
		return this.getLocal().compareToIgnoreCase(evento.getLocal());
	}
	
	@Override
	public String toString() {
		String concat = new StringBuilder().append("Evento: ").append(this.getTitulo()).append("\nData Inicio: ").append(this.getPeriodo().dataInicio)
				.append("\nHorário Inicio: ").append(this.getPeriodo().horarioInicio).append("\nDescrição: ").append(this.getDescricao()).append("\nAviso de Antecedência: ").append(this.local).append("\nData Fim: ")
				.append(this.getPeriodo().dataFim).append("\nHorário Fim: ").append(this.getPeriodo().horarioFim).append("\n\n\n").toString();
		return concat;
	}

	

	

	
	
}
