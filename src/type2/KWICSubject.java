package type2;

public class KWICSubject extends Subject{
    public void startKWIC(){
        System.out.println("执行具体主题类");
        for (int i = 0; i <= 3; i++){
            super.notifyOneObserver(i);
        }
    }
}
