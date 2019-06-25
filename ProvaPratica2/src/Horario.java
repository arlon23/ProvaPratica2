import java.io.Serializable;
import java.util.Calendar;

/**Classe para objetos do tipo Horario, onde são contidos a hora, minutos e segundos e os métodos para o mesmo.
* @author Arlon Scheidegger
* @version 1.0
*/

public class Horario  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hora, min, sec;
	
	
	/**Construtor para inicialização default, onde horário é inicializado com o horário atual da máquina.
	* @author Arlon Scheidegger
	*/
	
	public Horario () {
		try {
			this.setHorario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**Construtor com entrada apenas da hora, sendo o restante das informações inicializadas com valor 0
	* @author Arlon Scheidegger
	* @param  hora int - Valor da hora para ser inicializada.
	*/
	
	public Horario (int hora) {
		try {
			this.setHorario(hora);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**Construtor com entrada apenas da hora e min, sendo o restante das informações inicializadas com valor 0
	* @author Arlon Scheidegger
	* @param  hora int - Valor da hora para ser inicializada.
	* @param  min int - Valor do minuto para ser inicializado.
	*/
	
	public Horario (int hora, int min) {
		try {
			this.setHorario(hora, min);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**Construtor completo para inicialização
	* @author Arlon Scheidegger
	* @param  hora int - Valor da hora para ser inicializada.
	* @param  min int - Valor do minuto para ser inicializado.
	* @param  sec int - Valor do segundo para ser inicializado.
	*/
	
	public Horario (int hora, int min, int sec) {
		try {
			this.setHorario(hora, min, sec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**Construtor para entrada do horário como String - modelo (XX:XX:XX)
	* @author Arlon Scheidegger
	* @param  hora String - Valor da hora no modelo mostrado acima para ser inicializado.
	*/
	
	public Horario (String hora) {
		String[] horaI = hora.split(":");
		int hora2[] = Horario.quebraHora(horaI);
		try {
			this.setHorario(hora2[0], hora2[1], hora2[2]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**Método estático para transformar um vetor de String em um vetor de inteiros
	* @author Arlon Scheidegger
	* @param  horaI StringI - Vetor com a hora separado em cada posição horaI[0] = hora, horaI[1] = min, horaI[2] = sec.
	* @return int[]
	*/
	
	public static int[] quebraHora(String[] horaI) {
		int horaIn[] = new int[3];

		for (int i = 0; i<horaI.length; i++) {
			horaIn[i] = Integer.parseInt(horaI[i]);
		}
		
		return horaIn;
	}
	
	/**Método estático para verificar se uma hora é válida.
	* @author Arlon Scheidegger
	* @param  hora int - Hora para verificação
	* @param  min int - Minutos para verificação
	* @param  sec int - Segundos para verificação
	* @return boolean
	*/
	
	public static boolean  isHorarioValido (int hora, int min, int sec) {
			if(((hora >= 0) && (hora < 24) ) && ( (min >= 0) && (min < 60)) && ( (sec >= 0) && (sec < 60))) {
				return true;
			}
		return false;
	}
	
	/**Método para verificar se uma hora é válida.
	* @author Arlon Scheidegger
	* @return boolean
	*/
	
	public boolean isHorarioValido() {
		return Horario.isHorarioValido(this.getHora(), this.getMin(), this.getSec());
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}
	
	
	
	public void setHorario() throws Exception {
		Calendar day = Calendar.getInstance();
		
		if( Horario.isHorarioValido(day.get(Calendar.HOUR_OF_DAY), day.get(Calendar.MINUTE), day.get(Calendar.SECOND)) ) {
			this.hora = day.get(Calendar.HOUR_OF_DAY);
			this.min = day.get(Calendar.MINUTE);
			this.sec = day.get(Calendar.SECOND);
		}else {
			throw new Exception("Horario Inválido");
		}
	}
	
	public void setHorario(int hora) throws Exception {
		if( Horario.isHorarioValido(hora, 0, 0)) {
			this.hora = hora;
			this.min = 0;
			this.sec = 0;
		}else {
			throw new Exception("Horario Inválido");
		}
	}

	public void setHorario(int hora, int min) throws Exception {
		if (Horario.isHorarioValido(hora, min, 0)) {		
			this.hora = hora;
			this.min = min;
			this.sec = 0;
		}else {
			throw new Exception("Horario Inválido");
		}
	}

	public void setHorario(int hora, int min, int sec) throws Exception {
		if(Horario.isHorarioValido(hora, min, sec)) {
			this.hora = hora;
			this.min = min;
			this.sec = sec;
		}else {
			throw new Exception("Horario Inválido");
		}
	}
	
	/**Método para verificar se dois horários são iguais.
	* @author Arlon Scheidegger
	* @param  horario Horario - Hora para verificação
	* @return boolean
	*/
	
	public boolean equals(Horario horario) {

		if ((this.getHora() == horario.getHora()) && (this.getMin() == horario.getMin()) && (this.getSec() == horario.getSec())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**Método para verificar se dois horários são iguais, menor ou maior.
	* @author Arlon Scheidegger
	* @param  horario Horario - Hora para verificação
	* @return int
	*/
	
	
	public int compareTo(Horario horario) {
		if (this.getHora() > horario.getHora()) {
			return 1;
		} else if (this.getHora() < horario.getHora()) {
			return -1;
		} else {
			if (this.getMin() > horario.getMin()) {
				return 1;
			} else if (this.getMin() < horario.getMin()) {
				return -1;
			} else {
				if (this.getSec() > horario.getSec()) {
					return 1;
				} else if (this.getSec() < horario.getSec()) {
					return -1;
				} else
					return 0;
			}
		}
	}
	
	public String toString(){
		String concat = new StringBuilder().append(this.getHora()).append(":").append(this.getMin()).append(":").append(this.getSec()).toString();
    	return concat;
	}


}
