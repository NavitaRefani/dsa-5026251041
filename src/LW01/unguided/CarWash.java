public class CarWash extends WashService {
    public CarWash(String id, int days){
        super(id, days);
    }

    @Override 
    public int calculateCharge(){
        int days = getDays();
		int washCost;

        if (days <= 3){
            return (days * 35000) + 15000;
        } else{
			washCost = (3 * 35000) + ((days - 3) * 25000) + 15000;
		}

        return washCost;
    }

    @Override
	public String label() {
		return "Car";
	}
}
