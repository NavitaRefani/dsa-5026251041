public class ColourPrint extends PrintJob {

	public ColourPrint(String id, int pages) {
		super(id, pages);
	}

    @Override 
	public int calculateCharge() {
		int pages = getPages();
		int printingCost;

        if (pages <= 10){
            return (pages * 1500) + 2000;
        } else{
			printingCost = (10 * 1500) + ((pages - 10) * 1000) + 2000;
		}

        return printingCost;
	}

    @Override 
	public String label() {
		return "Colour";
	}

}