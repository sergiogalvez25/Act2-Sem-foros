import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Puente{
    private int numcochesnorte;
    private int numcochessur;
    private Lock lock;
    private Condition CruzaNorte;
    private Condition CruzaSur;
    public Puente(){
        numcochesnorte=0;
        numcochessur=0;
        lock=new ReentrantLock();
        CruzaNorte= lock.newCondition();
        CruzaSur = lock.newCondition();
    }
    public void EntraNorte() throws InterruptedException{
        lock.lock();
        try{
            while(numcochessur>0){
                CruzaNorte.await();
            }
            numcochesnorte++;
            System.out.println("Cruzan los coches norte");
        }finally {
            lock.unlock();
        }
    }
    public void SalirNorte(){
        lock.lock();
        try{
            numcochesnorte--;
            if(numcochesnorte==0){
                CruzaSur.signal();
            }
        }finally{
            lock.unlock();
        }
    }
    public void EntraSur() throws InterruptedException{
        lock.lock();
        try{
            while(numcochesnorte>0){
                CruzaSur.await();
            }
            numcochessur++;
            System.out.println("Cruzan los coches del sur");
        } finally{
            lock.unlock();
        }
    }
    public void SalirSur(){
        lock.lock();
        try{
            numcochessur--;
            if(numcochessur==0){
                CruzaNorte.signal();
            }
        }finally{
            lock.unlock();
        }
    }
}