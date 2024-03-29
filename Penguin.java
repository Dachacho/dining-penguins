package fop.w11dining;

public class Penguin implements Runnable {
	
	private String name;
	private Table table;

	public Penguin(String name, Table table) {
		this.name =  name;
		this.table = table;
	}

	public void eat() {

		for(int i = 1; i <= 2; i++) {

			while(!((i == 1 && table.numberOfForks() >= 2) || (i == 2 && table.numberOfForks() >= 1))) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
		            System.out.println("Something went wrong. Interrupted!");
		            return;
		        }
	    	}

	    	table.takeFork();
	    	System.out.println(name + " takes fork #" + i);

	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
		        System.out.println("Something went wrong. Interrupted!");
		        return;
		    }
		    
    	}

    	System.out.println(name + " ate.");

		table.returnFork();
		table.returnFork();
	}

	@Override
	public void run() {
		eat();
	}

}