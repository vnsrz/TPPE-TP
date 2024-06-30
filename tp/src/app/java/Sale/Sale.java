package Sale;

import java.time.Instant;
import java.util.Date;

public class Sale {
    private Date date;

    public Sale(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return Date.from(Instant.parse("2019-12-03T10:15:30.00Z"));
    }
}
