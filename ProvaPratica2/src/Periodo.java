import java.io.Serializable;

/**Classe para objetos do tipo Periodo que contém variáveis do tipo Data e Horario.
* @author Arlon Scheidegger
* @version 1.0
*/

public class Periodo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Data dataInicio, dataFim;
	Horario horarioInicio, horarioFim;
	
	/**Construtor default do Periodo onde dataInicio é inicializada no dia atual da maquina
	 * Data fim é criada 7 dias depois da dataInicio e
	 * horarioInicio e horarioFim são inicializados no horário atual da máquina.
	* @author Arlon Scheidegger
	*/
	
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
	
	/**Construtor completo com todos os dados necessários para inicialização de um Periodo
	* @author Arlon Scheidegger
	* @param dataInicio Data - Data do início do Periodo
	* @param hoarioInicio Data - horário do início do Periodo
	* @param dataFim Data - Data do fim do Periodo
	* @param horarioFim Data - Data do fim do Periodo
	*/
	
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
