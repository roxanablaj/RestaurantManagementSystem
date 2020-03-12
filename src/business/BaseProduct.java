package business;

public class BaseProduct extends MenuItem {
	private static final long serialVersionUID=1l;
	/*private int id;
	private String numeBP;
	private double pret;*/
	
	public BaseProduct(int id, String numeP, float pret) {
		super(id,numeP,pret);
	}
	/*public float getPret() {
		return pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}*/
	
	public float computePrice() {
		return super.getPret();
	}
	
	@Override
	public String[] toStringDate() {
		String[] a = new String[4];
		a[0] = String.valueOf(super.getId());
		a[1] = this.getNume();
		a[2] = Float.toString(super.getPret());
		a[3] = "-";
		
		return a;
	}
	
	public String[] toStringDateChef() {
		String[] a = new String[3];
		a[0] = String.valueOf(super.getId());
		a[1] = super.getNume();
		a[2] = String.valueOf(super.getPret());
		
	
		return a;
	}
}
