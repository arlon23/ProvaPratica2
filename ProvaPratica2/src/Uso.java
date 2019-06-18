
public class Uso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Horario horario = new Horario(12, 12, 30);
		
		Periodo periodo = new Periodo();
		
		Meta meta = new Meta("Teste", "Vamos testar uma descição nessa bagaça", periodo, 3);
		
		System.out.println(meta);

	}

}
