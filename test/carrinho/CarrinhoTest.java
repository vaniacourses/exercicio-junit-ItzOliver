package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("classe para teste do carrinho")
public class CarrinhoTest {
	
	private Carrinho carrinho;
	private Produto produto1;
	private Produto produto2;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		produto1 = new Produto("Sobre a Tranquilidade da Alma", 40);
		produto2 = new Produto("Sobre a Brevidade da Vida", 15);
	}
	
	@DisplayName("testa a adição de item ao carrinho")
	@Test
	public void testAddItem() {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		
		assertEquals(2, carrinho.getQtdeItems());
	}
	
	@DisplayName("testa a remoção de item do carrinho")
	@Test
	public void testRemoveItem() throws ProdutoNaoEncontradoException {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
				
		carrinho.removeItem(produto1);
		
		assertEquals(1, carrinho.getQtdeItems());
		assertThrows(ProdutoNaoEncontradoException.class, () ->{
			carrinho.removeItem(produto1);
		});
	}
	
	@DisplayName("testa o esvaziamento de itens do carrinho")
	@Test
	public void testEsvazia() {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		
		carrinho.esvazia();
		
		assertTrue(carrinho.getQtdeItems() == 0);
	}
}