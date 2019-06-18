import java.util.Calendar;

public class Horario {
	
	int hora, min, sec;
	
	public Horario () {
		try {
			this.setHorario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public Horario (int hora) {
		try {
			this.setHorario(hora);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public Horario (int hora, int min) {
		try {
			this.setHorario(hora, min);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public Horario (int hora, int min, int sec) {
		try {
			this.setHorario(hora, min, sec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean  isHorarioValido (int hora, int min, int sec) {
			if(((hora >= 0) && (hora < 25) ) && ( (min >= 0) && (min < 60)) && ( (sec >= 0) && (sec < 60))) {
				return true;
			}
		return false;
	}
	
	public boolean isHorarioValido(Horario horario) {
		return Horario.isHorarioValido(horario.getHora(), horario.getMin(), horario.getSec());
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
	
	public boolean equals(Horario data) {

		if ((this.getHora() == data.getHora()) && (this.getMin() == data.getMin()) && (this.getSec() == data.getSec())) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString(){
		String concat = new StringBuilder().append(this.getHora()).append(":").append(this.getMin()).append(":").append(this.getSec()).toString();
    	return concat;
	}


}
