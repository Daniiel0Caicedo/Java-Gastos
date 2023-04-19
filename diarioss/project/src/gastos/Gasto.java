package gastos;
import gastos.PrincipalJ;

public class Gasto {
	    private String Fecha;
		private int Monto;
		private String Descripcion;
		private Boolean categoriEntretenimiento;
		private Boolean categoriAlimentacion;
		private Boolean categoriTransporte;
		private Boolean categoriOtros;

public  Gasto (String Fecha, int Monto, String Descripcion, Boolean categoriEntretenimiento, Boolean categoriAlimentacion, Boolean categoriTransporte, Boolean categoriOtros) {
	this.Fecha = Fecha;
	this.Monto = Monto;
	this.Descripcion = Descripcion;
	this.categoriEntretenimiento = categoriEntretenimiento;
	this.categoriAlimentacion = categoriAlimentacion;
	this.categoriTransporte = categoriTransporte;
	this.categoriOtros = categoriOtros;
			
}
	
	


public Gasto() {
	
}
public String getFecha() {
	return Fecha;
}


public void setFecha(String Fecha) {
	this.Fecha = Fecha;
}

public int Monto() {
	return Monto;
}

public void setMonto(int Monto) {
	this.Monto = Monto;
}

public String Descripcion() {
	return Descripcion;
}

public void setDescripcion(String Descripcion) {
	this.Descripcion = Descripcion;
}

public boolean categoriEntretenimiento() {
	return categoriEntretenimiento;
}
public void setcategoriEntretenimiento(boolean categoriEntretenimiento) {
	this.categoriEntretenimiento = categoriEntretenimiento;
	
}
public boolean getcategoriAlimentacio() {
	return categoriAlimentacion;
}
public void setcategoriAlimentacion (boolean categoriAlimentacion) {
	this.categoriAlimentacion = categoriAlimentacion;
	
}

public boolean getcategoriaTransporte () {
	return categoriTransporte;
}

public void setcategoriTransporte (boolean categoriTransporte) {
	this.categoriTransporte = categoriTransporte;
}

public boolean getcategoriOtros () {
	return categoriOtros;
}
public void setcategoriOtros (boolean categoriOtros) {
	this.categoriOtros = categoriOtros;
}
		

	}


