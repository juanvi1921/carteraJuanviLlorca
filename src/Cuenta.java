public class Cuenta {
    private double saldo;
    public Cuenta() {
        saldo = 0;
    }


    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) {
        if(cantidad <= 0 || cantidad > 6000) {
            saldo = 0;
        } else {
            saldo += Math.round(cantidad * 100.0)/100.0;
        }
    }

    public void retirar(double cantidad) {
        if(cantidad < saldo && cantidad > 0 && cantidad < 6000) {
            saldo -= Math.round(cantidad * 100.0)/100.0;
        }
    }

    public void transferir(Cuenta c2, double cantidad) {
        if(cantidad > 0 && cantidad <= 3000) {
            retirar(cantidad);
            c2.ingresar(cantidad);
        }
    }
}
