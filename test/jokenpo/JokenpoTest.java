package jokenpo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste do Jokenpo")
public class JokenpoTest {
	private Jokenpo jokenpo;
	
	/**
     * Esse método calcula o vencedor do jogo Jokenpo (pedra, papel e tesoura)
     * As escolhas podem ser 1 (papel), 2 (pedra) e 3 (tesoura)
     * 
     * @param jogador1
     *                 Escolha do jogador 1
     * @param jogador2
     *                 Escolha do jogador 2
     * @return 0 se houve empate, 1 se jogador 1 venceu, 2 se jogador 2 venceu,
     *         -1 se opção é inválida
     */
	
	@BeforeEach
	public void inicializa() {
		jokenpo = new Jokenpo();
	}
	
	@DisplayName("Testa se jogador 1 joga papel e ganha de pedra")
	@Test
	public void testPapelJogador1Ganhou() {
		int jogar = jokenpo.jogar(1, 2);
		Assertions.assertEquals(1, jogar);
		
	}
	
	@DisplayName("Testa se jogador 1 joga pedra e ganha de tesoura")
	@Test
	public void testPedraJogtador1Ganhou() {
		int jogar = jokenpo.jogar(2, 3);
		Assertions.assertEquals(1, jogar);
		
	}
	
	@DisplayName("Testa se jogador 1 joga tesoura e ganha de papel")
	@Test
	public void testTesouraJogador1Ganhou() {
		int jogar = jokenpo.jogar(3, 1);
		Assertions.assertEquals(1, jogar);
		
	}
	
	@DisplayName("Testa se jogador 2 joga papel e ganha de pedra")
	@Test
	public void testPapelJogador2Ganhou() {
		int jogar = jokenpo.jogar(2, 1);
		Assertions.assertEquals(2, jogar);
		
	}
	
	@DisplayName("Testa se jogador 2 joga pedra e ganha de tesoura")
	@Test
	public void testPedraJogtador2Ganhou() {
		int jogar = jokenpo.jogar(3, 2);
		Assertions.assertEquals(2, jogar);
		
	}
	
	@DisplayName("Testa se jogador 2 joga tesoura e ganha de papel")
	@Test
	public void testTesouraJogador2Ganhou() {
		int jogar = jokenpo.jogar(1, 3);
		Assertions.assertEquals(2, jogar);
		
	}
	
	@DisplayName("Testa empate")
	@Test
	public void testEmpate() {
		int jogar = jokenpo.jogar(1, 1);
		Assertions.assertEquals(0, jogar);
	}
}