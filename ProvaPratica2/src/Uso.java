import java.util.Scanner;

import javax.swing.JOptionPane;

/**Classe uso para inserção dos dados para instanciar todas as informações.
* @author Arlon Felipe Scheidegger de Aguiar
* @version 1.0
*/
public class Uso {
	private static Scanner entrada;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  op1=0, op2=0;
		String titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim;
		Data dataIn, dataF;
		Horario horarioIn, horarioF;
		Periodo periodo;
		Agenda agenda = new Agenda();
//		String info;
		
		do {
			do {
				System.out.println("|;;;;;;;; Agenda ;;;;;;;;|");
				System.out.println("| 1 - Criar Lembrete     |");
				System.out.println("| 2 - Criar Meta         |");
				System.out.println("| 3 - Criar Evento       |");
				System.out.println("| 4 - Vizualizar         |");
				System.out.println("| 5 - Sair               |");
				
				entrada = new Scanner(System.in);
				op1 = entrada.nextInt();
				
				if(op1 != 4) {
					System.out.print("Titulo: ");
					entrada = new Scanner(System.in);
					titulo = entrada.nextLine();
					System.out.print("Descrição: ");
					entrada = new Scanner(System.in);
					descricao = entrada.nextLine();
					System.out.print("Data de Inicio: ");
					entrada = new Scanner(System.in);
					dataInicio = entrada.nextLine();
					System.out.print("Horario Inicio: ");
					entrada = new Scanner(System.in);
					horarioInicio = entrada.nextLine();
					System.out.print("Data Fim: ");
					entrada = new Scanner(System.in);
					dataFim = entrada.nextLine();
					System.out.print("Horario Fim: ");
					entrada = new Scanner(System.in);
					horarioFim = entrada.nextLine();
					
					switch(op1) {
						case 1:
							System.out.print("Minutos de Antecedência: ");
							entrada = new Scanner(System.in);
							int minutos = entrada.nextInt();
							
							try {
								dataIn = new Data(dataInicio);
								dataF = new Data(dataFim);
	
								horarioIn = new Horario(horarioInicio);
								horarioF = new Horario(horarioFim);
								periodo = new Periodo(dataIn, horarioIn, dataF, horarioF);
								Lembrete lembrete = new Lembrete(titulo, descricao, periodo, minutos);
								agenda.inserirLista(lembrete);
								
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							break;
						case 2:
							
							System.out.print("Nível de Prioridade: ");
							entrada = new Scanner(System.in);
							int nivelPrioridade = entrada.nextInt();
							
							try {
								dataIn = new Data(dataInicio);
								dataF = new Data(dataFim);
	
								horarioIn = new Horario(horarioInicio);
								horarioF = new Horario(horarioFim);
								periodo = new Periodo(dataIn, horarioIn, dataF, horarioF);
								Meta meta = new Meta(titulo, descricao, periodo, nivelPrioridade);
								agenda.inserirLista(meta);
								
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							break;
						case 3:
							System.out.print("Local Evento: ");
							entrada = new Scanner(System.in);
							String local = entrada.nextLine();
							
							try {
								dataIn = new Data(dataInicio);
								dataF = new Data(dataFim);
	
								horarioIn = new Horario(horarioInicio);
								horarioF = new Horario(horarioFim);
								periodo = new Periodo(dataIn, horarioIn, dataF, horarioF);
								Evento evento = new Evento(titulo, descricao, periodo, local);
								agenda.inserirLista(evento);
								
								
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						
						default:
							break;
					}
				}else {
					/**Verificação para ver se é necessário criar ou não um arquivo, e se for para criar
					 * verifica se é para atualizar.
					* @author Arlon Scheidegger
					*/
					if(agenda.getSize() > 0 && Agenda.leArquivo("Agenda") != null) {
						agenda.atualizarAgenda();
					}else if (agenda.getSize() > 0 && Agenda.leArquivo("Agenda") == null) {
						Agenda.salvarArquivo(agenda, "Agenda");
					}else break;
					
					
						System.out.println("|;;;;;;;; Vizualização ;;;;;;;;|");
						System.out.println("| 1 - Toda a agenda            |");
						System.out.println("| 2 - Agenda por intervalo     |");
						System.out.println("| 3 - Metas ordenadas          |");
						System.out.println("| 4 - Lembretes ordenados      |");
						System.out.println("| 5 - Eventos ordenados        |");
						System.out.println("| 6 - Sair                     |");
						
						op2 = entrada.nextInt();
						
						switch(op2) {
							case 1:
								System.out.println(agenda.toString());
								break;
							case 2:
								System.out.print("Intervalo de Inicio: ");
								entrada = new Scanner(System.in);
								dataInicio = entrada.nextLine();
								System.out.print("Intervalo de Fim: ");
								entrada = new Scanner(System.in);
								dataFim = entrada.nextLine();
								
							
							try {
								Data intervaloIn = new Data(dataInicio);							
								Data intervaloF = new Data(dataFim);
								
								System.out.println(Agenda.listarPorPeriodo(intervaloIn, intervaloF));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								
								
								
								break;
							case 3:
								System.out.println(Agenda.ordenar("Agenda", op2));
								break;
							case 4:
								System.out.println(Agenda.ordenar("Agenda", op2));
								break;
							case 5:
								System.out.println(Agenda.ordenar("Agenda", op2));
								break;
							default:
								break;
						}
//					}else {
//						JOptionPane.showMessageDialog(null, "Arquivo Agenda Vazio");
//					}
					
				}
				
			}while(op2 != 6);
		}while(op1 != 5);

		

		
		
		
		
		
		

	}

}
