import java.time.LocalDate;
import java.util.Date;

public class HistoryOfSales {
    private Auto auto;
    private LocalDate date;

    public HistoryOfSales() {
    }

    public HistoryOfSales(Auto auto, LocalDate date) {
        this.auto = auto;
        this.date = date;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HistoryOfSales{" +
                "auto=" + auto +
                ", date='" + date + '\'' +
                '}';
    }
}
