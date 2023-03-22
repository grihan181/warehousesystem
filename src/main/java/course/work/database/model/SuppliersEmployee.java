package course.work.database.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Сотрудник_поставщика")
public class SuppliersEmployee {
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
    private Timestamp dateOfBirth;

    @Column(name = "Адрес")
    private String address;

    @Column(name = "Сотовый_телефон")
    private String phoneNumber;

    @Column(name = "Электронный_адрес")
    private String email;
}
