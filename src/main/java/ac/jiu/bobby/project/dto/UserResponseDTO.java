//package ac.jiu.bobby.project.dto;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDate;
//import java.util.UUID;
//
//@Getter
//@Setter
//public class UserResponseDto {
//
//    private UUID id;
//    private String firstName;
//    private String lastName;
//    private LocalDate dob;
//    private String gender;
//    private String address;
//    private String photo;
//    private String roleName;
//}


package ac.jiu.bobby.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
