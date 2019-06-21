import javax.swing.JOptionPane;
import java.util.Scanner;

public class Uso {
	private static Scanner entrada;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemAgenda item[] = new ItemAgenda[10];
		int  op1=0, op2=0;
		String titulo, descricao, dataInicio, dataFim, horarioInicio, horarioFim;
		Data dataIn, dataF;
		Horario horarioIn, horarioF;
		Periodo periodo;
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
							String[] horaI = horarioInicio.split(":");
							String[] horaF = horarioFim.split(":");
							int horaIn[] = new int[3];
							int horaFim[] = new int[3];
							for (int i = 0; i<horaI.length; i++) {
								horaIn[i] = Integer.parseInt(horaI[i]);
								horaFim[i] = Integer.parseInt(horaF[i]);
							}
							horarioIn = new Horario(horaIn[0], horaIn[1], horaIn[2]);
							horarioF = new Horario(horaIn[0], horaIn[1], horaIn[2]);
							periodo = new Periodo(dataIn, horarioIn, dataF, horarioF);
							Lembrete lembrete = new Lembrete(titulo, descricao, periodo, minutos);
							System.out.println(lembrete);
							
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Lembrete lembrete = new Lembrete();
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
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
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
								break;
							default:
								break;
						}
						
						break;
					default:
						break;
				}
				
			}while(op2 != 10);
		}while(op1 != 10);

		

		
		
		
		
		
		

	}

}
