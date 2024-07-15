public class Coche implements Runnable{
    private String direccion;
    private Puente puente;
    public Coche(String dir,Puente p){
        this.direccion=dir;
        this.puente=p;
    }
    public void run(){
        try{
            if(direccion.equals("norte")){
                puente.EntraNorte();
                Thread.sleep(1000);
                puente.SalirNorte();
            }else if(direccion.equals("sur")){
                puente.EntraSur();
                Thread.sleep(1000);
                puente.SalirSur();
            }
        }catch(InterruptedException e){
            e.printStackTrace();}
        
    }
}
