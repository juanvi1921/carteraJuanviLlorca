import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
    /**TEST AL CREAR CUENTA.*/
    public class CarteraTest {
        @Test
        void testAlCrearCuentaElSaldoEsCero() {
           Cuenta c = new Cuenta();
           assertEquals(0,c.getSaldo());
        }

    /**TEST DE INGRESOS.*/
    @Test
    void testAlIngresar100EnCuentaVaciaElSaldoEs100() {
        Cuenta c = new Cuenta();
        c.ingresar(100);
        assertEquals(100,c.getSaldo());
    }
    @Test
    void testAlIngresar3000EnCuentaVaciaElSaldoEs3000() {
        Cuenta c = new Cuenta();
        c.ingresar(3000);
        assertEquals(3000, c.getSaldo());
    }
    @Test
    void testAlIngresar100EnCuentaCon3000ElSaldoEs3100() {
        Cuenta c = new Cuenta();
        c.ingresar(100);
        c.ingresar(3000);
        assertEquals(3100,c.getSaldo());
    }
    @Test
    void testAlIngresarNegativoElSaldoEs0() {
        Cuenta c = new Cuenta();
        c.ingresar(-100);
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testCantidadesDosDecimalesMax() {
        Cuenta c = new Cuenta();
        c.ingresar(100.454);
        assertEquals(100.45, c.getSaldo());
    }

    @Test
    void testCantidadMaxDeIngreso() {
        Cuenta c = new Cuenta();
        c.ingresar(6000.01);
        assertEquals(0, c.getSaldo());
    }

    /**TEST DE RETIRADAS.*/

    @Test
    void testAlRerirar100() {
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(100);
        assertEquals(400, c.getSaldo());
    }

    @Test
    void testAlRetirarMayorCantidadQueElSaldo() {
        Cuenta c = new Cuenta();
        c.ingresar(200);
        c.retirar(500);
        assertEquals(200, c.getSaldo());
    }

    @Test
    void testAlRetirarNumNegativo() {
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(-100);
        assertEquals(500, c.getSaldo());
    }

    @Test
    void testCantidadDecimalesPermitidos() {
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(100.45);
        assertEquals(399.55, c.getSaldo());
    }

    @Test
    void testCantidadMaxRetirar() {
        Cuenta c = new Cuenta();
        c.ingresar(5000);
        c.ingresar(2000);
        assertEquals(7000, c.getSaldo());
        c.retirar(6000.01);
        assertEquals(7000,c.getSaldo());
    }

    /**TEST DE TRANSFERENCIAS:*/

    @Test
    void testAlTransferir() {
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(500);
        c2.ingresar(50);
        c1.transferir(c2, 100);
        assertEquals(400, c1.getSaldo());
        assertEquals(150, c2.getSaldo());
    }

    @Test
    void testTransferenciasNegativas() {
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(500);
        c2.ingresar(50);
        c1.transferir(c2, -100);
        assertEquals(500, c1.getSaldo());
        assertEquals(50, c2.getSaldo());
    }

    @Test
    void testLimiteTransferencia3000() {
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.ingresar(3500);
        c2.ingresar(50);
        c1.transferir(c2, 3000.01);
        assertEquals(3500, c1.getSaldo());
        assertEquals(50, c2.getSaldo());
    }
}
