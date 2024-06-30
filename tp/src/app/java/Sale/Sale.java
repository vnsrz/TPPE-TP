package Sale;

import java.time.Instant;
import java.util.Date;

public class Sale {
    private Date date;

    public Sale(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }
}
