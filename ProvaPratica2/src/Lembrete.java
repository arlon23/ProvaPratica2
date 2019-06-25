import java.io.Serializable;

/**Classe filha da classe ItemAgenda, onde está contido o tempo de aviso e os métodos para o mesmo.
* @author Arlon Scheidegger
* @version 1.0
*/

public class Lembrete extends ItemAgenda implements Comparable<ItemAgenda>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int minAntec;
	
	/**Construtor default do objeto tipo Lembrete, onde é utilizado o contrutor default no ItemAgenda
	* e a entrada do minutos de aviso é inicializado com 10.
	* @author Arlon Scheidegger
	*/
	
	public Lembrete () {
		super();
		this.minAntec = 10;
	}
	
	/**Construtor completo da meta com a entrada do Periodo instanciado
	* @author Arlon Scheidegger
	* @param titulo String - Nome do título da meta.
	* @param descricao String - Descrição da meta.
	* @param periodo Periodo - Periodo da meta.
	* @param minAntec int - Valor do tempo início do aviso do lembrete.
	*/
	
	public Lembrete (String titulo, String descricao, Periodo periodo, int minAntec) {
		super(titulo, descricao, periodo);
		this.minAntec = minAntec;
	}
	
	/**Construtor completo da meta com a entrada do Periodo sem ser instanciado
	* @author Arlon Scheidegger
	* @param titulo String - Nome do título da meta.
	* @param descricao String - Descrição da meta.
	* @param dataInicio Data - Data de início do período.
	* @param horarioInicio Horario - Horario de início do período.
	* @param dataFim Data - Data de fim do período.
	* @param horarioFim Horario - Horario de fim do período.
	* @param minAntec int - Valor do tempo início do aviso do lembrete.
	*/
	
	public Lembrete (String titulo, String descricao, Data dataInicio, Data dataFim, Horario horarioInicio, Horario horarioFim, int minAntec) {
		super(titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim);
		this.minAntec = minAntec;
	}
	
	/**Método para calcular a hora para aviso do lembrete
	* @author Arlon Scheidegger
	* @param minAntec int - Valor do tempo início do aviso do lembrete.
	* @param horarioInicio Horario - Hora de início do lembrete.
	* @return Horario
	*/
	
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
	
	/**Método para mostar se a data e hora atual da máquina está entre o periodo de aviso do lembrete.
	* @author Arlon Scheidegger
	* @return boolean
	*/
	
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
	
	public int getMinAntec() {
		return minAntec;
	}

	public void setMinAntec(int minAntec) {
		this.minAntec = minAntec;
	}
	
	/**Método para comparar se dois lembretes são iguais, menor ou maior.
	* @author Arlon Scheidegger
	* @param o ItemAgenda - Variável do tipo ItemAgenda onde será feito um casting para Lembrete e fazer a verificação.
	* @return boolean
	*/
	
	@Override
	public int compareTo(ItemAgenda o) {
		// TODO Auto-generated method stub
		Lembrete lembrete = (Lembrete)o;
		if(this.minAntec > lembrete.getMinAntec()) return 1;
		else if (this.minAntec < lembrete.getMinAntec()) return -1;
		else return 0;
	}

	@Override
	public String toString() {
		String concat = new StringBuilder().append("Lembrete: ").append(this.getTitulo()).append("\nData Inicio: ").append(this.getPeriodo().dataInicio)
				.append("\nHorário Inicio: ").append(this.getPeriodo().horarioInicio).append("\nDescrição: ").append(this.getDescricao()).append("\n\nAviso de Antecedência: ").append(this.minAntec).append(" minutos.\nData Fim: ")
				.append(this.getPeriodo().dataFim).append("\nHorário Fim: ").append(this.getPeriodo().horarioFim).append("\n\n\n").toString();
		return concat;
	}

	

}
