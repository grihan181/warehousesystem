package course.work.database.model;

import javax.persistence.*;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Сотрудник_компании")
public class CompanyEmployee {
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Status status;

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

    @Column(name = "Логин")
    private String login;

    @Column(name = "Пароль")
    private String password;

}
