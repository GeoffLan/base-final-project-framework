//package ac.jiu.bobby.project.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.hibernate.annotations.Where;
//
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.UUID;
//
//@Entity
//@Table(name = "users")
//@Getter
//@Setter
//@Where(clause = "is_deleted = false")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    @Column(length = 50)
//    private String firstName;
//
//    @Column(length = 50)
//    private String lastName;
//
//    @Column
//    private LocalDate dob;
//
//    @Column(length = 1)
//    private String gender;
//
//    @Column(length = 500)
//    private String address;
//
//    @Column(length = 255)
//    private String photo;
//
//    // ✅ AUTENTIKASI
//    @Column(unique = true, nullable = false, length = 100)
//    private String username;
//
//    @Column(nullable = false, length = 255)
//    private String password;
//
//    @CreationTimestamp
//    private Date createdDate;
//
//    @UpdateTimestamp
//    private Date updatedDate;
//
//    @Column
//    private String createdBy;
//
//    @Column
//    private String updatedBy;
//
//    @Column(nullable = false)
//    private boolean isDeleted = false;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id") // foreign key di tabel users
//    private Role role;
//}

package ac.jiu.bobby.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column
    private LocalDate dob;

    @Column(length = 1)
    private String gender;

    @Column(length = 500)
    private String address;

    @Column(length = 255)
    private String photo;

    @Column(length = 100, unique = true)
    private String username; // Username field

    // Tambahkan method untuk mendapatkan password
    // Tambahkan method untuk mengatur password
    @Getter
    @Setter
    @Column
    private String password; // Tambahkan password field

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    @Column
    private String createdBy;

    @Column
    private String updatedBy;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

}
