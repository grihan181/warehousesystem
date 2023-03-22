package course.work.database.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Сотрудник_компании")
public class CompanyEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Фамилия")
    private String surname;

    @Column(name = "Имя")
    private String name;

    @Column(name = "Отчество")
    private String patronymic;

    @Column(name = "Должность")
    private String position;

    @Column(name = "Дата_рождения")
    private LocalDate dateOfBirth;

    @Column(name = "Адрес")
    private String address;

    @Column(name = "Сотовый_телефон")
    private String phoneNumber;

    @Column(name = "Электронный_адрес")
    private String email;
}
