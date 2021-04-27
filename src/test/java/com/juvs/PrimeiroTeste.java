package com.juvs;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PrimeiroTeste {

    Calculadora calculadora;
    int num1 = 10, num2 = 5;

    @Before
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2numeros(){
        Assertions.assertThat(calculadora.somar(num1,num2)).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos(){
        calculadora.somar(-10, num2);
    }

    @Test
    public void deveSubtrair2numeros(){
        Assertions.assertThat(calculadora.subtrair(num1, num2)).isEqualTo(5);
    }

    @Test
    public void deveMultiplicar2Numeros(){
        Assertions.assertThat(calculadora.multiplicar(num1,num2)).isEqualTo(50);
    }

    @Test
    public void deveDividir2Numeros(){
        Assertions.assertThat(calculadora.dividir(num1,num2)).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveDividirPorZero(){
        calculadora.dividir(num1,0);
    }
}

class Calculadora {

    int somar(int num1, int num2){
        if(num1 < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido somar numeros negativos");
        }
        return num1 + num2;
    }

    int subtrair(int num1, int num2){
        return num1 - num2;
    }

    int multiplicar(int num1, int num2){
        return num1 * num2;
    }

    int dividir(int num1, int num2){
        if(num2 == 0){
            throw new RuntimeException("Não é permitido dividir por zero");
        }
        return num1 / num2;
    }

}
