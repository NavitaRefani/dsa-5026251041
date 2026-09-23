public  abstract class WashService {
    private String id;
    private int days;

    protected WashService(String id, int days){
        if (id == null){
            throw new IllegalArgumentException("ID cannot be empty");
        }

        if (days <= 0 || days > 30){
            throw new IllegalArgumentException("Days must be between 1-30");
        }

        this.id = id;
        this.days = days;
	}
    
    public String getId() {
		return this.id;
	}

	public int getDays() {
		return this.days;
	}

    @Override 
    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if (units <= 0 || units > 10) {
            throw new IllegalArgumentException("Units must be beetween 1-10");
        }

        return units * calculateCharge();
    }

    public String label() {
        return "Service";
    }

    public String summary() {
        return id + "|" + label() + "|" + calculateCharge();
    }
}
