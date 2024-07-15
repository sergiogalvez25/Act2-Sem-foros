public class GestionPuente {
    public static void main(String[] args){
        Puente puente = new Puente();
        Thread coche1 = new Thread(new Coche("norte",puente));
        Thread coche2 = new Thread(new Coche("norte",puente));
        Thread coche3 = new Thread(new Coche("sur",puente));
        Thread coche4 = new Thread(new Coche("sur",puente));

        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();

    }
}
