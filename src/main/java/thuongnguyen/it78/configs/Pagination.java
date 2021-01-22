package thuongnguyen.it78.configs;

import java.util.ArrayList;

public class Pagination {
    private int total;
    private ArrayList listShoes;

    public Pagination(int total, ArrayList listShoes) {
        this.listShoes = new ArrayList();
        this.total = total;
        this.listShoes = listShoes;
    }
}
