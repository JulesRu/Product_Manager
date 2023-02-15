public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {

        this.repo = repo;
    }

    public void add(Product item) {

        repo.save(item);
    }

    public Product[] searchBy(String text) {

        Product[] result = new Product[0];
        for (Product item : repo.findAll()) {
            if (item.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }
}

