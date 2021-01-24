package thb.siprojektanamneseservice.transfert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordTO {

    @NotNull(message = "The password must not be null!")
    private String password;
    @NotNull(message = "The answer must not be null!")
    private String answer;

}
