import java.io.Serializable;

/**Classe filha da classe ItemAgenda, onde está contido o nível de prioridade da meta e os métodos.
* @author Arlon Scheidegger
* @version 1.0
*/

public class Meta extends ItemAgenda implements Comparable<ItemAgenda>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int prioridade;
	
	/**Construtor default do objeto tipo Meta, onde é utilizado o contrutor default no ItemAgenda
	* e a prioridade da meta é inicializado com 0.
	* @author Arlon Scheidegger
	*/
	
	public Meta () {
		super();
		this.setPrioridade(0);
	}
	
	/**Construtor contendo apenas a prioridade da meta
	 * onde os restantes da informações são inicializados no contrutor default do ItemAgenda
	* @author Arlon Scheidegger
	* @param prioridade int - Prioridade da meta sendo 0 como menor prioridade.
	*/
	
	public Meta (int prioridade) {
		super();
		this.setPrioridade(prioridade);
	}
	
	/**Construtor completo da meta com a entrada do Periodo instanciado
	* @author Arlon Scheidegger
	* @param titulo String - Nome do título da meta.
	* @param descricao String - Descrição da meta.
	* @param periodo Periodo - Periodo da meta.
	* @param prioridade int - Prioridade da meta sendo 0 como menor prioridade.
	*/
	
	public Meta (String titulo, String descricao, Periodo periodo, int prioridade) {
		super(titulo, descricao ,periodo);
		this.setPrioridade(prioridade);
	}
	
	/**Construtor completo da meta com a entrada do Periodo sem ser instanciado
	* @author Arlon Scheidegger
	* @param titulo String - Nome do título da meta.
	* @param descricao String - Descrição da meta.
	* @param dataInicio Data - Data de início do período.
	* @param horarioInicio Horario - Horario de início do período.
	* @param dataFim Data - Data de fim do período.
	* @param horarioFim Horario - Horario de fim do período.
	* @param prioridade int - Prioridade da meta sendo 0 como menor prioridade.
	*/
	
	public Meta (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim, int prioridade) {
		super(titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim);
		this.setPrioridade(prioridade);
	}
	
	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}


	/**Método para comparar duas metas se são iguais, menor ou maior.
	* @author Arlon Scheidegger
	* @param o ItemAgenda - Variável do tipo ItemAgenda onde será feito um casting para Meta e fazer a verificação.
	* @return boolean
	*/
	
	@Override
	public int compareTo(ItemAgenda o) {
		// TODO Auto-generated method stub
		Meta meta = (Meta)o;
		if(this.prioridade > meta.getPrioridade()) return 1;
		else if (this.prioridade < meta.getPrioridade()) return -1;
		else return 0;
	}
	
	@Override
	public String toString() {
		String concat = new StringBuilder().append("Nível Prioridade: ").append(this.prioridade).append("\nMeta: ").append(this.getTitulo()).append("\nData Inicio: ").append(this.getPeriodo().dataInicio)
				.append("\nHorário Inicio: ").append(this.getPeriodo().horarioInicio).append("\nDescrição: ").append(this.getDescricao()).append("\n\nData Fim: ")
				.append(this.getPeriodo().dataFim).append("\nHorário Fim: ").append(this.getPeriodo().horarioFim).append("\n\n\n").toString();
		return concat;
	}

	

}

