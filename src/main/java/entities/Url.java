package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Url {

  private static Long sequence = 1L;

  private Long id;

  private String value;

  private Date createdAt;

  public Url(String value) {
    this.id = sequence++;
    this.value = value;
    this.createdAt = new Date();
  }
}
