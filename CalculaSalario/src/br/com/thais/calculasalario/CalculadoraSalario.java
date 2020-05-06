package br.com.thais.calculasalario;

public class CalculadoraSalario {
	
	public static void main(String[] args) {
		final Double salarioBruto = 6750.0;
		CalculadoraSalario calculadoraSalario = new CalculadoraSalario();
		System.out.println("Salario Bruto : " + salarioBruto);
		
		final int salarioLiquido = calculadoraSalario.calcularDesconto(salarioBruto);
		System.out.println("Salario Liq : " + salarioLiquido);
		
	}
	
	private static final Double SALARIO_MINIMO = 1039.0;

	public int calcularDesconto (final Double salarioBruto) {
		
		if(salarioBruto <  SALARIO_MINIMO ) {
			System.out.println("Salário menor que o Mínimo R$ " + SALARIO_MINIMO);
			return 0;
		}
		
		final Double percInss = percentualDescontoINSS(salarioBruto);
		System.out.println("Perc Inss: " + percInss);
		
		Double descontoInss = CalcularDesconto(salarioBruto, percInss);
		Double salarioLiquido = salarioBruto - descontoInss;
		
		System.out.println("Desc Inss: " + descontoInss);
		
		final Double  percIrrf = percentualDescontoIRRF(salarioLiquido);
		System.out.println("Perc Irrf: " + percIrrf);
		
		if(percIrrf > 0 ) {
			Double descontoIrrf = CalcularDesconto(salarioLiquido, percIrrf);
			System.out.println("Desc Irrf: " + descontoIrrf);
			salarioLiquido -= descontoIrrf;
		}
		
		return (int) Math.round(salarioLiquido.doubleValue());
	}
	
	
	private Double CalcularDesconto(final Double salario, final Double percentual) {
		if(percentual > 0.0) {
			return (salario * percentual) / 100;
		}
		return 0.0;
	}
	
	private Double percentualDescontoINSS(final Double salarioBruto) {
		if(salarioBruto <= Double.valueOf(1500)) {
			return 8.0;
		
		} else if(salarioBruto > Double.valueOf(1500) && salarioBruto <= Double.valueOf(4000)) {
			    return 9.0;
		
		}else {
			    return 11.0;
		}
    }

    private Double percentualDescontoIRRF(final Double salarioBruto) {
		if(salarioBruto <= Double.valueOf(3000)) {
			return 0.0;

		} else if(salarioBruto > Double.valueOf(3000) && salarioBruto <= Double.valueOf(6000)) {
			return 7.5;
		
		} else {
			    return 15.0;
		}
	}
    
}
