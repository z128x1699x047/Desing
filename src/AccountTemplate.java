import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class AccountTemplate {

	/*public static void main(String[] args) {
		getResoult().thenAccept((e)->{
    		if(e){
    			band(otherBrank);	
    		}
	}*/
	public void band(Object otherBrank) {
		System.out.println("绑定other卡");
	}
	//protect abstrct  boolean checkAcount（）；
	public boolean checkAcount() {
		return true;
	}  

	/*public Future getResoult(){
		ExecutorService executor= Executors.newFixedThreadPool(1);//supplyAsync
		Supplier supplier;
		CompletableFuture.supplyAsync(supplier, executor);
	   CompletableFuture<Boolean> future2 = CompletableFuture.supplyAsync(()-> {
	                   checkAcount();
	               },executor);
	   return future2;
	}  */
	         
}
