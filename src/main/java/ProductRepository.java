public class ProductRepository {

    private Product[] items = new Product[0];


    public Product findById(int id) {
        Product tmp = new Product(0, "", 0);
        for (Product item : items) {
            if (item.getId() == id) {
                tmp = item;
                return item;
            }
        }
        return null;
    }

    public void save(Product item) {
        if (findById(item.id) != null) {
            throw new AlreadyExistsException(
                    "Элемент с id " + item.id + " уже есть в Вашей корзине"
            );
        }
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }

        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] findAll() {

        return items;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Элемент с ID " + id + " не найден."
            );
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

}

