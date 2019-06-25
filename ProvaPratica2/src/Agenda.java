import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**Classe onde contem uma LinkedList para guardar as informações de ItemAgenda, métodos de ordenação de lista e métodos de gravação e leitura de arquivos.
* @author Arlon Scheidegger
* @version 1.0
*/

public class Agenda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ItemAgenda> agenda = new LinkedList<ItemAgenda>();

	/**Método para inserção de uma meta na LinkedList.
	* @author Arlon Scheidegger
	* @param meta Meta - Objeto meta instanciado para inserção.
	* @return void
	*/
	
	public void inserirLista (Meta meta) {
		this.agenda.add(meta);
	}
	

	/**Método para inserção de um lembrete na LinkedList.
	* @author Arlon Scheidegger
	* @param lembrete Lembrete - Objeto lembrete instanciado para inserção.
	* @return void
	*/
	
	public void inserirLista (Lembrete lembrete) {
		this.agenda.add(lembrete);
	}
	

	/**Método para inserção de um evento na LinkedList.
	* @author Arlon Scheidegger
	* @param evento Evento - Objeto evento instanciado para inserção.
	* @return void
	*/
	
	public void inserirLista (Evento evento) {
		this.agenda.add(evento);
	}
	

	/**Método estático onde lê um arquivo com itens do tipo ItemAgenda e
	* apresenta apenas os itens que fazem parte de um determinado período.
	* @author Arlon Scheidegger
	* @param dataInicio Data - Objeto do tipo Data para mostrar o início do perído que deseja vizualizar.
	* @param dataFim Data - Objeto do tipo Data para mostrar o fim do perído que deseja vizualizar.
	* @return Agenda
	*/
	
	
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
	
	/**Método estático onde lê um arquivo com itens do tipo ItemAgenda e
	* ordena de acordo com a opção inserida pelo usuário sendo as ordenações
	* 3 - para ordenar as metas de acordo com o nível de prioridade de forma crescente e criar um arquivo com as metas ordenadas
	* 4 - para ordenar os lembretes de acordo com o tempo de aviso de forma crescente e criar um arquivo com os lembretes ordenados
	* 5 - para ordenar os eventos de acordo com o local do evento de forma alfabética e criar um arquivo com os eventos ordenadas
	* @author Arlon Scheidegger
	* @param nomeArquivo String - Entrada do nome do arquivo que vai ser lido para apresentação dos dados.
	* @param op int - Opção para escolha de qual tipo do ItemAgenda será ordenado.
	* @return Agenda
	*/
	
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
	
	/**Método estático para criar um arquivo com as informações de uma Agenda.
	* @author Arlon Scheidegger
	* @param agenda Agenda - Variavel do tipo agenda onde contem a lista de ItemAgenda para ser salvos no arquivo.
	* @param nomeArquivo String - Entrada do nome do arquivo que vai ser lido para apresentação dos dados.
	* @return void
	*/
	
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
	
	/**Método para abrir um arquivo que contem os itens da agenda e atulizar o mesmo
	* com novos itens. 
	* @author Arlon Scheidegger
	* @return void
	*/
	
	public void atualizarAgenda() {
		Agenda agendaArquivo = Agenda.leArquivo("Agenda");
		
		for(int i = 0; i < this.agenda.size(); i++) {
			agendaArquivo.agenda.add(this.agenda.get(i));
		}
		
		Agenda.salvarArquivo(agendaArquivo, "Agenda");
		
	}
	
	/**Método estático para ler um arquivo e retornar uma variavel tipo Agenda.
	* @author Arlon Scheidegger
	* @param nomeArquivo String - String com o nome do arquivo que deseja abrir.
	* @return Agenda
	*/
	
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
	
	/**Método para pegar o tamanho da LinkedList
	* @author Arlon Scheidegger
	* @return int
	*/
	
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
