package test.clienteTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


import Model.Cliente;
import Model.Endereco;
import Model.Funcionario;

@DisplayName("Classe para testar Clientes")
public class clienteTest {
    Cliente Carlos;
    Cliente Pedro;
    Cliente Vinicius;
    Cliente Mateus;
    Endereco End1;
    Funcionario FunVini;


    @BeforeEach
    public void inicializar(){
        Carlos = new Cliente(1, "Carlos", "Silva", "21999999999", "CarlosSilva01", End1);
        Pedro = new Cliente(2, "Pedro", "Moraes", "21999999998", "PedroMoraes01", End1);
        Vinicius = new Cliente(3, "Vinicius", "Souza", "21999999997", "ViniciusSouza01", End1);
        Mateus = new Cliente(4, "Mateus", "Barros", "21999999996", "MateusBarros01", End1);
        End1 = new Endereco(1, "Rua dos Andes", "BomLugar", 348, "Casa", "Rio de Janeiro", "RJ");
        FunVini = new Funcionario(1, "Vinicius", "Souza", "ViniciusSouza01", null, null, 0, 0);

    }

    @DisplayName("Teste para criar a classe")
    @Test
    public void testCriaClasse(){
        Carlos = new Cliente(1, "Carlos", "Silva", "21999999999", "CarlosSilva01", End1);
        try{
            Assertions.assertAll("carlos", 
            () -> assertEquals("Carlos", Carlos.getNome()),
            () -> assertEquals("Silva", Carlos.getSobrenome()),
            () -> assertEquals("21999999999", Carlos.getTelefone()),
            () -> assertEquals("CarlosSilva01", Carlos.getUsuario())
            );
        }catch(NullPointerException e){
                System.out.println(e.getMessage());
        }
    }

    @Test
    public void testUsuaruioDiferente(){
        Pedro = new Cliente(2, "Pedro", "Moraes", "21999999998", "PedroMoraes01", End1);
        Vinicius = new Cliente(3, "Vinicius", "Souza", "21999999997", "ViniciusSouza01", End1);
        try{
            Assertions.assertAll("pedro",
            () -> assertNotEquals(Pedro.getUsuario(), Vinicius.getUsuario())
            );
        }catch(NullPointerException e){
                System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEnderecoNaoNulo(){
        End1 = new Endereco(1, "Rua dos Andes", "BomLugar", 348, "Casa", "Rio de Janeiro", "RJ");
        Mateus = new Cliente(4, "Mateus", "Barros", "21999999996", "MateusBarros01", End1);
        try{
            Assertions.assertNotNull(Mateus.getEndereco());
        }catch(NullPointerException e){
                System.out.println(e.getMessage());
        }
    }

    @Test
    public void testTelefoneValido(){
        Pedro = new Cliente(2, "Pedro", "Moraes", "21999999999", "PedroMoraes01", End1);
        int tamTele = Pedro.getTelefone().length();
        try{
            Assertions.assertTrue(tamTele == 11);
        }catch(NullPointerException e){
                System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFuncionarioCliente(){
        Vinicius = new Cliente(3, "Vinicius", "Souza", "21999999997", "ViniciusSouza01", End1);
        FunVini = new Funcionario(1, "Vinicius", "Souza", "ViniciusSouza01", null, null, 0, 0);
        try{
            Assertions.assertSame(Vinicius.getUsuario(), FunVini.getUsuario());
        }catch(NullPointerException e){
                System.out.println(e.getMessage());
        }
    }

}
