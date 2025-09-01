package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTestGPT {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // ---------- Testes do método soma ----------
    @Test
    @DisplayName("Teste de soma com dois valores positivos")
    void testSomaPositivos() {
        assertEquals(10, calculadora.soma(4, 6));
    }

    @Test
    @DisplayName("Teste de soma com valores negativos")
    void testSomaNegativos() {
        assertEquals(-5, calculadora.soma(-2, -3));
    }

    @Test
    @DisplayName("Teste de soma com zero")
    void testSomaComZero() {
        assertEquals(7, calculadora.soma(7, 0));
    }

    // ---------- Testes do método subtracao ----------
    @Test
    @DisplayName("Teste de subtração com dois valores positivos")
    void testSubtracaoPositivos() {
        assertEquals(3, calculadora.subtracao(8, 5));
    }

    @Test
    @DisplayName("Teste de subtração com resultado negativo")
    void testSubtracaoResultadoNegativo() {
        assertEquals(-4, calculadora.subtracao(3, 7));
    }

    // ---------- Testes do método multiplicacao ----------
    @Test
    @DisplayName("Teste de multiplicação com dois valores positivos")
    void testMultiplicacaoPositivos() {
        assertEquals(20, calculadora.multiplicacao(4, 5));
    }

    @Test
    @DisplayName("Teste de multiplicação com zero")
    void testMultiplicacaoComZero() {
        assertEquals(0, calculadora.multiplicacao(10, 0));
    }

    @Test
    @DisplayName("Teste de multiplicação com valor negativo")
    void testMultiplicacaoComNegativo() {
        assertEquals(-12, calculadora.multiplicacao(-3, 4));
    }

    // ---------- Testes do método divisao ----------
    @Test
    @DisplayName("Teste de divisão com dois valores positivos")
    void testDivisaoPositivos() {
        assertEquals(2, calculadora.divisao(10, 5));
    }

    @Test
    @DisplayName("Teste de divisão com valor negativo")
    void testDivisaoComNegativo() {
        assertEquals(-3, calculadora.divisao(-9, 3));
    }

    @Test
    @DisplayName("Teste de divisão por zero")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(5, 0));
    }

    // ---------- Testes do método somatoria ----------
    @Test
    @DisplayName("Teste de somatória de número positivo")
    void testSomatoriaPositivo() {
        assertEquals(15, calculadora.somatoria(5)); // 0+1+2+3+4+5 = 15
    }

    @Test
    @DisplayName("Teste de somatória de zero")
    void testSomatoriaZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    @DisplayName("Teste de somatória com número negativo")
    void testSomatoriaNegativo() {
        assertEquals(0, calculadora.somatoria(-5)); // Deve retornar 0
    }

    // ---------- Testes do método ehPositivo ----------
    @Test
    @DisplayName("Teste se número positivo é identificado corretamente")
    void testEhPositivoComPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("Teste se zero é considerado positivo")
    void testEhPositivoComZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    @DisplayName("Teste se número negativo é identificado corretamente")
    void testEhPositivoComNegativo() {
        assertFalse(calculadora.ehPositivo(-1));
    }

    // ---------- Testes do método compara ----------
    @Test
    @DisplayName("Teste de comparação: a == b")
    void testComparaIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    @DisplayName("Teste de comparação: a > b")
    void testComparaMaior() {
        assertEquals(1, calculadora.compara(10, 4));
    }

    @Test
    @DisplayName("Teste de comparação: a < b")
    void testComparaMenor() {
        assertEquals(-1, calculadora.compara(3, 8));
    }
}