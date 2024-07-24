package test.ingredienteTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


import Model.Ingrediente;

@DisplayName("Classe para testar ingredientes")
public class IngredienteTest{
    Ingrediente farinha;
    Ingrediente fermento;
    Ingrediente ovo;

    @BeforeEach
    public void inicializar(){ 
        farinha = new Ingrediente("Farinha", "Farinha para preparo de massas", 1, "Trigo");        
        fermento = new Ingrediente("Fermento", "Fermento para preparo de massas", 10, "Quimico", 1, 3.00, 4.50, 2);
    }

    @DisplayName("Teste para criar a classe")
    @Test   
    public void testCriaClasse(){
        farinha = new Ingrediente("Farinha", "Farinha para preparo de massas", 1, "Trigo");
        try{
            Assertions.assertAll("farinha",
                () -> assertEquals("Farinha", farinha.getNome()),
                () -> assertEquals("Farinha para preparo de massas", farinha.getDescricao()),
                () -> assertTrue(1 == farinha.getQuantidade()),
                () -> assertEquals("Trigo", farinha.getTipo())
        );
        }catch(NullPointerException e){
                System.out.println(e.getMessage());
            }	
    }

    @DisplayName("Teste para criar a classe")
    @Test
    public void testCriaClasseInteira(){
        fermento = new Ingrediente("Fermento", "Fermento para preparo de massas", 10, "Quimico", 1, 3.00, 4.50, 2);
        try{
            Assertions.assertAll("fermento",
                () -> assertEquals("Fermento", fermento.getNome()),
                () -> assertEquals("Fermento para preparo de massas", fermento.getDescricao()),
                () -> assertTrue(10 == fermento.getQuantidade()),
                () -> assertEquals("Quimico", fermento.getTipo()),
                () -> assertEquals(1, fermento.getId_ingrediente()),
                () -> assertTrue(3.00 == fermento.getValor_compra()),
                () -> assertTrue(4.50 == fermento.getValor_venda()),
                () -> assertTrue(2 == fermento.getFg_ativo())
             );    
            }catch(NullPointerException e){
                System.out.println(e.getMessage());
            }
       
    }


    @Test
    public void testValoresCompra(){

         try{
            Assertions.assertEquals(fermento.getValor_compra(), 3.0);
            Assertions.assertNull(farinha.getValor_compra());
         }catch(NullPointerException e){
                System.out.println(e.getMessage());
            }
    } 
    @Test
    public void testValoresVendas(){
         try{
            Assertions.assertEquals(fermento.getValor_venda(), 4.50);
            Assertions.assertNull(farinha.getValor_venda());
         }catch(NullPointerException e){
                System.out.println(e.getMessage());
            }
    } 
   
    @Test
    public void testValores(){
         try{
            fermento.setValor_venda(10.0);
            fermento.setValor_compra(40.0);            
            Assertions.assertEquals(fermento.getValor_compra(), 10.0);
            Assertions.assertEquals(fermento.getValor_venda(), 40.0);
         }catch(NullPointerException e){
                System.out.println(e.getMessage());
            }
    } 

    @BeforeEach
    @Test
    public void testComparaClasses(){
        farinha = new Ingrediente("Farinha", "Farinha para preparo de massas", 1, "Trigo");        
        fermento = new Ingrediente("Fermento", "Fermento para preparo de massas", 10, "Quimico", 1, 3.00, 4.50, 2);
        try{
            assertNotSame(fermento, farinha);
         }catch(ClassCastException e){
                System.out.println(e.getMessage());
            }
    }
    
    @Test
    public void testQuantidadeCompraEVenda(){
        fermento = new Ingrediente("Fermento", "Fermento para preparo de massas", 10, "Quimico", 1, 5.00, 5.50, 2);   
        try{
            assertTrue(fermento.quantidadeCompraValor());
         }catch(ClassCastException e){
                System.out.println(e.getMessage());
        }
    }
    @Test
    public void testQuantidadeTotal(){
        ovo = new Ingrediente("Ovo", "Ovo de galinha", 0, "Branco", 3, 4.00, 10.50, 3);   
        try{
            Assertions.assertFalse(ovo.checkQuantidade());
         }catch(ClassCastException e){
                System.out.println(e.getMessage());
        }
    }
}
