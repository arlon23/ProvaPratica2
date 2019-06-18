
public class Uso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Horario horario = new Horario(12, 12, 30);
		
		Periodo periodo = new Periodo();
		
		Meta meta = new Meta("Teste", "Vamos testar se funcionou o git", periodo, 3);
		
		Lembrete lembrete = new Lembrete("Teste", "Vamos testar se funcionou o git", periodo,15);
		
		System.out.println(lembrete);

	}

}
