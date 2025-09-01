package jokenpo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JokenpoTestGPT {

    private final Jokenpo jokenpo = new Jokenpo();

    // ------------------- TESTES DE EMPATE -------------------

    @Test
    @DisplayName("Empate: papel vs papel")
    void testEmpatePapel() {
        assertEquals(0, jokenpo.jogar(1, 1));
    }

    @Test
    @DisplayName("Empate: pedra vs pedra")
    void testEmpatePedra() {
        assertEquals(0, jokenpo.jogar(2, 2));
    }

    @Test
    @DisplayName("Empate: tesoura vs tesoura")
    void testEmpateTesoura() {
        assertEquals(0, jokenpo.jogar(3, 3));
    }

    // ------------------- TESTES DE VITÓRIA DO JOGADOR 1 -------------------

    @Test
    @DisplayName("Jogador 1 vence: papel vs pedra")
    void testJogador1VencePapelVsPedra() {
        assertEquals(1, jokenpo.jogar(1, 2));
    }

    @Test
    @DisplayName("Jogador 1 vence: pedra vs tesoura")
    void testJogador1VencePedraVsTesoura() {
        assertEquals(1, jokenpo.jogar(2, 3));
    }

    @Test
    @DisplayName("Jogador 1 vence: tesoura vs papel")
    void testJogador1VenceTesouraVsPapel() {
        assertEquals(1, jokenpo.jogar(3, 1));
    }

    // ------------------- TESTES DE VITÓRIA DO JOGADOR 2 -------------------

    @Test
    @DisplayName("Jogador 2 vence: pedra vs papel")
    void testJogador2VencePedraVsPapel() {
        assertEquals(2, jokenpo.jogar(2, 1));
    }

    @Test
    @DisplayName("Jogador 2 vence: tesoura vs pedra")
    void testJogador2VenceTesouraVsPedra() {
        assertEquals(2, jokenpo.jogar(3, 2));
    }

    @Test
    @DisplayName("Jogador 2 vence: papel vs tesoura")
    void testJogador2VencePapelVsTesoura() {
        assertEquals(2, jokenpo.jogar(1, 3));
    }

    // ------------------- TESTES DE ENTRADA INVÁLIDA -------------------

    @Test
    @DisplayName("Entrada inválida: jogador 1 = 0")
    void testEntradaInvalidaJogador1Zero() {
        assertEquals(-1, jokenpo.jogar(0, 2));
    }

    @Test
    @DisplayName("Entrada inválida: jogador 2 = 4")
    void testEntradaInvalidaJogador2Quatro() {
        assertEquals(-1, jokenpo.jogar(2, 4));
    }

    @Test
    @DisplayName("Entrada inválida: ambos jogadores com valores inválidos")
    void testEntradaInvalidaAmbos() {
        assertEquals(-1, jokenpo.jogar(-1, 5));
    }

    @Test
    @DisplayName("Entrada inválida: jogador 1 = 99, jogador 2 = 2")
    void testEntradaInvalidaJogador1Alto() {
        assertEquals(-1, jokenpo.jogar(99, 2));
    }

    @Test
    @DisplayName("Entrada inválida: jogador 2 = -2")
    void testEntradaInvalidaJogador2Negativo() {
        assertEquals(-1, jokenpo.jogar(3, -2));
    }
}
