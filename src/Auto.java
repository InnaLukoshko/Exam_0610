import java.util.Objects;

public class Auto {
    private Marks mark;
    private double price;
    private int count;

    public Auto(Marks mark, double price, int count) {
        this.mark = mark;
        this.price = price;
        this.count = count;
    }

    public Marks getMark() {
        return mark;
    }

    public void setMark(Marks mark) {
        this.mark = mark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Double.compare(auto.price, price) == 0 && count == auto.count && mark == auto.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, price, count);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "mark=" + mark +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
