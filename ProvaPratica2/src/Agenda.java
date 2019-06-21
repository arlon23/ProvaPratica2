import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Agenda implements Serializable {
	
	private ItemAgenda novaInfo;

	public Agenda (ItemAgenda itemAgenda) {
		this.novaInfo = itemAgenda;
	}
	
	@Override
	public String toString() {
		String contat = "Titulo: " + novaInfo.getTitulo() + "\nDescrição: " + novaInfo.getDescricao() +
				"\nData Inicio: " + novaInfo.getPeriodo().dataInicio;
		return contat;
	}
	
}
