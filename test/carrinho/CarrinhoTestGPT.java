package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTestGPT {

    private Carrinho carrinho;

    // Mock simples de Produto
    private static class ProdutoMock implements Produto {
        private final String nome;
        private final double preco;

        ProdutoMock(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        @Override
        public double getPreco() {
            return preco;
        }

        @Override
        public String getNome() {
            return nome;
        }

        // equals e hashCode necessários para remoção funcionar corretamente
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ProdutoMock)) return false;
            ProdutoMock that = (ProdutoMock) o;
            return nome.equals(that.nome);
        }

        @Override
        public int hashCode() {
            return nome.hashCode();
        }
    }

    // Mock da exceção
    static class ProdutoNaoEncontradoException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
    }

    @Test
    @DisplayName("Carrinho vazio deve ter valor total igual a 0")
    void testValorTotalCarrinhoVazio() {
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Adicionar item ao carrinho aumenta a quantidade")
    void testAddItem() {
        Produto produto = new ProdutoMock("Caneta", 2.50);
        carrinho.addItem(produto);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Valor total do carrinho deve somar os preços dos produtos")
    void testValorTotalComProdutos() {
        carrinho.addItem(new ProdutoMock("Caderno", 10.00));
        carrinho.addItem(new ProdutoMock("Lápis", 1.50));
        carrinho.addItem(new ProdutoMock("Borracha", 0.99));

        assertEquals(12.49, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Remover item existente deve funcionar sem exceção")
    void testRemoveItemComSucesso() throws ProdutoNaoEncontradoException {
        Produto produto = new ProdutoMock("Livro", 30.00);
        carrinho.addItem(produto);

        carrinho.removeItem(produto);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Remover item inexistente deve lançar exceção")
    void testRemoveItemNaoEncontrado() {
        Produto produto = new ProdutoMock("Tablet", 200.00);

        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produto));
    }

    @Test
    @DisplayName("Esvaziar carrinho deve remover todos os itens")
    void testEsvaziarCarrinho() {
        carrinho.addItem(new ProdutoMock("Item 1", 5.00));
        carrinho.addItem(new ProdutoMock("Item 2", 10.00));

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Carrinho deve contar corretamente a quantidade de itens")
    void testQuantidadeDeItens() {
        carrinho.addItem(new ProdutoMock("Produto A", 1.00));
        carrinho.addItem(new ProdutoMock("Produto B", 2.00));
        carrinho.addItem(new ProdutoMock("Produto C", 3.00));

        assertEquals(3, carrinho.getQtdeItems());
    }
}
