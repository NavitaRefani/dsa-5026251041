public abstract class PrintJob implements Chargeable {

	private String id;
	private int pages;

	public PrintJob(String id, int pages) {
		if (id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be empty");
        }

        if (pages <= 0 || pages > 100){
            throw new IllegalArgumentException("Pages must be between 1-100");
        }

        this.id = id;
        this.pages = pages;
	}

	public String getId() {
		return this.id;
	}

	public int getPages() {
		return this.pages;
	}

    @Override 
	public abstract int calculateCharge();
    
	public int calculateCharge(int copies) {
        if (copies <= 0 || copies > 10){
            throw new IllegalArgumentException("Copies must be beetween 1-10");

        }

        return copies * calculateCharge();
	}

	public String label() {
        return "Print";
    };

	public String summary() {
		return id + "|" + label() + "|" + calculateCharge();
	}

}