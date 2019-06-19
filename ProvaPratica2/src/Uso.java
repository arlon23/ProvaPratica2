
public class Uso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Horario horario = new Horario(15, 00, 00), horarioFim = new Horario(16,00,00);
		Data data = new Data();
		Periodo periodo = new Periodo(data, horario, data, horarioFim);
		
		Meta meta = new Meta("Teste", "Vamos testar se funcionou o git", periodo, 3);
		
		Lembrete lembrete = new Lembrete("Teste", "Vamos testar se funcionou o git", periodo,50);
		
		System.out.println(lembrete.aviso());

	}

}
