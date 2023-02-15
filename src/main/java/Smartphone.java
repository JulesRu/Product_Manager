public class Smartphone extends Product{

    private String madeIn;

    public Smartphone(int id, String name, int price, String madeIn) {
        super(id, name, price);
        this.madeIn = madeIn;
    }

    public String getMadeIn() {
        return madeIn;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getMadeIn().contains(search);
        }
    }
}
