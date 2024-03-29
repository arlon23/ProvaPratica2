import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**Classe para objetos do tipo Data, onde contém o dia, mês e o ano de uma data,
*  e todos os métodos nescessários para utilizarmos a data.
* @author Arlon Scheidegger
* @version 1.0
*/

public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dia, mes, ano;

	/**Contrutor padrão para a Classe, onde a data é setada com a data atual da máquina
	* @author Arlon Scheidegger
	*/
	
	public Data() {
		Date date = new Date();
		Calendar date2 = Calendar.getInstance();
		date2.setTime(date);
		
		this.dia = date2.get(Calendar.DAY_OF_MONTH);
		this.mes = date2.get(Calendar.MONTH) + 1;
		this.ano = date2.get(Calendar.YEAR);
	}

	/**Contrutor onde é necessário a entrada de todos os dados
	* @author Arlon Scheidegger
	* @param  dia int - Valor do dia que deseja criar.
	* @param  mes int - Valor do mes que deseja criar.
	* @param  ano int - Valor do ano que deseja criar.
	*/
	
	public Data(int dia, int mes, int ano) throws Exception {
		this.setData(dia, mes, ano);
	}

	/**Contrutor onde a entrada é uma String - modelo (XX/XX/XXXX)
	* @author Arlon Scheidegger
	* @param  dia String - Data escrita por extenso como no modelo citado acima.
	*/
	
	public Data(String data) throws Exception {
		this.setData(data);
	}

	/**Método estático onde faz a verificação se o ano é bissexto.
	* @author Arlon Scheidegger
	* @param  ano int - Valor do ano que deseja verificar.
	* @return boolean
	*/
	
	public static boolean isBissexto(int ano){
		return ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0);
	}

	/**Método para verificar se uma data é valida.
	* @author Arlon Scheidegger
	* @param  data Data - Data para verificação.
	* @return boolean
	*/
	public boolean isDataValida(Data data) throws Exception {
		return Data.isDataValida(data.getDia(), data.getMes(), data.getAno());
	}

	/**Método estático para verificar se uma data é valida.
	* @author Arlon Scheidegger
	* @param  dia int - dia para verificação.
	* @param  mes int - mes para verificação.
	* @param  ano int - ano para verificação.
	* @return boolean
	*/
	
	public static boolean isDataValida(int dia, int mes, int ano) throws Exception {
		if ((dia > 0 && dia <= 31) && ((mes > 0) && (mes <= 12)) && (ano >= 1900)) {
			if ((dia == 31) && ((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10)
					|| (mes == 12))) {
				return true;
			} else if (((dia == 29) && (mes == 2)) && isBissexto(ano)) {
				return true;
			} else if (((dia < 29) && (mes == 2)) && !isBissexto(ano)) {
				return true;
			} else if ((dia < 31) && ((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11) || (mes == 1) || (mes == 3)
					|| (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12))) {
				return true;
			}
		}
		return false;
	}

	/**Método para atualizar uma data quando necessário.
	* @author Arlon Scheidegger
	* @param  data String - Data em String para atualização.
	* @return void
	*/
	
	public void setData(String data) throws Exception {
		int firstindex = data.indexOf("/");
		int secindex = data.indexOf("/", firstindex + 1);
		if (Data.isDataValida(Integer.parseInt(data.substring(0, firstindex)),
				Integer.parseInt(data.substring((firstindex + 1), secindex)),
				Integer.parseInt(data.substring((secindex + 1), (secindex + 5))))) {
			this.dia = Integer.parseInt(data.substring(0, firstindex));
			this.mes = Integer.parseInt(data.substring((firstindex + 1), secindex));
			this.ano = Integer.parseInt(data.substring((secindex + 1), (secindex + 5)));
		} else {
			throw new Exception("Data errada");
		}
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public void setData(int dia, int mes, int ano) throws Exception {

		if (Data.isDataValida(dia, mes, ano) == true) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		} else {
			throw new Exception("Data errada");
		}
	}

	/**Método para verificar se duas datas são iguais.
	* @author Arlon Scheidegger
	* @param  data Data - Data para a verificação.
	* @return boolean
	*/
	
	public boolean equals(Data data) {

		if ((this.getDia() == data.getDia()) && (this.getMes() == data.getMes()) && (this.getAno() == data.getAno())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**Método para incrementar 1 dia a uma data..
	* @author Arlon Scheidegger
	* @return void
	*/
	
	public void incrementa() {

		if ((dia > 0 && dia <= 31) && ((mes > 0) && (mes <= 12)) && (ano >= 1900)) {
			if ((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) {
				this.dia = this.dia + 1;
				if (this.dia > 31) {
					this.dia = 1;
					this.mes = this.mes + 1;
				}
				if (this.mes > 12) {
					this.mes = 1;
					this.ano = this.ano + 1;
				}
			} else if (((dia <= 29) && (mes == 2)) && Data.isBissexto(ano)) {
				this.dia = this.dia + 1;
				if (this.dia > 29) {
					this.dia = 1;
					this.mes = this.mes + 1;
				}
				if (this.mes > 12) {
					this.mes = 1;
					this.ano = this.ano + 1;
				}
			} else if ((dia <= 28) && (mes == 2)) {
				this.dia = this.dia + 1;
				if (this.dia > 28) {
					this.dia = 1;
					this.mes = this.mes + 1;
				}
				if (this.mes > 12) {
					this.mes = 1;
					this.ano = this.ano + 1;
				}
			} else if ((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11) || (mes == 1) || (mes == 3) || (mes == 5)
					|| (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) {
				this.dia = this.dia + 1;
				if (this.dia > 30) {
					this.dia = 1;
					this.mes = this.mes + 1;
				}
				if (this.mes > 12) {
					this.mes = 1;
					this.ano = this.ano + 1;
				}
			}
		}
	}

	/**Método para incrementar uma quantidade de dias desejado.
	* @author Arlon Scheidegger
	* @param  dia int - quantidade de dias para ser incrementado.
	* @return Data
	*/
	
	public Data incrementa(int dias) throws Exception {
		int i = 0;
		
			Data dataIncrementada = new Data(this.dia, this.mes, this.ano);
			for(i=0; i <= dias; i++){
				dataIncrementada.incrementa();
			}
			return dataIncrementada;
	}
	
	
	/**Método para verificar se uma data é válida e criar uma nova data se for válida.
	* @author Arlon Scheidegger
	* @param  dia int - dia para verificação e criação.
	* @param  mes int - mes para verificação e criação.
	* @param  ani int - ano para verificação e criação.
	* @return Data
	*/
	
	public static Data verificaECriaData (int dia, int mes, int ano) {
		try {
			Data novaData = new Data(dia, mes, ano);
			return novaData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	/**Método para verificar se a data é menor, igual ou maior que uma outra.
	* @author Arlon Scheidegger
	* @param  data Data - Data para fazer a comparação.
	* @return int
	*/
	
	public int compareTo(Data data) {
		if (this.getAno() > data.getAno()) {
			return -1;
		} else if (this.getAno() < data.getAno()) {
			return 1;
		} else {
			if (this.getMes() > data.getMes()) {
				return -1;
			} else if (this.getMes() < data.getMes()) {
				return 1;
			} else {
				if (this.getDia() > data.getDia()) {
					return -1;
				} else if (this.getDia() < data.getDia()) {
					return 1;
				} else
					return 0;
			}
		}
	}
	
	public String toString(){
		String concat = new StringBuilder().append(this.getDia()).append("/").append(this.getMes()).append("/").append(this.getAno()).toString();
    	return concat;
	}
}
